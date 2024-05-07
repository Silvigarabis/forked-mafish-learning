package net.mafuyu33.mafishmod.particle;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;

public class ParticleEmitter {
    public static void addParticle(World world, Vec3d pos, ParticleEffect effect){
        world.addParticle(effect, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
    }
    public static void emitFlameParticleAtBlock(World world, Vec3d pos){
        addParticle(world, new Vec3d(Math.floor(pos.x) + 0.5, Math.floor(pos.y) + 0.5, Math.floor(pos.z) + 0.5), ParticleTypes.FLAME);
    }
}