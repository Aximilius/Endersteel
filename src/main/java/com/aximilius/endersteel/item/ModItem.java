package com.aximilius.endersteel.item;

import com.aximilius.endersteel.Endersteel;
import com.google.common.base.Supplier;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, Endersteel.MOD_ID);
	
	public static final RegistryObject<Item> RAW_ENDERSTEEL = ITEMS.register("raw_endersteel", 
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> GALVANIZED_ENDERSTEEL = ITEMS.register("galvanized_endersteel", 
			() -> new Item(new Item.Properties()));
	
	public static void register (IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
