package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventure;
import net.bobolabs.messages.EzAdventureOptions;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public final class BukkitEzAdventure extends AbstractEzAdventure<CommandSender, BukkitEzAdventurePhase1, BukkitEzAdventurePhase2, BukkitEzAdventurePhase3> {

    private final JavaPlugin plugin;

    public BukkitEzAdventure(@NotNull JavaPlugin plugin, @NotNull EzAdventureOptions options) {
        super(options);
        this.plugin = plugin;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase1 sync() {
        return new BukkitEzAdventurePhase1(this, false);
    }

    @Override
    public @NotNull BukkitEzAdventurePhase1 async() {
        return new BukkitEzAdventurePhase1(this, true);
    }

    @Override
    public @NotNull Locale getLocale(@NotNull CommandSender audience) {
        return audience instanceof Player player ? player.locale() : getDefaultLocale();
    }

}
