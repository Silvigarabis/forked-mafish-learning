package me.silvigarabis.mafuyu33.mafishslearning.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import me.silvigarabis.mafuyu33.mafishslearning.block.ModBlocks;
import me.silvigarabis.mafuyu33.mafishslearning.item.ModItems;
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
