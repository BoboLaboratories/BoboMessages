package net.bobolabs.messages;

import net.bobolabs.core.Reloadable;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public interface EzAdventurePhase0<A,
        P1 extends EzAdventurePhase1<A, P2, P3>,
        P2 extends EzAdventurePhase2<A, P3>,
        P3 extends EzAdventurePhase3<A, P3>> extends EzAdventurePhase1<A, P2, P3>, Reloadable {

    @NotNull P1 sync();

    @NotNull P1 async();

    @NotNull MiniMessage miniMessage();

    @NotNull ComponentLike getLocalizedComponent(@NotNull A audience, @NotNull String key);

    @NotNull ComponentLike getLocalizedComponent(@NotNull Locale locale, @NotNull String key);

    @NotNull Locale getLocale(@NotNull A audience);

}
