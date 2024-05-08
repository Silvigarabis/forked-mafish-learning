package net.mafuyu33.mafishmod.drawing;

import net.minecraft.particle.ParticleType;
import net.minecraft.util.math.Vec3d;

/**
 * DrawParticleData 描述了一个粒子的类型和颜色。每个 DrawParticleData 都是固定不可变的。
 */
public final class DrawParticleData {
    public final ParticleType type;
    public final double r;
    public final double g;
    public final double b;
    public DrawParticleData(ParticleType type, double r, double g, double b){
        this.type = type;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    @Override
    public boolean equals(Object o){
        if (!(o instanceof DrawParticleData)){
            return false;
        }
        return type.equals(o.type) && r == o.r && g == o.g && b == o.b;
    }
    @Override
    public int hashCode(){
        // 来自ChatGPT，一段生成hashCode的代码。

        final int prime = 31;
        int result = 1;
        long temp;

        // 使用Double的hashCode方法来计算r、g、b的哈希值
        temp = Double.doubleToLongBits(r);
        result = prime * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(g);
        result = prime * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(b);
        result = prime * result + (int) (temp ^ (temp >>> 32));

        // 添加type的哈希值
        result = prime * result + ((type == null) ? 0 : type.hashCode());

        return result;
    }
}
