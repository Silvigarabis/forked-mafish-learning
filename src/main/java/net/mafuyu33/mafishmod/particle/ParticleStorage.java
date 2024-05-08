package net.mafuyu33.mafishmod.particle;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.mafuyu33.mafishmod.networking.ModMessages;
import net.mafuyu33.mafishmod.networking.packet.C2S.ParticleDataC2SPacket;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.Vec3d;

import java.util.*;


public class ParticleStorage{//储存粒子和移除粒子的方法
    public static Consumer<ParticleStorageSendData> particleDataSender = null;

    public static void addParticle(Vec3d position0, double red0, double green0, double blue0) {
        UUID id0 = UUID.randomUUID();
        if (particleDataSender != null){
            particleDataSender.accept(new ParticleStorageSendData() {
                UUID id = id0;
                public Vec3d position = position0;
                public double red = red0;
                public double green = green0;
                public double blue = blue0;
            });
        }
    }

    public static interface ParticleStorageSendData {
        UUID id;
        Vec3d position;
        double red;
        double green;
        double blue;
    }
}
