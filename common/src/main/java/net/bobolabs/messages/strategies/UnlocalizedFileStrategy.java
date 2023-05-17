package net.bobolabs.messages.strategies;

import net.bobolabs.config.Configuration;
import net.bobolabs.config.ConfigurationBuilder;
import net.bobolabs.messages.AbstractEzLangLoader;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.text.MessageFormat;
import java.util.Locale;
public class UnlocalizedFileStrategy extends AbstractEzLangLoader {

    private final Locale locale;

    public UnlocalizedFileStrategy(@NotNull Locale locale, @NotNull MiniMessage miniMessage, @NotNull File langs) {
        super(locale, miniMessage, langs);
        this.locale = locale;
    }

    @Override
    protected void load(@NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull TranslationRegistry registry) {
        if (langs.isFile() && langs.exists()) {
            Configuration config = ConfigurationBuilder.fromFile(langs).build();
            for (String key : config.getKeys(true)) {
                String message = config.getString(key);
                registry.register(key, locale, new MessageFormat(message));
            }
        }
    }

}
