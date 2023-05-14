package net.bobolabs.messages;

import net.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.NotNull;

public interface EzLangLoader {

    void load(@NotNull TranslationRegistry registry);

}
