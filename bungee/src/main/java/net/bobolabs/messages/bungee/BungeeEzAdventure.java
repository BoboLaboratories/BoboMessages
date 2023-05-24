package net.bobolabs.messages.bungee;

import net.bobolabs.messages.AbstractEzAdventure;
import net.bobolabs.messages.EzAdventureOptions;
import net.kyori.adventure.platform.bungeecord.BungeeAudiences;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class BungeeEzAdventure extends AbstractEzAdventure<CommandSender, BungeeEzAdventurePhase1, BungeeEzAdventurePhase2, BungeeEzAdventurePhase3> {

    private final BungeeAudiences audiences;

    public BungeeEzAdventure(@NotNull Plugin plugin, @NotNull EzAdventureOptions options) {
        this(BungeeAudiences.create(plugin), options);
    }

    public BungeeEzAdventure(@NotNull BungeeAudiences audiences, @NotNull EzAdventureOptions options) {
        super(options);
        this.audiences = audiences;
    }

    @Override
    public @NotNull BungeeEzAdventurePhase1 sync() {
        return new BungeeEzAdventurePhase1(this, false);
    }

    @Override
    public @NotNull BungeeEzAdventurePhase1 async() {
        return new BungeeEzAdventurePhase1(this, true);
    }

    @Override
    public @NotNull Locale getLocale(@NotNull CommandSender audience) {
        return audience instanceof ProxiedPlayer player ? player.getLocale() : getDefaultLocale();
    }

    @NotNull BungeeAudiences getAudiences() {
        return audiences;
    }
}
