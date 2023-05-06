package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.function.UnaryOperator;

interface Message<T, U extends AbstractMessage<T, U>> {

    @NotNull Message<T, U> replace(@NotNull CharSequence target, @NotNull Object replacement);

    @NotNull Message<T, U> replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement);

    @NotNull Message<T, U> replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement);

    @NotNull Message<T, U> replace(@NotNull UnaryOperator<String> replacement);

    void send();

}

