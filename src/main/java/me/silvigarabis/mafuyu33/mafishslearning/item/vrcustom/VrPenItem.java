package me.silvigarabis.mafuyu33.mafishslearning.item.vrcustom;

import me.silvigarabis.mafuyu33.mafishslearning.VRPlugin;
import static me.silvigarabis.mafuyu33.mafishslearning.TutorialMod.isVrSupported;
import static me.silvigarabis.mafuyu33.mafishslearning.VRPlugin.getVRAPI;

import me.silvigarabis.mafuyu33.mafishslearning.particle.ModParticles;
import me.silvigarabis.mafuyu33.mafishslearning.particle.ParticleStorage;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VrPenItem extends Item{
    public VrPenItem(Settings settings) {
        super(settings);
    }
    public boolean isDrawing = false;
    private double red = 1.0;
    private double green = 1.0;
    private double blue = 1.0;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient) {
            isDrawing = !isDrawing;
            user.sendMessage(Text.literal((String.valueOf("切换绘画模式"))), true);
        }
        return super.use(world,user,hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if(isDrawing){//画笔
            if(world.isClient) {
                if(entity.getHandItems()!=null && entity instanceof PlayerEntity) {
                    Item item = ((PlayerEntity) entity).getOffHandStack().getItem();
                    System.out.println(item);
                    if(item==Items.RED_DYE){
                        red =1.0;
                        green =0.0;
                        blue =0.0;
                    }else if(item==Items.GREEN_DYE){
                        red =0.0;
                        green =1.0;
                        blue =0.0;
                    }else if(item==Items.BLUE_DYE){
                        red =0.0;
                        green =0.0;
                        blue =1.0;
                    }else if(item==Items.YELLOW_DYE){
                        red =1.0;
                        green =1.0;
                        blue =0.0;
                    }else if(item==Items.BLACK_DYE){
                        red =0.0;
                        green =0.0;
                        blue =0.0;
                    }else if(item==Items.BROWN_DYE){
                        red =0.6;
                        green =0.4;
                        blue =0.2;
                    }else if(item==Items.ORANGE_DYE){
                        red =1.0;
                        green =0.5;
                        blue =0.0;
                    }else if(item==Items.MAGENTA_DYE){
                        red =1.0;
                        green =0.0;
                        blue =1.0;
                    }else if(item==Items.LIGHT_BLUE_DYE){
                        red =0.5;
                        green =0.5;
                        blue =1.0;
                    }else if(item==Items.LIME_DYE){
                        red =0.5;
                        green =1.0;
                        blue =0.2;
                    }else if(item==Items.PINK_DYE){
                        red =1.0;
                        green =0.75;
                        blue =0.8;
                    }else if(item==Items.GRAY_DYE){
                        red =0.5;
                        green =0.5;
                        blue =0.5;
                    }else if(item==Items.LIGHT_GRAY_DYE){
                        red =0.8;
                        green =0.8;
                        blue =0.8;
                    }else if(item==Items.CYAN_DYE){
                        red =0.0;
                        green =1.0;
                        blue =1.0;
                    }else if(item==Items.PURPLE_DYE){
                        red =0.5;
                        green =0.0;
                        blue =0.5;
                    } else {
                        red =1.0;
                        green =1.0;
                        blue =1.0;
                    }
                }

                // drawing in vr mode
                if (VRPlugin.isClientInVr() && entity instanceof PlayerEntity player && getVRAPI().apiActive(player)){
                    Vec3d currentPosMainController = VRPlugin.getControllerPosition(player, 0);
                    Vec3d particlePosition = new Vec3d(currentPosMainController.getX(), currentPosMainController.getY(), currentPosMainController.getZ());
                    world.addParticle(ModParticles.CITRINE_PARTICLE,true, particlePosition.x,particlePosition.y,particlePosition.z, red, green, blue);
                    ParticleStorage.getOrCreateForWorld().addParticle(particlePosition, red, green, blue);
                } else { // not in vr mode
                    // 获取玩家的朝向
                    Vec3d lookVec = entity.getRotationVector();
                    double distance = 1d;
                    // 将朝向向量乘以所需的距离，以确定粒子生成的位置
                    double offsetX = lookVec.x * distance;
                    double offsetY = lookVec.y * distance;
                    double offsetZ = lookVec.z * distance;
                    Vec3d particlePosition = new Vec3d(entity.getX()+offsetX, entity.getY() + offsetY + 1.625, entity.getZ()+offsetZ);
                    world.addParticle(ModParticles.CITRINE_PARTICLE,true, particlePosition.x,particlePosition.y,particlePosition.z, red, green, blue);
                    ParticleStorage.getOrCreateForWorld().addParticle(particlePosition, red, green, blue);
                }
            }
        }
    }
}
