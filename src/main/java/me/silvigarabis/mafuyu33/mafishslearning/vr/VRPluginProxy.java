package me.silvigarabis.mafuyu33.mafishslearning.vr;


import net.minecraft.client.MinecraftClient;

public class VRPluginProxy {

    public static boolean vrAPIIInVR() {
        return MinecraftClient.getInstance().player == null ||
                VRPlugin.API.playerInVR(MinecraftClient.getInstance().player);
    }

}
