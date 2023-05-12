package net.bobolabs.plugin;

import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ConsoleCommandSource;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.bobolabs.messages.EzAdventureOptions;
import net.bobolabs.messages.VelocityEzAdventure;
import net.bobolabs.messages.VelocityEzUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Optional;

@Plugin(id = "messageplugin", name = "MessagePlugin", version = "1.0",
        description = "Bobolabs test stuff", authors = {"Bobolabs"})
public class MessagePlugin {
    private final ProxyServer server;
    private final Logger logger;
    private final Path dataDirectory;

    @Inject
    public MessagePlugin(
            @NotNull ProxyServer server,
            @NotNull Logger logger,
            @DataDirectory @NotNull Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(@NotNull ProxyInitializeEvent event) {

        EzAdventureOptions opt = new EzAdventureOptions.Builder()

                .langs(new File(dataDirectory.toFile(), "lang.yml"))
                .namespace("boboplugin-velocity")
                .locale(Locale.CANADA);


        VelocityEzAdventure ezAdventure = new VelocityEzAdventure(server, opt);
        ezAdventure.onEnable();

        Optional<Player> player = server.getPlayer("Staminal");
        if (player.isPresent()) {
            ezAdventure.sync()
                    .lang("fancy-message")
                    .broadcast()
                    .replace("%replace%", VelocityEzUtils::getSourceName)
                    .send();

        }

        ezAdventure.onDisable();
    }


    @Subscribe
    public void onProxyShutdown(@NotNull ProxyShutdownEvent event) {
    }


}
