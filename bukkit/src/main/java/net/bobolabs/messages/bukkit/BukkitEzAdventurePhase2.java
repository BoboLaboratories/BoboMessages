package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.InstanceEzAdventurePhase2;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Predicate;

public class BukkitEzAdventurePhase2 implements InstanceEzAdventurePhase2<CommandSender, BukkitEzAdventurePhase3, World> {

    @Override
    public @NotNull BukkitEzAdventurePhase3 filter(@NotNull Predicate<CommandSender> filter) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 permission(@NotNull String key) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 sender(@NotNull CommandSender sender) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 sender(@NotNull UUID sender) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 broadcast() {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 console() {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 world(@NotNull String world) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 world(@NotNull World world) {
        return null;
    }

}
