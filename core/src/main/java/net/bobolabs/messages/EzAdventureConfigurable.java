package net.bobolabs.messages;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Locale;

public interface EzAdventureConfigurable {

    String getNamespace();

    Locale getDefaultLocale();

    File getLangs();

    LangLoadStrategy getLangLoadStrategy();

    MiniMessage getMiniMessage();

}
