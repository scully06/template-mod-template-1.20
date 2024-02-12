package com.haru.first;

import com.haru.first.block.ModBlocks;
import com.haru.first.item.ModItems;
import com.haru.first.item.ModItemsGroups;
import com.haru.first.item.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemGroups();
		ModLootTableModifiers.modifyLootTables();


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE,1200);
	}
}