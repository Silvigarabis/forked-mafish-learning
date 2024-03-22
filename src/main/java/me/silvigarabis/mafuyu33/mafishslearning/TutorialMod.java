package me.silvigarabis.mafuyu33.mafishslearning;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import me.silvigarabis.mafuyu33.mafishslearning.block.entity.ModBlockEntities;
import me.silvigarabis.mafuyu33.mafishslearning.effect.ModStatusEffects;
import me.silvigarabis.mafuyu33.mafishslearning.enchantment.ModEnchantments;
import me.silvigarabis.mafuyu33.mafishslearning.event.AttackEntityHandler;
import me.silvigarabis.mafuyu33.mafishslearning.item.ModItemGroups;
import me.silvigarabis.mafuyu33.mafishslearning.item.ModItems;
import me.silvigarabis.mafuyu33.mafishslearning.block.ModBlocks;
import me.silvigarabis.mafuyu33.mafishslearning.networking.ModMessages;
import me.silvigarabis.mafuyu33.mafishslearning.particle.ModParticles;
import me.silvigarabis.mafuyu33.mafishslearning.potion.ModPotions;
import me.silvigarabis.mafuyu33.mafishslearning.sound.ModSounds;
import me.silvigarabis.mafuyu33.mafishslearning.util.ModCustomTrades;
import me.silvigarabis.mafuyu33.mafishslearning.util.ModLootTableModifiers;
import me.silvigarabis.mafuyu33.mafishslearning.villager.ModVillagers;
import me.silvigarabis.mafuyu33.mafishslearning.vr.VRPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID="tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
//		ClientTickEvents.START_CLIENT_TICK.register(this::onClientTick);

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUEITE,200);
		ModStatusEffects.registerModEffect();
		ModPotions.registerPotions();
		ModLootTableModifiers.modifyLootTables();
		ModVillagers.registerVillagers();
		ModSounds.registerSounds();
		ModCustomTrades.registerCustomTrades();
		ModEnchantments.registerModEnchantments();
		ModPotions.registerBrewingRecipes();
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		ModMessages.registerC2SPackets();
		ModParticles.registerParticles();
		try {
			Class.forName("net.blf02.vrapi.api.IVRAPI");
			VRPlugin.initVR();
		} catch (ClassNotFoundException e) {
			TutorialMod.LOGGER.info("Not loading with mc-vr-api; it wasn't found!");
		}
	}


//	private int tickCounter = 0;
//	private final int delayTicks = 10; // 延迟的 tick 数，可以根据需要调整
//	private boolean shouldExecuteDelayedAction = false;

//	private void onClientTick(net.minecraft.client.MinecraftClient minecraftClient) {
//		// 在客户端每次 tick 开始时触发的逻辑
//		tickCounter++;
//		// 检查是否达到了延迟的 tick 数
//		if (tickCounter >= delayTicks) {
//			shouldExecuteDelayedAction = true;
//			tickCounter = 0; // 重置计时器
//		}
//
//		// 在达到延迟后执行操作
//		if (shouldExecuteDelayedAction) {
//			// 在这里执行你的延时操作
//			// 例如，修改渲染效果、创建自定义 HUD 元素等
//			executeDelayedAction();
//			shouldExecuteDelayedAction = false; // 确保操作只执行一次
//		}
//	}
//	private void executeDelayedAction() {
//		// 在这里执行延时操作的逻辑
//		// 例如，修改渲染效果、创建自定义 HUD 元素等
//	}

}