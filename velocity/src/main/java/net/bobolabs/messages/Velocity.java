package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class Velocity implements EzAdventurePhase0<CommandSource, VelocityEzAdventurePhase1, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3> {

    @Override
    public @NotNull VelocityEzAdventurePhase1 sync() {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase1 async() {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase2 lang(@NotNull String key) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase2 component(@NotNull ComponentLike component) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase2 text(@NotNull String text) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase2 text(@NotNull String[] text) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase2 text(@NotNull Collection<String> text) {
        return null;
    }

}
