package com.haru.first.item.util;

import com.haru.first.block.ModBlocks;
import com.haru.first.item.ModItems;
import com.haru.first.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER,1,factories -> factories.add((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD,10),
                new ItemStack(ModItems.RUBY_CHESTPLATE,1),
                10,10,0F
        )));
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER,1, factories -> factories.add((entity, random) -> new TradeOffer(
                new ItemStack(Items.EMERALD,1),
                new ItemStack(ModBlocks.SOUND_BLOCK,1),
                10,10,0F
        )));
    }
}
