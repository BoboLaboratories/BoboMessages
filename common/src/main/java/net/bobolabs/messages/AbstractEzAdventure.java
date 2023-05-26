package net.bobolabs.messages;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;

import static net.bobolabs.core.Utils.coalesce;

public abstract class AbstractEzAdventure<A,
        P1 extends EzAdventurePhase1<A, P2, P3>,
        P2 extends EzAdventurePhase2<A, P3>,
        P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase0<A, P1, P2, P3> {

    private final EzAdventureOptions options;

    private TranslationRegistry translationRegistry;
    private MiniMessage miniMessage;

    protected AbstractEzAdventure(@NotNull EzAdventureOptions options) {
        this.options = options;
    }

    @Override
    public void onEnable() {
        Key key = Key.key(getNamespace(), "main");
        translationRegistry = TranslationRegistry.create(key);
        translationRegistry.defaultLocale(getDefaultLocale());

        miniMessage = coalesce(options.miniMessage(), MiniMessage::miniMessage);
        GlobalTranslator.translator().addSource(translationRegistry);
    }

    @Override
    public void onDisable() {
        if (translationRegistry != null) {
            GlobalTranslator.translator().removeSource(translationRegistry);
            translationRegistry = null;
        }
    }

    @Override
    public @NotNull P2 lang(@NotNull String key) {
        return sync().lang(key);
    }

    @Override
    public @NotNull P2 component(@NotNull ComponentLike component) {
        return sync().component(component);
    }

    @Override
    public @NotNull P2 text(@NotNull String text) {
        return sync().text(text);
    }

    @Override
    public @NotNull P2 text(@NotNull String[] text) {
        return sync().text(text);
    }

    @Override
    public @NotNull P2 text(@NotNull Collection<String> text) {
        return sync().text(text);
    }

    @Override
    public final @NotNull Locale getDefaultLocale() {
        return options.getDefaultLocale();
    }

    @Override
    public final @NotNull String getNamespace() {
        return options.getNamespace();
    }

    @Override
    public final @NotNull File getLangs() {
        return options.getLangs();
    }

    @Override
    public final @NotNull LangLoadStrategy getLangLoadStrategy() {
        // TODO: Grosso come una casa
        return coalesce(options.getLangLoadStrategy(), () -> LangLoadStrategy.SIMPLE);
    }

    @Override
    public final @NotNull MiniMessage miniMessage() {
        return miniMessage;
    }

    @Override
    public final @NotNull ComponentLike getLocalizedComponent(@NotNull A audience, @NotNull String key) {
        Locale locale = coalesce(getLocale(audience), this::getDefaultLocale);
        return getLocalizedComponent(locale, key);
    }

    @Override
    public final @NotNull ComponentLike getLocalizedComponent(@NotNull Locale locale, @NotNull String key) {
        String str = Objects.requireNonNull(translationRegistry.translate(key, locale)).toPattern();
        return miniMessage.deserialize(str);
    }

}
