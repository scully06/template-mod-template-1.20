package com.haru.first.item;

import com.haru.first.TutorialMod;
import com.haru.first.block.ModBlocks;
import com.haru.first.entity.ModEntities;
import com.haru.first.item.custom.MetalDetectorItem;
import com.haru.first.item.custom.ModArmorItem;
import com.haru.first.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));

    public static final Item RAW_RUBY = registerItem("raw_ruby",new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette",
            new Item(new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerToolItem("ruby_sword",
            new SwordItem(PotatoToolMaterial.INSTANCE,
                    1000000000,
                    1000.0F,
                    new FabricItemSettings()));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY,1,1f,new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterial.RUBY,1,1f,new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterial.RUBY,1,1f,new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY,1,1f,new FabricItemSettings()));
    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,new  FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item RUBY_LEGGIGNGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY,ArmorItem.Type.BOOTS,new FabricItemSettings()));
    public static final Item TOMATO_SEED = registerItem("tomato_seed",
            new AliasedBlockItem(ModBlocks.TOMATO_CROPS,new FabricItemSettings()));
    public static final Item CORN_SEED = registerItem("corn_seed",
            new AliasedBlockItem(ModBlocks.CORN_CROPS,new FabricItemSettings()));
    public static final Item CORN = registerItem("corn",
            new AliasedBlockItem(ModBlocks.CORN_CROPS,new FabricItemSettings()));
    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new MusicDiscItem(7, ModSounds.BAR_BRAWL,new FabricItemSettings().maxCount(1),122));
    public static Item PORCUPINE_SPAWN_EGG = registerItem("porcupine_spawn_egg",
            new SpawnEggItem(ModEntities.PORCUPINE,0xa86518, 0x3b260f,new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
    }

    private static ToolItem registerToolItem(String name, ToolItem item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name), item);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Regsitering Mod Items for " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
