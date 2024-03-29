package net.bobolabs.plugin;

import net.bobolabs.messages.EzAdventureOptions;
import net.bobolabs.messages.bukkit.BukkitEzAdventure;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Locale;

public class MessagePlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        saveResource("lang.yml", false);

        EzAdventureOptions opt = new EzAdventureOptions.Builder()
                .langs(new File(getDataFolder(), "lang.yml"))
                .namespace("boboplugin-bukkit")
                .locale(Locale.CANADA);

        BukkitEzAdventure ezAdventure = new BukkitEzAdventure(this, opt);
        ezAdventure.onEnable();

        Player player = Bukkit.getPlayer("Staminal");
        if (player != null) {
            ezAdventure.sync()
                    .lang("fancy-message")
                    .world("world")
                    .replace("%replace%", CommandSender::getName)
                    .send();

        }

        ezAdventure.onDisable();

    }

    @Override
    public void onDisable() {

    }

}
