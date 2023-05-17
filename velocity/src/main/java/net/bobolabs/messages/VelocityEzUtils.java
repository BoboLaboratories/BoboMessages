package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.ConsoleCommandSource;
import com.velocitypowered.api.proxy.Player;
import org.jetbrains.annotations.NotNull;

public final class VelocityEzUtils {

    private VelocityEzUtils() {
    }

    public static @NotNull String getSourceName(@NotNull CommandSource source) {
        if (source instanceof Player player) {
            return player.getUsername();
        } else if (source instanceof ConsoleCommandSource) {
            return "Console";
        } else {
            return source.getClass().getSimpleName();
        }
    }

}
