package net.bobolabs.messages;

import net.bobolabs.core.Check;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public abstract class EzComponent<T> {

    private String lines;
    List<Function<EzComponent<T>, EzComponent<T>>> replacements;

    protected EzComponent(@NotNull ComponentLike component) {
        Check.argument(lines != null, "cannot construct empty message");
        this.lines = String.join("\n", Arrays.asList(lines));
        this.audience = audience;
    }

    public @NotNull EzComponent replace(@NotNull CharSequence target, @NotNull Object replacement) {
        lines = lines.replace(target, replacement.toString());
        return this;
    }

    public @NotNull EzComponent replace(@NotNull CharSequence target, @NotNull Function<T, Object> replacement) {
        lines = lines.replace(target, replacement.apply());
        return this;
    }

    public @NotNull EzComponent replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceAll(regex, replacement.toString());
        return this;
    }

    public @NotNull EzComponent replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement) {
        lines = lines.replaceFirst(regex, replacement.toString());
        return this;
    }

    public @NotNull EzComponent replace(@NotNull UnaryOperator<String> replacement) {
        lines = replacement.apply(lines);
        return this;
    }

    public final @NotNull Component unezify() {

    }

    protected @NotNull Component getComponent() {
        for (Function<EzComponent<T>, EzComponent<T>> replacement : replacements) {

        }
    }

    public abstract @NotNull EzSendableComponent filter(@NotNull String key, @NotNull Predicate<T> filter);

    public abstract @NotNull EzSendableComponent permission(@NotNull String key, @NotNull String permission);

    public abstract @NotNull EzSendableComponent sender(@NotNull T sender, @NotNull String key);

    public abstract @NotNull EzSendableComponent sender(@NotNull UUID sender, @NotNull String key);

    public abstract @NotNull EzSendableComponent broadcast(@NotNull String key);

    public abstract @NotNull EzSendableComponent console(@NotNull String key);

}
