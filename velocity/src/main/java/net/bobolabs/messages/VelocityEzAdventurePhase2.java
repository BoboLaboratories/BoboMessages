package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.ServerConnection;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class VelocityEzAdventurePhase2
        extends AbstractEzAdventurePhase2<CommandSource, VelocityEzAdventurePhase3>
        implements ProxyEzAdventurePhase2<CommandSource, VelocityEzAdventurePhase3, RegisteredServer> {

    private final VelocityEzAdventure ezAdventure;
    private final ProxyServer server;

    public VelocityEzAdventurePhase2(@NotNull ProxyServer server,
                                     @NotNull VelocityEzAdventure ezAdventure,
                                     @NotNull Function<@NotNull CommandSource, @NotNull ComponentLike> componentSupplier) {
        super(componentSupplier);
        this.ezAdventure = ezAdventure;
        this.server = server;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 filter(@NotNull Predicate<CommandSource> filter) {
        return new VelocityEzAdventurePhase3(ezAdventure, () -> {
            List<CommandSource> filtered = new ArrayList<>();
            for (Player player : server.getAllPlayers()) {
                if (filter.test(player)) {
                    filtered.add(player);
                }
            }
            return filtered;
        }, getComponentSupplier());
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 permission(@NotNull String key) {
        return filter(player -> player.hasPermission(key));
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 sender(@NotNull CommandSource sender) {
        return new VelocityEzAdventurePhase3(ezAdventure, () -> List.of(sender), getComponentSupplier());
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 sender(@NotNull UUID sender) {
        return new VelocityEzAdventurePhase3(ezAdventure, () -> {
            Optional<Player> playerOptional = server.getPlayer(sender);
            if (playerOptional.isPresent()) {
                CommandSource player = playerOptional.get();
                return List.of(player);
            } else {
                return new ArrayList<>();
            }
        }, getComponentSupplier());
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 broadcast() {
        return filter(sender -> true);
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 console() {
        return sender(server.getConsoleCommandSource());
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 servers(@NotNull Collection<@NotNull RegisteredServer> servers) {
        return filter(sender -> {
            if (sender instanceof Player player) {
                Optional<ServerConnection> connection = player.getCurrentServer();
                if (connection.isPresent()) {
                    return servers.contains(connection.get().getServer());
                }
            }
            return false;
        });
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 server(@NotNull RegisteredServer server) {
        return servers(List.of(server));
    }
}
