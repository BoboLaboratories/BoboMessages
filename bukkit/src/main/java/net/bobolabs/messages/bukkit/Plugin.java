package net.bobolabs.messages.bukkit;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {


        BukkitEzAdventure adventure = new BukkitEzAdventure(this, null);
        String eventName = "MyEvent";
        World world = Objects.requireNonNull(Bukkit.getWorld("world"));
        Player player = Objects.requireNonNull(Bukkit.getPlayer(""));


        // Sends MiniMessage deserialized message based on a
        // constant string to anybody in the server who has
        // vip.claim.alert permission and replaces their name
        adventure.async()
                .text("You can redeem your <bold>rewards</bold>, %player%!")
                .permission("vip.claim.alert")
                .replace("%player%", p -> ((Player) p).displayName())
                .send();


        // Sends MiniMessage deserialized message based on
        // translated (localized) lang files (it_IT, en_US, etc.)
        // to any player in a given world, plus replacements
        //      it_IT: <bold>%player%</bold>, inizia l'evento %event_name%!
        //      en_US: %event_name% is starting, <bold>%player%</bold>!
        adventure.async()
                .lang("events.starting")
                .world(world)
                .replace("%player%", p -> ((Player) p).displayName())
                .replace("%event_name%", eventName)
                .send();


        // Flexibility (non ho voglia di scrivere altri commenti)
        Component handMade = Component.text("whatever");
        adventure.async()
                .component(handMade)
                .filter(s -> s instanceof Player p
                        && p.getWorld().equals(world)
                        && p.hasPermission("my.perm")
                        && p.isFlying())
                .send();


    }

}
