package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface EzAdventurePhase3<A, P3 extends EzAdventurePhase3<A, P3>> {

    @NotNull P3 replace(@NotNull CharSequence target, @NotNull Object replacement);

    @NotNull P3 replace(@NotNull CharSequence target, @NotNull Function<A, Object> replacement);

    @NotNull P3 replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement);

    @NotNull P3 replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement);

    @NotNull P3 replace(@NotNull UnaryOperator<String> replacement);

    void send();

}
