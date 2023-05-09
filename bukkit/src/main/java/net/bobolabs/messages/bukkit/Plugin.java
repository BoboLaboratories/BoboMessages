package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.EzAdventureOptions;
import net.bobolabs.messages.LangLoadStrategy;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        EzAdventureOptions opts = new EzAdventureOptions.Builder()
                .langs(new File(getDataFolder(), "langs"))
                .namespace("bobo.labs")
                .locale(Locale.ENGLISH)
                .langLoadStrategy(LangLoadStrategy.FILE);

        EzAdventure adventure = new EzAdventure(this, opts);


        Player player = null;
        Component message = Component.text("");

         a = adventure.getEzComponent("")
                .replace("ciao", "ciao");


//        //Component aMano = Component.text("Ciao");
//        EzAdventure adventure = new EzAdventure(this, new File("non-ce-la-faccio.yml"), Locale.CANADA);
//
//        EzComponent ezComponent = adventure.getComponent(player, "my.key");
//        ezComponent.replace(...)
//            .send();
//
//        Component component = ezComponent.lessEz();
//        itemStack.
//
//        adventure.ezify(component)
//                .replace();
//
//
//        net.bobolabs.messages.Message<T, U> message = this.getMessage(null, "key");
//        message.replace("%ciao%");
    }

}
