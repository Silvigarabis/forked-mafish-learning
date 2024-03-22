package me.silvigarabis.mafuyu33.mafishslearning.item.custom;

import net.blf02.vrapi.common.VRAPI;
import me.silvigarabis.mafuyu33.mafishslearning.mixinhelper.BlockEnchantmentHelper;
import me.silvigarabis.mafuyu33.mafishslearning.particle.ParticleStorage;
import me.silvigarabis.mafuyu33.mafishslearning.vr.VRPlugin;
import me.silvigarabis.mafuyu33.mafishslearning.vr.VRPluginVerify;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BreadSwordItem extends SwordItem {

    public BreadSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();

//        if(VRPluginVerify.hasAPI){
//            if (VRPlugin.API.playerInVR(user)) {
//                user.sendMessage(Text.literal("在VR里"),false);
//            } else {
//                user.sendMessage(Text.literal("不在VR里"),false);
//            }
//        }

        BlockPos blockPos = context.getBlockPos();
        System.out.println(BlockEnchantmentHelper.getEnchantment(blockPos));

        return super.useOnBlock(context);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (remainingUseTicks % 20==0){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,10,0));
        }
    }
}
