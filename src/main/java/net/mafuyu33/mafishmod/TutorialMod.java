package net.mafuyu33.mafishmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.mafuyu33.mafishmod.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "mafishmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
//		ClientTickEvents.START_CLIENT_TICK.register(this::onClientTick);
		//添加东西
		ModMessages.registerC2SPackets();

		//获取服务器实例
		ServerLifecycleEvents.SERVER_STARTING.register(ServerManager::setServerInstance);

		//VR
		VRPlugin.init();

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