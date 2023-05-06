package net.bobolabs.messages;

import net.kyori.adventure.text.minimessage.MiniMessage;

import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.Arrays;
import java.util.function.UnaryOperator;

// TODO qui perche' sono qui, permettere agli utilizzatori della libreria di fornire il loro minimessage al manager
// TODO add constructor with Collection<T> audience
public abstract class AbstractMessage<T> {

    private final MiniMessage miniMessage;
    private final T audience;
    private String lines;

    protected AbstractMessage(@NotNull MiniMessage miniMessage, @NotNull T audience, @NotNull String... lines) {
        if (lines.length == 0) {
            throw new IllegalArgumentException("Cannot construct an empty message");
        }
        this.lines = String.join("\n", Arrays.asList(lines));
        this.miniMessage = miniMessage;
        this.audience = audience;
    }

    public @NotNull AbstractMessage<T> replace(@NotNull CharSequence target, @NotNull Object replacement) {
        lines = lines.replace(target, replacement.toString());
        return this;
    }

    public @NotNull AbstractMessage<T> replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceAll(regex, replacement.toString());
        return this;
    }

    public @NotNull AbstractMessage<T> replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceFirst(regex, replacement.toString());
        return this;
    }

    public @NotNull AbstractMessage<T> replace(@NotNull UnaryOperator<String> replacement) {
        lines = replacement.apply(lines);
        return this;
    }

    public void send() {
        send(audience, lines);
    }

    protected abstract void send(@NotNull T audience, @NotNull String message);

}
