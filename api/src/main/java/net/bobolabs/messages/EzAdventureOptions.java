package net.bobolabs.messages;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Locale;

public class EzAdventureOptions implements EzAdventureConfigurable {

    private final String namespace;
    private final Locale locale;
    private final File langs;

    private LangLoadStrategy langLoadStrategy = LangLoadStrategy.SIMPLE;
    private @Nullable MiniMessage miniMessage;

    private EzAdventureOptions(@NotNull String namespace, @NotNull File langs, @NotNull Locale locale) {
        this.namespace = namespace;
        this.locale = locale;
        this.langs = langs;
    }

    public @NotNull EzAdventureOptions langLoadStrategy(@NotNull LangLoadStrategy langLoadStrategy) {
        this.langLoadStrategy = langLoadStrategy;
        return this;
    }

    public @NotNull EzAdventureOptions miniMessage(@NotNull MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
        return this;
    }

    public @NotNull String getNamespace() {
        return namespace;
    }

    public @NotNull Locale getDefaultLocale() {
        return locale;
    }

    public @NotNull File getLangs() {
        return langs;
    }

    public @Nullable LangLoadStrategy getLangLoadStrategy() {
        return langLoadStrategy;
    }

    public @Nullable MiniMessage getMiniMessage() {
        return miniMessage;
    }

    public static class Builder {

        private String namespace;
        private Locale locale;
        private File langs;

        private LangLoadStrategy langLoadStrategy = LangLoadStrategy.SIMPLE;
        private @Nullable MiniMessage miniMessage;

        public Builder() {
        }

        public @NotNull EzAdventureOptionsNamespace langs(@NotNull File langs) {
            return new EzAdventureOptionsNamespace(langs);
        }

        public @NotNull Builder langLoadStrategy(@NotNull LangLoadStrategy langLoadStrategy) {
            this.langLoadStrategy = langLoadStrategy;
            return this;
        }

        public @NotNull Builder miniMessage(@NotNull MiniMessage miniMessage) {
            this.miniMessage = miniMessage;
            return this;
        }
    }


    public static class EzAdventureOptionsNamespace extends Builder {
        private final File langs;

        private EzAdventureOptionsNamespace(@NotNull File langs) {
            this.langs = langs;
        }

        public @NotNull EzAdventureOptionsLangs namespace(@NotNull String namespace) {
            return new EzAdventureOptionsLangs(namespace, langs);
        }
    }


    public static class EzAdventureOptionsLangs extends Builder {
        private final String namespace;
        private final File langs;

        private EzAdventureOptionsLangs(@NotNull String namespace, @NotNull File langs) {
            this.namespace = namespace;
            this.langs = langs;
        }

        public @NotNull EzAdventureOptions locale(@NotNull Locale locale) {
            return new EzAdventureOptions(namespace, langs, locale);
        }
    }

}
