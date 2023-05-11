package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase2;
import net.bobolabs.messages.InstanceEzAdventurePhase2;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class BukkitEzAdventurePhase2
        extends AbstractEzAdventurePhase2<CommandSender, BukkitEzAdventurePhase3>
        implements InstanceEzAdventurePhase2<CommandSender, BukkitEzAdventurePhase3, World> {

    private final BukkitEzAdventure ezAdventure;

    protected BukkitEzAdventurePhase2(@NotNull BukkitEzAdventure ezAdventure, @NotNull Function<@NotNull CommandSender, @NotNull ComponentLike> componentSupplier) {
        super(componentSupplier);
        this.ezAdventure = ezAdventure;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 filter(@NotNull Predicate<CommandSender> filter) {
        return new BukkitEzAdventurePhase3(ezAdventure, () -> {
            List<CommandSender> filtered = new ArrayList<>();
            for (CommandSender sender : Bukkit.getOnlinePlayers()) {
                if (filter.test(sender)) {
                    filtered.add(sender);
                }
            }
            return filtered;
        }, getComponentSupplier());
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 permission(@NotNull String key) {
        return filter(player -> player.hasPermission(key));
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 sender(@NotNull CommandSender sender) {
        return new BukkitEzAdventurePhase3(ezAdventure, () -> List.of(sender), getComponentSupplier());
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 sender(@NotNull UUID sender) {
        return new BukkitEzAdventurePhase3(ezAdventure, () -> {
            CommandSender player = Bukkit.getPlayer(sender);
            return player != null ? List.of(player) : Collections.emptyList();
        }, getComponentSupplier());
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
