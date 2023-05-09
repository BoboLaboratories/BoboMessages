package net.bobolabs.messages;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import javax.annotation.RegEx;
import java.util.function.UnaryOperator;

// TODO add constructor with Collection<T> audience
public final class EzSendableComponent<T extends Audience, U extends EzComponent<T, U>> {

    private final U component;
    private final T audience;

    EzSendableComponent(@NotNull T audience, @NotNull U component) {
        this.component = component;
        this.audience = audience;
    }

    public @NotNull EzSendableComponent<T, U> replace(@NotNull CharSequence target, @NotNull Object replacement) {
        component.replace(target, replacement);
        return this;
    }

    public @NotNull EzSendableComponent<T, U> replaceAll(@NotNull @RegEx String regex, @NotNull Object replacement) {
        component.replace(regex, replacement);
        return this;
    }

    public @NotNull EzSendableComponent<T, U> replaceFirst(@NotNull @RegEx String regex, @NotNull Object replacement) {
        component.replace(regex, replacement);
        return this;
    }

    public @NotNull EzSendableComponent<T, U> replace(@NotNull UnaryOperator<String> replacement) {
        component.replace(replacement);
        return this;
    }

    public void send() {
        Component replaced = component.unezify();
        audience.sendMessage(replaced);
    }

}
