package me.silvigarabis.mafuyu33.mafishslearning.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import me.silvigarabis.mafuyu33.mafishslearning.mixinhelper.BowDashMixinHelper;
import me.silvigarabis.mafuyu33.mafishslearning.mixinhelper.ShieldDashMixinHelper;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class BowDashC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        BowDashMixinHelper.storeHitCoolDown(player.getId(),buf.getInt(0));

    }
}
