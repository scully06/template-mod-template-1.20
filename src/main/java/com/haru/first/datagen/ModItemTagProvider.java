package com.haru.first.datagen;

import com.haru.first.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup args){
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.RUBY_HELMET,ModItems.RUBY_CHESTPLATE,ModItems.RUBY_LEGGIGNGS,ModItems.RUBY_BOOTS);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).add(ModItems.BAR_BRAWL_MUSIC_DISC);
    }
}
