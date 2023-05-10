package net.bobolabs.messages;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

// TODO add constructor with Collection<T> audience
public final class EzSendableComponent extends EzComponent {

    private final Audience audience;

    EzSendableComponent(@NotNull Audience audience, @NotNull Component component) {
        super(component);
        this.audience = audience;
    }

    public void send() {
        audience.sendMessage(getComponent());
    }

}
