package net.mafuyu33.mafishmod.particle;

import net.minecraft.util.math.Vec3d;

import java.util.*;
import java.util.function.Consumer;

public class ParticleStorage{//储存粒子和移除粒子的方法
    public static Consumer<ParticleStorageSendData> particleDataSender = null;

    public static void addParticle(Vec3d position, double red, double green, double blue) {
        UUID id = UUID.randomUUID();
        if (particleDataSender != null){
            particleDataSender.accept(new ParticleStorageSendData(id, position, red, green, blue));
        }
    }

    public static class ParticleStorageSendData {
        public ParticleStorageSendData(UUID id, Vec3d position, double red, double green, double blue){
            this.id = id;
            this.position = position;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        UUID id;
        Vec3d position;
        double red;
        double green;
        double blue;
    }
}
