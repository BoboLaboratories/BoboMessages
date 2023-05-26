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

public class LocalizedDirectoryStrategy extends AbstractEzLangLoader {
    protected LocalizedDirectoryStrategy(@NotNull Locale locale, @NotNull MiniMessage miniMessage, @NotNull File langs) {
        super(locale, miniMessage, langs);
    }

    @Override
    protected void load(@NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull TranslationRegistry registry) {

        try (Stream<Path> stream = Files.list(langs.toPath())) {
            List<Path> files = stream
                    .filter(Files::isDirectory)
                    .toList();

            for (Path file : files) {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        try (Stream<Path> stream = Files.list(langs.toPath())) {
            List<Path> commons = stream.filter(path -> path.endsWith(".yml")).toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
