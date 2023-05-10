package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase0;
import net.bobolabs.messages.EzAdventureOptions;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class BukkitEzAdventure extends AbstractEzAdventurePhase0<CommandSender, BukkitEzAdventurePhase1, BukkitEzAdventurePhase2, BukkitEzAdventurePhase3> {

    private final EzAdventureOptions options;
    private final JavaPlugin plugin;

    public BukkitEzAdventure(@NotNull JavaPlugin plugin, @NotNull EzAdventureOptions options) {
        this.plugin = plugin;
        this.options = options;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase1 sync() {
        return new BukkitEzAdventurePhase1(false);
    }

    @Override
    public @NotNull BukkitEzAdventurePhase1 async() {
        return new BukkitEzAdventurePhase1(true);
    }

}
