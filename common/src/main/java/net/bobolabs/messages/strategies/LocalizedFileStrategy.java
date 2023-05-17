package net.bobolabs.messages.strategies;

import net.bobolabs.messages.AbstractEzLangLoader;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class LocalizedFileStrategy extends AbstractEzLangLoader {

    protected LocalizedFileStrategy(@NotNull Locale locale, @NotNull MiniMessage miniMessage, @NotNull File langs) {
        super(locale, miniMessage, langs);
    }

    @Override
    protected void load(@NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull TranslationRegistry registry) {
        try (Stream<Path> stream = Files.list(langs.toPath())) {
            List<File> files = stream
                    .filter(p -> !Files.isDirectory(p))
                    .filter(path -> path.endsWith(".yml"))
                    .map(Path::toFile)
                    .toList();

            for (File file : files) {
                String[] splitted = file.getName().split("\\.");
                Locale locale = Locale.forLanguageTag(splitted[splitted.length - 2]);
                if (isLocaleValid(locale)) {
                    // TODO:
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
