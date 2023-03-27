package com.aximilius.endersteel.block;

import java.util.function.Supplier;

import com.aximilius.endersteel.Endersteel;
import com.aximilius.endersteel.item.ModItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlock {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, Endersteel.MOD_ID);

	
	public static final RegistryObject<Block> RAW_ENDERSTEEL_BLOCK = registerBlock("raw_endersteel_block", 
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(30f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> GALVANIZED_ENDERSTEEL_BLOCK = registerBlock("galvanized_endersteel_block", 
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(50f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> ENDERSTEEL_DEPOSIT = registerBlock("endersteel_deposit", 
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(30f).requiresCorrectToolForDrops()));
	
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ModItem.ITEMS.register(name,  
				() -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
