package net.bobolabs.messages;

import net.kyori.adventure.text.minimessage.MiniMessage;

import java.io.File;
import java.util.Locale;

interface EzAdventureConfigurable {

    String getNamespace();

    Locale getDefaultLocale();

    File getLangs();

    LangLoadStrategy getLangLoadStrategy();

    MiniMessage getMiniMessage();

}
