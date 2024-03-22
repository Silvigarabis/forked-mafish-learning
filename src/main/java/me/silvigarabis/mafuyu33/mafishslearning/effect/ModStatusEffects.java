package me.silvigarabis.mafuyu33.mafishslearning.effect;

import me.silvigarabis.mafuyu33.mafishslearning.effect.custom.FlowerEffect;
import me.silvigarabis.mafuyu33.mafishslearning.effect.custom.IronStatusEffect;
import me.silvigarabis.mafuyu33.mafishslearning.effect.custom.TeleportEffect;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static me.silvigarabis.mafuyu33.mafishslearning.TutorialMod.MOD_ID;


public class ModStatusEffects {

    // 构造函数为空的私有类，用于表示IRON效果
    public static final StatusEffect IRONMAN = new IronStatusEffect(StatusEffectCategory.BENEFICIAL, 0xFF0000);
    public static final StatusEffect FLOWER_EFFECT = new FlowerEffect(StatusEffectCategory.BENEFICIAL, 0xFF0000);
    public static final StatusEffect TELEPORT_EFFECT = new TeleportEffect(StatusEffectCategory.BENEFICIAL, 0x00FFFF);

    private static void ironAttributeModifiers(EntityAttributeInstance instance) {
        // 可以在这里添加自定义效果对实体属性的修改
    }

    public static void registerModEffect(){
    Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, "ironman"), ModStatusEffects.IRONMAN);
    Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, "flower_effect"), ModStatusEffects.FLOWER_EFFECT);
    Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, "teleport_effect"), ModStatusEffects.TELEPORT_EFFECT);
    }

}
