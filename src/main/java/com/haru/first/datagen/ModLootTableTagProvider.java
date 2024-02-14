package com.haru.first.datagen;

import com.haru.first.block.ModBlocks;
import com.haru.first.block.custom.CornCropBrock;
import com.haru.first.block.custom.TomatoCropBlock;
import com.haru.first.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

import javax.swing.text.AbstractDocument;

public class ModLootTableTagProvider extends FabricBlockLootTableProvider {
    public ModLootTableTagProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }


    @Override
    public void generate(){
        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_SLAB,slabDrops(ModBlocks.RUBY_SLAB));
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_DOOR,doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_TRAP_DOOR);
        addDrop(ModBlocks.DAHLIA);
        addDrop(ModBlocks.POTTED_DAHLIA);

        addDrop(ModBlocks.RUBY_ORE, copperLikeOreDrop(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(
                ModBlocks.TOMATO_CROPS).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE,5));

        AnyOfLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(
                ModBlocks.CORN_CROPS).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBrock.AGE,7))
                .or(BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROPS).properties(StatePredicate.Builder.create()));

        addDrop(ModBlocks.TOMATO_CROPS,cropDrops(ModBlocks.TOMATO_CROPS, ModItems.TOMATO,ModItems.TOMATO_SEED,builder));
        addDrop(ModBlocks.CORN_CROPS,cropDrops(ModBlocks.CORN_CROPS, ModItems.CORN,ModItems.CORN,builder));
    }
    public LootTable.Builder copperLikeOreDrop(Block drop, Item item){
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f,5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));

    }

}
