package net.bobolabs.messages.strategies;

import net.bobolabs.messages.AbstractEzLangLoader;
import net.bobolabs.messages.EzLangLoader;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class LocalizedDirectoryStrategy extends AbstractEzLangLoader {

    protected LocalizedDirectoryStrategy(@NotNull Locale locale, @NotNull MiniMessage miniMessage, @NotNull File langs) {
        super(locale, miniMessage, langs);
    }

    @Override
    protected void load(@NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull TranslationRegistry registry) {
        try (Stream<Path> dirStream = Files.list(langs.toPath())) {
            List<Path> directories = dirStream
                    .filter(Files::isDirectory)
                    .toList();

            for (Path directory : directories) {
                String dirName = String.valueOf(directory.getFileName());
                Locale locale = Locale.forLanguageTag(dirName.replace('_', '-'));
                EzLangLoader loader = new UnlocalizedDirectoryStrategy(locale, miniMessage, directory.toFile());
                loader.load(registry);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
}
