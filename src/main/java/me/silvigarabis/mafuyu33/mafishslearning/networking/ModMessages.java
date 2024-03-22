package me.silvigarabis.mafuyu33.mafishslearning.networking;

import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.MOD_ID;
import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.LOGGER;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import me.silvigarabis.mafuyu33.mafishslearning.networking.packet.*;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier EXAMPLE_ID = new Identifier(MOD_ID, "example");
    public static final Identifier Shield_Dash_ID = new Identifier(MOD_ID, "shield_dash");
    public static final Identifier Bow_Dash_ID = new Identifier(MOD_ID, "bow_dash");
    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(Shield_Dash_ID, ShieldDashC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(Bow_Dash_ID, BowDashC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleS2CPacket::receive);
    }
}
