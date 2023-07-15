package net.bobolabs.messages.lang;

import net.bobolabs.messages.strategies.UnlocalizedFileStrategy;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LangLoader {

    private static final Set<Locale> AVAILABLE_LOCALES = Set.of(Locale.getAvailableLocales());

    public void load(@NotNull File langDirectory) {
        // Bisogna loaddare global.properties prima e usarlo per popolare le variabili
        // Poi bisogna loaddare i singoli locale e separare variabili da traduzioni
        // Poi bisogna fare il merge delle variabili
        // E infine sostituire le variabili nelle traduzioni

        Path path = langDirectory.toPath();
        try (Stream<Path> stream = Files.list(path)) {
            PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.properties");
            Set<File> files = stream
                    .filter(Files::isRegularFile)
                    .filter(matcher::matches)
                    .map(Path::toFile)
                    .collect(Collectors.toSet());

            for (File file : files) {
                String fileName = file.getName();
                fileName = fileName.substring(0, fileName.lastIndexOf('.'));
                Locale locale = Locale.forLanguageTag(fileName.replace('_', '-'));
                if (AVAILABLE_LOCALES.contains(locale)) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
