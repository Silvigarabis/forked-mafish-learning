package net.mafuyu33.mafishmod.mixin.drawing;

import net.minecraft.particle.ParticleType;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

import net.mafuyu33.mafishmod.drawing.WorldDrawParticlePainter;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(World.class)
public abstract class WorldDrawParticleMixin implements WorldDrawParticlePainter {

    public void addDrawParticle(Vec3d pos, ParticleType type, double r, double g, double b){
    }

    public void removeDrawParticle(Vec3d pos, ParticleType type, double r, double g, double b){
    }

}
