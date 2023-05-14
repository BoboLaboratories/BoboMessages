package net.bobolabs.messages.strategies;

import net.bobolabs.messages.AbstractEzLangLoader;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;

public class UnlocalizedDirectoryStrategy extends AbstractEzLangLoader {

    private final Locale locale;

    protected UnlocalizedDirectoryStrategy(@NotNull Locale locale, @NotNull MiniMessage miniMessage, @NotNull File langs) {
        super(locale, miniMessage, langs);
        this.locale = locale;
    }

    @Override
    protected void load(@NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull TranslationRegistry registry) {
        if (langs.isDirectory() && langs.exists()) {
            for (File file : langs.listFiles()) {
                if (file.isFile()) {
                    UnlocalizedFileStrategy fileStrategy = new UnlocalizedFileStrategy(locale, miniMessage, langs);
                    fileStrategy.load(miniMessage, langs, registry);
                }
            }
        }
    }

}
