package net.bobolabs.messages;

import net.kyori.adventure.platform.AudienceProvider;
import org.jetbrains.annotations.NotNull;

public interface EzAudienceProvider<T extends AudienceProvider> {

    void setAudience(@NotNull T audience);

    @NotNull T getAudience();

}
