package net.mafuyu33.mafishmod.particle;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.mafuyu33.mafishmod.networking.ModMessages;
import net.mafuyu33.mafishmod.networking.packet.C2S.ParticleDataC2SPacket;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.Vec3d;

import java.util.*;


public class ParticleStorageClient {
    
    static {
        ParticleStorage.particleDataSender = (data) -> {
            sendParticleData(
                data.position,
                new double[]{ data.red, data.green, data.blue },
                data.id,
                true
            );
            
        };
    }
    
    public static init(){
    }

    public static void sendParticleData(Vec3d position, double[] color, UUID uuid, boolean addOrRemove) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ParticleDataC2SPacket.encodeAdd(buf, position, color, uuid, addOrRemove);
        ClientPlayNetworking.send(ModMessages.PARTICLE_DATA_ID, buf);
    }

    public static void removeParticleData(Vec3d position){
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        ParticleDataC2SPacket.encodeRemove(buf, position,false);
        ClientPlayNetworking.send(ModMessages.PARTICLE_DATA_ID, buf);
    }

}
