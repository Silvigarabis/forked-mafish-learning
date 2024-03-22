package me.silvigarabis.mafuyu33.mafishslearning.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO=new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK,200),0.25f).build();
    public static final FoodComponent BREAD_SWORD=
            new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodComponent BREAD_SWORD_HOT=
            new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,200),0.25f).alwaysEdible().build();
    public static final FoodComponent BREAD_SWORD_VERY_HOT=
            new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodComponent POISON_SWORD=
            new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodComponent STARGAZY_PIE=new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON,200),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,400),1f).alwaysEdible().build();
    public static final FoodComponent MILK_FLESH=
            new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).alwaysEdible().build();
}
