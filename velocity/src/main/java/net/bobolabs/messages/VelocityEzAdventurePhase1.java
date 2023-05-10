package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;

public class VelocityEzAdventurePhase1
        extends AbstractEzAdventurePhase1<CommandSource, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3>
        implements EzAdventurePhase1<CommandSource, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3> {

    public VelocityEzAdventurePhase1(boolean async) {
        super(async);
    }
}
