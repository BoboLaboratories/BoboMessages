package net.bobolabs.messages.bungee;

import net.bobolabs.messages.AbstractEzAdventurePhase2;
import net.bobolabs.messages.ProxyEzAdventurePhase2;
import net.kyori.adventure.text.ComponentLike;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class BungeeEzAdventurePhase2
        extends AbstractEzAdventurePhase2<CommandSender, BungeeEzAdventurePhase3>
        implements ProxyEzAdventurePhase2<CommandSender, BungeeEzAdventurePhase3, Server> {

    private final BungeeEzAdventure ezAdventure;

    public BungeeEzAdventurePhase2(@NotNull BungeeEzAdventure ezAdventure,
                                   @NotNull Function<@NotNull CommandSender, @NotNull ComponentLike> componentSupplier) {
        super(componentSupplier);
        this.ezAdventure = ezAdventure;
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 filter(@NotNull Predicate<CommandSender> filter) {
        return new BungeeEzAdventurePhase3(ezAdventure, () -> {
            List<CommandSender> filtered = new ArrayList<>();
            for (CommandSender sender : ProxyServer.getInstance().getPlayers()) {
                if (filter.test(sender)) {
                    filtered.add(sender);
                }
            }
            return filtered;
        }, getComponentSupplier());
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 permission(@NotNull String key) {
        return filter(player -> player.hasPermission(key));
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 sender(@NotNull CommandSender sender) {
        return new BungeeEzAdventurePhase3(ezAdventure, () -> List.of(sender), getComponentSupplier());
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 sender(@NotNull UUID sender) {
        return new BungeeEzAdventurePhase3(ezAdventure, () -> {
            CommandSender player = ProxyServer.getInstance().getPlayer(sender);
            return player != null ? List.of(player) : Collections.emptyList();
        }, getComponentSupplier());
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 broadcast() {
        return filter(sender -> true);
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 console() {
        return sender(ProxyServer.getInstance().getConsole());
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 server(@NotNull Server server) {
        return servers(List.of(server));
    }

    @Override
    public @NotNull BungeeEzAdventurePhase3 servers(@NotNull Collection<@NotNull Server> servers) {
        return filter(sender -> {
            if (sender instanceof ProxiedPlayer player) {
                Server currentServer = player.getServer();
                return servers.contains(currentServer);
            }
            return false;
        });
    }
}
