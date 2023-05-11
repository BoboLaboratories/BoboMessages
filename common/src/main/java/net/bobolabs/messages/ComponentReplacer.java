package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ComponentReplacer<A> implements Replacer<A, ComponentLike> {

    @Override
    public @NotNull ComponentLike replace(@NotNull CharSequence literal, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replace(@NotNull CharSequence literal, @NotNull Function<A, Object> replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replaceAll(@NotNull String pattern, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replaceFirst(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull ComponentLike replace(@NotNull UnaryOperator<String> replacement) {
        return null;
    }

}
