package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextReplacementConfig;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.MatchResult;

public class ComponentReplacer<A> implements Replacer<A, ComponentLike> {

    // TODO:

    @Override
    public @NotNull ComponentLike replace(@NotNull CharSequence literal, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replace(@NotNull CharSequence literal, @NotNull Function<A, Object> replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replace(@NotNull String pattern, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replace(@NotNull String pattern, @NotNull BiFunction<MatchResult, A, Object> replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replaceTimes(@NotNull String regex, @NotNull Object replacement, int times) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replace(@NotNull Consumer<TextReplacementConfig.Builder> replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replace(@NotNull BiConsumer<A, TextReplacementConfig.Builder> replacement) {
        return null;
    }
}
