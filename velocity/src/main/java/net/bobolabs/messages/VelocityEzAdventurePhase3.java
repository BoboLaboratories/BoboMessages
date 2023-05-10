package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class VelocityEzAdventurePhase3 implements EzAdventurePhase3<CommandSource, VelocityEzAdventurePhase3> {

    @Override
    public @NotNull VelocityEzAdventurePhase3 replace(@NotNull CharSequence target, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replace(@NotNull CharSequence target, @NotNull Function<CommandSource, Object> replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replaceAll(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replaceFirst(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replace(@NotNull UnaryOperator<String> replacement) {
        return null;
    }

    @Override
    public void send() {

    }

}
