package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface Replacer<A, T> {

    @NotNull T replace(@NotNull CharSequence target, @NotNull Object replacement);

    @NotNull T replace(@NotNull CharSequence target, @NotNull Function<A, Object> replacement);

    @NotNull T replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement);

    @NotNull T replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement);

    @NotNull T replace(@NotNull UnaryOperator<String> replacement);

}
