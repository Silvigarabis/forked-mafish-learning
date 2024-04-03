package net.mafuyu33.mafishmod.mixin.enchantmentblockmixin.sigleinject;

import net.mafuyu33.mafishmod.mixinhelper.InjectHelper;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BarrelBlock.class)
public abstract class BarrelBlockMixin {
    @Inject(at = @At("HEAD"), method = "onPlaced")//存储方块的附魔
    private void init1(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack, CallbackInfo info) {
        InjectHelper.onPlacedInject(world,itemStack,pos);
    }
}
