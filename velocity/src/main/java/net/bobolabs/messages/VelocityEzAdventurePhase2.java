package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VelocityEzAdventurePhase2
        extends AbstractEzAdventurePhase2<CommandSource, VelocityEzAdventurePhase3>
        implements ProxyEzAdventurePhase2<CommandSource, VelocityEzAdventurePhase3, RegisteredServer> {

    private final ProxyServer proxyServer;

    // TODO: Si può fare?
    public VelocityEzAdventurePhase2(@NotNull ProxyServer server) {
        super(componentSupplier);
        this.proxyServer = server;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 filter(@NotNull Predicate<CommandSource> filter) {
        return new VelocityEzAdventurePhase3(() ->
                proxyServer.getAllPlayers().stream().filter(filter).collect(Collectors.toList()));
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 server(@NotNull RegisteredServer server) {
        return filter(sender -> sender instanceof Player player &&
                player.getCurrentServer().isPresent() &&
                player.getCurrentServer().get().getServer().equals(server));
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 permission(@NotNull String key) {
        return filter(sender -> sender.hasPermission(key));
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 sender(@NotNull CommandSource sender) {
        return new VelocityEzAdventurePhase3(() -> List.of(sender));
    }

    // TODO: Gestire l'Optional
    @Override
    public @NotNull VelocityEzAdventurePhase3 sender(@NotNull UUID sender) {
        return sender(proxyServer.getPlayer(sender).get());
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 broadcast() {
        return filter(sender -> true);
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 console() {
        return sender(proxyServer.getConsoleCommandSource());
    }
}
