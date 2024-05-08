package net.mafuyu33.mafishmod.drawing;

import net.minecraft.particle.ParticleType;
import net.minecraft.util.math.Vec3d;

public interface WorldDrawParticle {
    void addDrawParticle(DrawParticle particle);
    boolean removeDrawParticle(DrawParticle particle);
}
