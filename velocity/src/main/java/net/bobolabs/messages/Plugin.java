package net.bobolabs.messages;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.nio.file.Path;

@com.velocitypowered.api.plugin.Plugin(id = "Test", name = "Test", version = "1.0",
        description = "Test stuff", authors = {"BoboLabs"})
public class Plugin {


    private final ProxyServer server;
    private final Logger logger;
    private final Path dataDirectory;

    @Inject
    public Plugin(
            @NotNull ProxyServer server,
            @NotNull Logger logger,
            @DataDirectory @NotNull Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(@NotNull ProxyInitializeEvent event) {
        // On Enable

        VelocityEzAdventure ezAdventure = new VelocityEzAdventure(server, null);
    }


}
