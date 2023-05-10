package net.bobolabs.messages.bukkit.old;

import net.bobolabs.messages.EzAdventureOptions;
import net.bobolabs.messages.LangLoadStrategy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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


        // it_IT: Benvenuto, <bold>%player%</bold>!
        // en_US: Welcome, <bold>%player%</bold>!

        /*

            it_IT: Inizia l'evento, <bold>%player%</bold>!
            en_US: The event is starting, <bold>%player%</bold>!

            adventure.async().key("my.message.key")
                    .replace("%player%, player -> player.getDisplayName())
                    .replace(m -> Qualcosa.diSync(m))
                    .raw(component -> Qualcosa.suRawComponentDiKyori(component));
                    .sendFilter(sender ->
                        sender instanceof Player player
                                && player.getWorld().getName().equals("world")
                                && player.hasPermission("perm"));










            it_IT: Inizia l'evento %event_name%, <bold>%player%</bold>!
            en_US: %event_name% is starting, <bold>%player%</bold>!


            adventure.async()
                .lang("event.starting")
                .filter(p -> p.getWorld().equals(world) && p.hasPermission("perm"))
                .replace("%event_name%, eventName)
                .replace("%player%, p -> p.getDisplayName())
                .send();

            adventure.sync()
                .lang("event.starting")
                .




            adventure.async()

                .lang
                .component
                .text("Ciao %edo%")

                .filter(filter, component)
                ...



















            - sync/sync
            - component
            - audience
            - replacements
            - send



            - async replacements/deserializement
            - automatic localization
            - flexibility

         */

        adventure.filter("my.key", sender ->
                sender instanceof Player player
                        && player.getWorld().getName().equals("world")
                        && player.hasPermission("perm")
        );


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
