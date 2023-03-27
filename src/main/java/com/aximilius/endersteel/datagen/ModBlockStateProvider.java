package com.aximilius.endersteel.datagen;

import com.aximilius.endersteel.Endersteel;
import com.aximilius.endersteel.block.ModBlock;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, Endersteel.MOD_ID, exFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerStatesAndModels() {
		// TODO Auto-generated method stub
		blockWithItem(ModBlock.ENDERSTEEL_DEPOSIT);
		blockWithItem(ModBlock.RAW_ENDERSTEEL_BLOCK);
		blockWithItem(ModBlock.GALVANIZED_ENDERSTEEL_BLOCK);
	}

	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
}
