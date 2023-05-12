package net.bobolabs.messages;

import net.kyori.adventure.text.TextReplacementConfig;
import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.MatchResult;

public interface Replacer<A, T> {

    @NotNull T replace(@NotNull CharSequence literal, @NotNull Object replacement);

    @NotNull T replace(@NotNull CharSequence literal, @NotNull Function<A, Object> replacement);

    @NotNull T replace(@NotNull @RegExp String pattern, @NotNull Object replacement);

    @NotNull T replace(@NotNull @RegExp String pattern, @NotNull BiFunction<MatchResult, A, Object> replacement);

    @NotNull T replaceTimes(@NotNull @RegExp String regex, @NotNull Object replacement, int times);

    @NotNull T replace(@NotNull Consumer<TextReplacementConfig.Builder> replacement);

    @NotNull T replace(@NotNull BiConsumer<A, TextReplacementConfig.Builder> replacement);

}