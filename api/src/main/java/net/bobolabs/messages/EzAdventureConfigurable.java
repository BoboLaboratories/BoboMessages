package net.bobolabs.messages;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;

interface EzAdventureConfigurable {

    @NotNull String getNamespace();

    @NotNull Locale getDefaultLocale();

    @NotNull File getLangs();

    LangLoadStrategy getLangLoadStrategy();

    MiniMessage getMiniMessage();

}
