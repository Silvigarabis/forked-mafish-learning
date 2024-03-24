package me.silvigarabis.mafishslearning.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.jiang.tutorialmod.block.ModBlocks;
import net.jiang.tutorialmod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 30),
                            new ItemStack(ModBlocks.GOLD_MELON, 1),
                            6, 5, 0.05f));
                });
    }
}
