package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.Message;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BukkitMessage extends Message<Player> {

    BukkitMessage(@NotNull MiniMessage miniMessage, @NotNull Player audience, @NotNull String... lines) {
        super(miniMessage, audience, lines);
    }

    @Override
    protected void send(@NotNull Player audience, @NotNull String message) {

    }

}
