package net.bobolabs.plugin;

import net.bobolabs.messages.EzAdventureOptions;
import net.bobolabs.messages.bungee.BungeeEzAdventure;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.util.Locale;

public class MessagePlugin extends Plugin {

    @Override
    public void onEnable() {
        EzAdventureOptions opt = new EzAdventureOptions.Builder()
                .langs(new File(getDataFolder(), "lang.yml"))
                .namespace("boboplugin-bungee")
                .locale(Locale.CANADA);


        BungeeEzAdventure adventure = new BungeeEzAdventure(this, opt);



    }

    @Override
    public void onDisable() {

    }
}
