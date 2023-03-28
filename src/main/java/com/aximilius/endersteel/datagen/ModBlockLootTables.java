package com.aximilius.endersteel.datagen;

import java.util.Set;

import com.aximilius.endersteel.block.ModBlock;
import com.aximilius.endersteel.item.ModItem;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

	public ModBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void generate() {
		// TODO Auto-generated method stub
		dropSelf(ModBlock.RAW_ENDERSTEEL_BLOCK.get());
		dropSelf(ModBlock.GALVANIZED_ENDERSTEEL_BLOCK.get());
		
		add(ModBlock.ENDERSTEEL_DEPOSIT.get(),
				(block) -> createSingleItemTableWithSilkTouch(ModBlock.ENDERSTEEL_DEPOSIT.get(), ModItem.RAW_ENDERSTEEL.get()));
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}

}
