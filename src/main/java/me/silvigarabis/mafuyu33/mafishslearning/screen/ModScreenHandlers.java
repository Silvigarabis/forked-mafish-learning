package me.silvigarabis.mafuyu33.mafishslearning.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.MOD_ID;
import static me.silvigarabis.mafuyu33.mafishslearning.MafishsLearningMod.LOGGER;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GemPolishingScreenHandler> GEM_POLISHING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(MOD_ID, "gem_polishing"),
                    new ExtendedScreenHandlerType<>(GemPolishingScreenHandler::new));

    public static void registerScreenHandlers() {
        LOGGER.info("Registering Screen Handlers for " + MOD_ID);
    }
}