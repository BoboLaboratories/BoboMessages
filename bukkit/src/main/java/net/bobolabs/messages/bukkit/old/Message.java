package net.bobolabs.messages.bukkit.old;

import net.bobolabs.messages.EzComponent;
import net.bobolabs.messages.EzSendableComponent;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Predicate;

public class Message extends EzComponent<CommandSender> {

    protected Message(@NotNull ComponentLike component) {
        super(component);
    }

    @Override
    public @NotNull EzSendableComponent filter(@NotNull String key, @NotNull Predicate<CommandSender> filter) {
        Component message = getComponent();
        Audience audience =

        return null;
    }

    @Override
    public @NotNull EzSendableComponent permission(@NotNull String key, @NotNull String permission) {
        return null;
    }

    @Override
    public @NotNull EzSendableComponent sender(@NotNull CommandSender sender, @NotNull String key) {
        return null;
    }

    @Override
    public @NotNull EzSendableComponent sender(@NotNull UUID sender, @NotNull String key) {
        return null;
    }

    @Override
    public @NotNull EzSendableComponent broadcast(@NotNull String key) {
        return null;
    }

    @Override
    public @NotNull EzSendableComponent console(@NotNull String key) {
        return null;
    }

}
