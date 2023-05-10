package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.EzAdventurePhase3;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BukkitEzAdventurePhase3 implements EzAdventurePhase3<CommandSender, BukkitEzAdventurePhase3> {

    @Override
    public @NotNull BukkitEzAdventurePhase3 replace(@NotNull CharSequence target, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 replace(@NotNull CharSequence target, @NotNull Function<CommandSender, Object> replacement) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 replaceAll(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 replaceFirst(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull BukkitEzAdventurePhase3 replace(@NotNull UnaryOperator<String> replacement) {
        return null;
    }

    @Override
    public void send() {

    }

}
