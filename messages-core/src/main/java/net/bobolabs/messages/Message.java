package net.bobolabs.messages;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;

// TODO qui perche' sono qui, permettere agli utilizzatori della libreria di fornire il loro minimessage al manager
// TODO add constructor with Collection<T> audience
public abstract class Message<T> {

    private final MiniMessage miniMessage;
    private final T audience;
    private String lines;

    protected Message(@NotNull MiniMessage miniMessage, @NotNull T audience, @NotNull String... lines) {
        if (lines.length == 0) {
            throw new IllegalArgumentException("Cannot construct an empty message");
        }
        this.lines = String.join("\n", Arrays.asList(lines));
        this.miniMessage = miniMessage;
        this.audience = audience;
    }

    public @NotNull Message<T> replace(@NotNull CharSequence target, @NotNull Object replacement) {
        lines = lines.replace(target, replacement.toString());
        return this;
    }

    public @NotNull Message<T> replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceAll(regex, replacement.toString());
        return this;
    }

    public @NotNull Message<T> replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceFirst(regex, replacement.toString());
        return this;
    }

    public @NotNull Message<T> replace(@NotNull UnaryOperator<String> replacement) {
        lines = replacement.apply(lines);
        return this;
    }

    public void send() {
        send(audience, lines);
    }

    protected abstract void send(@NotNull T audience, @NotNull String message);

}
