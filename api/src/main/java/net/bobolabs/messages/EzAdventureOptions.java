package net.bobolabs.messages;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Locale;

public final class EzAdventureOptions implements EzAdventureConfigurable {

    private Locale defaultLocale;
    private String namespace;
    private File langSource;

    private @Nullable MiniMessage miniMessage;

    private EzAdventureOptions() {}

    public static @NotNull EzAdventureOptions.Builder builder() {
        return new EzAdventureOptions.Builder(new EzAdventureOptions());
    }

    @Override
    public @NotNull String getNamespace() {
        return null;
    }

    @Override
    public @NotNull Locale getDefaultLocale() {
        return null;
    }

    @Override
    public @NotNull File getLangs() {
        return null;
    }

    @Override
    public MiniMessage miniMessage() {
        return null;
    }

    public static class Builder {

        private final EzAdventureOptions options;

        private Builder(@NotNull EzAdventureOptions options) {
            this.options = options;
        }

        public @NotNull Builder namespace(@NotNull String namespace) {
            options.namespace = namespace;
            return this;
        }

        public @NotNull Builder langSource(@NotNull File langSource) {
            options.langSource = langSource;
            return this;
        }

        public @NotNull Builder defaultLocale(@NotNull Locale defaultLocale) {
            options.defaultLocale = defaultLocale;
            return this;
        }

        public @NotNull Builder miniMessage(@NotNull MiniMessage miniMessage) {
            options.miniMessage = miniMessage;
            return this;
        }

        public @NotNull EzAdventureOptions build() {
            checkArgument(options.namespace != null && !options.namespace.isBlank(), "invalid namespace");
            checkArgument(options.langSource != null, "lang source is required");
            checkArgument(options.defaultLocale);

            return options;
        }

        private void checkArgument(boolean condition, @NotNull String message) {
            if (!condition) {
                throw new IllegalArgumentException(message);
            }
        }
    }

}
