package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase3;
import net.bobolabs.messages.EzAdventurePhase3;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
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
