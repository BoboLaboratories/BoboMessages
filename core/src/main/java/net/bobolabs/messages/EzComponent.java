package net.bobolabs.messages;

import net.bobolabs.core.Check;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.Arrays;
import java.util.function.UnaryOperator;

// TODO add constructor with Collection<T> audience
public abstract class EzComponent<A extends Audience, C extends EzComponent<A, C>> {

    private String lines;

    protected EzComponent(@NotNull MiniMessage miniMessage, @NotNull A audience, @NotNull String... lines) {
        Check.argument(lines != null, "cannot construct empty message");
        this.lines = String.join("\n", Arrays.asList(lines));
        this.miniMessage = miniMessage;
        this.audience = audience;
    }

    public @NotNull EzComponent<A, C> replace(@NotNull CharSequence target, @NotNull Object replacement) {
        lines = lines.replace(target, replacement.toString());
        return this;
    }

    public @NotNull EzComponent<A, C> replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceAll(regex, replacement.toString());
        return this;
    }

    public @NotNull EzComponent<A, C> replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceFirst(regex, replacement.toString());
        return this;
    }

    public @NotNull EzComponent<A, C> replace(@NotNull UnaryOperator<String> replacement) {
        lines = replacement.apply(lines);
        return this;
    }

    public final @NotNull Component unezify() {

    }

}
