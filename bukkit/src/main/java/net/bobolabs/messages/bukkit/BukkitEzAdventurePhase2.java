package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase2;
import net.bobolabs.messages.InstanceEzAdventurePhase2;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BukkitEzAdventurePhase2
        extends AbstractEzAdventurePhase2<CommandSender, BukkitEzAdventurePhase3>
        implements InstanceEzAdventurePhase2<CommandSender, BukkitEzAdventurePhase3, World> {

    @Override
    public @NotNull BukkitEzAdventurePhase3 filter(@NotNull Predicate<CommandSender> filter) {
        return new BukkitEzAdventurePhase3(() ->
                Bukkit.getOnlinePlayers().stream().filter(filter).collect(Collectors.toList()));
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 permission(@NotNull String key) {
        return filter(player -> player.hasPermission(key));
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 sender(@NotNull CommandSender sender) {
        return new BukkitEzAdventurePhase3(() -> List.of(sender));
    }

    // TODO: Gestire NullPointer
    @Override
    public @NotNull BukkitEzAdventurePhase3 sender(@NotNull UUID sender) {
        return new BukkitEzAdventurePhase3(() -> List.of(Bukkit.getPlayer(sender)));
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 broadcast() {
        return filter(sender -> true);
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 console() {
        return sender(Bukkit.getConsoleSender());
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 world(@NotNull String world) {
        return filter(sender -> sender instanceof Player player && player.getWorld().getName().equals(world));
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 world(@NotNull World world) {
        return world(world.getName());
    }

}
