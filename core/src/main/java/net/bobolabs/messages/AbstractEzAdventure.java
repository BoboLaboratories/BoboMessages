package net.bobolabs.messages;

import net.bobolabs.core.Check;
import net.bobolabs.messages.tmp.EzAdventure;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.text.MessageFormat;
import java.util.Locale;

import static net.bobolabs.core.Utils.coalesce;

public abstract class AbstractEzAdventure<T> implements EzAdventure<T>, EzAdventureConfigurable {

    private static final LangLoadStrategy DEFAULT_LANG_LOAD_STRATEGY = LangLoadStrategy.FILE;

    private final EzAdventureOptions options;
    private TranslationRegistry translations;

    protected AbstractEzAdventure(@NotNull EzAdventureOptions options) {
        this.options = options;
    }

    @Override
    public void onEnable() {
        Key key = Key.key(getNamespace(), "main");
        translations = TranslationRegistry.create(key);
        translations.defaultLocale(getDefaultLocale());

        GlobalTranslator.translator().addSource(translations);
    }

    @Override
    public void onDisable() {
        if (translations != null) {
            GlobalTranslator.translator().removeSource(translations);
            translations = null;
        }
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
        return coalesce(options.getLangLoadStrategy(), () -> DEFAULT_LANG_LOAD_STRATEGY);
    }

    // A Stami piace :D
    @Override
    public final @NotNull MiniMessage getMiniMessage() {
        return coalesce(options.getMiniMessage(), MiniMessage::miniMessage);
    }

    @Override
    public final @NotNull Component getComponent(@NotNull String key) {
        return getComponent(getDefaultLocale(), key);
    }

    @Override
    public final @NotNull Component getComponent(@NotNull Locale locale, @NotNull String key) {
        MessageFormat messageFormat = translations.translate(key, locale);
        Check.argument(messageFormat != null, () -> "unknown translation key " + key + " for locale " + locale);
        return getMiniMessage().deserialize(messageFormat.toPattern());
    }

    @Override
    public @NotNull EzComponent getEzComponent(@NotNull String key) {
        return null;
    }

    @Override
    public @NotNull EzComponent getEzComponent(@NotNull Locale locale, @NotNull String key) {
        return null;
    }

    @Override
    public @NotNull EzComponent ezify(@NotNull ComponentLike component) {
        return null;
    }

    protected abstract @Nullable Locale getLocale(@NotNull T audience);

}
