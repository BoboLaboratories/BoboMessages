package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Predicate;

public class VelocityEzAdventurePhase2 implements ProxyEzAdventurePhase2<CommandSource, VelocityEzAdventurePhase3> {

    @Override
    public @NotNull VelocityEzAdventurePhase3 filter(@NotNull Predicate<CommandSource> filter) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 permission(@NotNull String key) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 sender(@NotNull CommandSource sender) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 sender(@NotNull UUID sender) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 broadcast() {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 console() {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 server(@NotNull String server) {
        return null;
    }

}
