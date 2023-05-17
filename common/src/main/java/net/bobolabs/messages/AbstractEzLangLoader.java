package net.bobolabs.messages;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;
import java.util.Set;

public abstract class AbstractEzLangLoader implements EzLangLoader {

    private static final Set<Locale> existingLocales = Set.of(Locale.getAvailableLocales());

    private final MiniMessage miniMessage;
    private final File langs;
    private final Locale locale;

    protected AbstractEzLangLoader(@NotNull Locale locale, @NotNull MiniMessage miniMessage, @NotNull File langs) {
        this.miniMessage = miniMessage;
        this.langs = langs;
        this.locale = locale;
    }

    @Override
    public final void load(@NotNull TranslationRegistry registry) {
        load(miniMessage, langs, registry);
    }

    protected abstract void load(@NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull TranslationRegistry registry);

    protected boolean isLocaleValid(@NotNull Locale locale) {
        return existingLocales.contains(locale);
    }

}
