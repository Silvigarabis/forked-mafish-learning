package net.mafuyu33.mafishmod.drawing;

import net.minecraft.particle.ParticleType;
import net.minecraft.util.math.Vec3d;

public final class DrawParticle {
    public final Vec3d pos;
    public final DrawParticleData data;
    
    public DrawParticle(Vec3d pos, ParticleType type){
        this.pos = pos;
        this.data = new DrawParticleData(type, 0.0, 0.0, 0.0);
    }
    public DrawParticle(Vec3d pos, ParticleType type, double r, double g, double b){
        this.pos = pos;
        this.data = new DrawParticleData(type, r, g, b);
    }
    public DrawParticle(Vec3d pos, DrawParticleData data){
        this.pos = pos;
        this.data = data;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof DrawParticle)){
            return false;
        }
        return pos.equals(o.pos) && data.equals(o.data);
    }
    @Override
    public int hashCode(){
        return 31 * ((pos == null) ? 0 : pos.hashCode()) + ((data == null) ? 0 : data.hashCode());
    }
}
