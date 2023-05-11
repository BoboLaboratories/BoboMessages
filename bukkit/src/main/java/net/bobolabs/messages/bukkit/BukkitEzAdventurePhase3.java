package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase3;
import net.bobolabs.messages.EzAdventurePhase3;
import net.bobolabs.messages.Replacer;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextReplacementConfig;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BukkitEzAdventurePhase3
        extends AbstractEzAdventurePhase3<CommandSender, BukkitEzAdventurePhase3>
        implements EzAdventurePhase3<CommandSender, BukkitEzAdventurePhase3> {

    protected BukkitEzAdventurePhase3(@NotNull Supplier<@NotNull Collection<@NotNull CommandSender>> audience) {
        super(audience);
    }

    @Override
    protected void send(@NotNull CommandSender audience, @NotNull ComponentLike component) {
        audience.sendMessage(component);
    }
}
