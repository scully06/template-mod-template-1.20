package com.haru.first;

import com.haru.first.block.ModBlocks;
import com.haru.first.entity.ModEntities;
import com.haru.first.entity.custom.PorcupineEntity;
import com.haru.first.item.ModItems;
import com.haru.first.item.ModItemsGroups;
import com.haru.first.item.util.ModCustomTrades;
import com.haru.first.item.util.ModLootTableModifiers;
import com.haru.first.sound.ModSounds;
import com.haru.first.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
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
		ModCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();
		ModEntities.registerModEntities();
		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE,1200);
	}
}