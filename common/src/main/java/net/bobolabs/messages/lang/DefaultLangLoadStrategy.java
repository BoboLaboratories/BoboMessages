package net.bobolabs.messages.lang;

import net.bobolabs.config.Configuration;
import net.bobolabs.config.ConfigurationBuilder;
import net.bobolabs.core.Check;
import net.bobolabs.messages.EzLangLoadStrategy;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Locale;

/*
    - lang.yml

    - lang/
        file1.yml
        file2.yml

    - lang/
        lang_en_US.yml
        lang_it_IT.yml

    - lang/
        en_US/
            file1.yml
            file2.yml
        it_IT/
            file1.yml
            file2.yml
        file3.yml
        file4.yml
*/

public final class DefaultLangLoadStrategy implements EzLangLoadStrategy {

    private static final Locale DEFAULT_LOCALE = Locale.forLanguageTag("default-DEFAULT");

    private final File langs;

    public DefaultLangLoadStrategy(@NotNull File langs) {
        this.langs = langs;
    }

    @Override
    public void load() {
        Check.argument(langs.exists(), "could not load " + langs + " file does not exist");

        if (Files.isDirectory(langs.toPath())) {
            visitDirectory(langs);
        } else {
            visitFile(langs);
        }
    }

    private void visitDirectory(@NotNull File langs) {
        try {
            Files.walkFileTree(langs.toPath(), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (!Files.isDirectory(file)) {
                        DefaultLangLoadStrategy.this.visitFile(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void visitFile(@NotNull File langs) {
        Configuration yaml = ConfigurationBuilder.fromFile(langs).build();
        for (String key : yaml.getKeys()) {
            System.out.println(key);
        }
    }

    public static void main(String[] args) {
        DefaultLangLoadStrategy strategy = new DefaultLangLoadStrategy(new File("common/langs"));
        strategy.load();
    }

}
