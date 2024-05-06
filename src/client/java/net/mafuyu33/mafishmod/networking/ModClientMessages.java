package net.mafuyu33.mafishmod.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.mafuyu33.mafishmod.TutorialMod;
import net.mafuyu33.mafishmod.networking.packet.*;
import net.minecraft.util.Identifier;

public class ModClientMessages {

    public static final Identifier EXAMPLE_ID = ModMessages.EXAMPLE_ID;
    public static final Identifier Shield_Dash_ID = ModMessages.Shield_Dash_ID;
    public static final Identifier Bow_Dash_ID = ModMessages.Bow_Dash_ID;
    public static final Identifier PARTICLE_DATA_ID = ModMessages.PARTICLE_DATA_ID;
    public static final Identifier NEVER_GONNA_ID = ModMessages.NEVER_GONNA_ID;
    public static final Identifier GAME_OPTIONS_ID = ModMessages.GAME_OPTIONS_ID;
    public static final Identifier THROW_POWER_ID = ModMessages.THROW_POWER_ID;
    public static final Identifier BELL_SOUND_ID = ModMessages.BELL_SOUND_ID;

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(NEVER_GONNA_ID, NeverGonnaS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(BELL_SOUND_ID, BellSoundS2CPacket::receive);
    }
}
