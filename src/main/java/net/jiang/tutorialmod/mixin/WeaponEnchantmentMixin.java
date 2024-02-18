package net.jiang.tutorialmod.mixin;

import dev.architectury.hooks.level.biome.EffectsProperties;
import net.jiang.tutorialmod.enchantment.ModEnchantments;
import net.jiang.tutorialmod.mixinhelper.FireworkRocketEntityMixinHelper;
import net.jiang.tutorialmod.mixinhelper.WeaponEnchantmentMixinHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@Mixin(LivingEntity.class)
public abstract class WeaponEnchantmentMixin extends Entity implements Attackable{
    @Unique
    float Times = 0F;

    @Shadow public abstract Hand getActiveHand();

    @Shadow public abstract ItemStack getStackInHand(Hand hand);

    @Shadow public abstract boolean isAlive();

    @Shadow @Final protected static TrackedData<Byte> LIVING_FLAGS;

    public WeaponEnchantmentMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    @Inject(at = @At("HEAD"), method = "onAttacking")
    private void init(Entity target, CallbackInfo info) {

        Hand hand = this.getActiveHand();
        ItemStack itemStack = this.getStackInHand(hand);
        int k = EnchantmentHelper.getLevel(ModEnchantments.KILL_CHICKEN_GET_EGG, itemStack);
        int j = EnchantmentHelper.getLevel(Enchantments.LOOTING, itemStack);
        int m = EnchantmentHelper.getLevel(ModEnchantments.GONG_XI_FA_CAI,itemStack);
        int n = EnchantmentHelper.getLevel(ModEnchantments.MERCY,itemStack);
        
        if (k > 0 && target instanceof ChickenEntity) {//杀鸡取卵
            target.dropItem(Items.EGG);
        }
        if(k > 0 && j>0 && target instanceof ChickenEntity){
            target.dropItem(Items.EGG);
            target.dropItem(Items.DRAGON_EGG);
            target.dropItem(Items.TURTLE_EGG);
            target.dropItem(Items.SNIFFER_EGG);
            target.dropItem(Items.FROGSPAWN);
        }


        if (m > 0 && target.getType() == EntityType.VILLAGER) {//恭喜发财
            WeaponEnchantmentMixinHelper.storeEntityValue(target.getId(),m) ;
        }


        if(n > 0 && target instanceof LivingEntity){
            Times=Times+n;
            ((LivingEntity) target).addStatusEffect(
                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST,900,(int) (Times-1F)));
            ((LivingEntity) target).addStatusEffect(
                    new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,900,(int) (Times-1F)));
        }
    }
}