package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractMessage;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Message extends AbstractMessage<CommandSender, Message> {

    Message(@NotNull MiniMessage miniMessage, @NotNull CommandSender audience, @NotNull String... lines) {
        super(miniMessage, audience, lines);
    }

    @Override
    protected void send(@NotNull CommandSender audience, @NotNull String message) {

    }

}
