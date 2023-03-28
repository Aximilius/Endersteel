package com.aximilius.endersteel.item;

import com.aximilius.endersteel.Endersteel;
import com.google.common.base.Supplier;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
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

	public static final RegistryObject<SwordItem> GALVANIZED_ENDERSTEEL_SWORD = ITEMS.register("galvanized_endersteel_sword",
			() -> new SwordItem(Tiers.ENDERSTEEL, 4, -2.4f, new Item.Properties()));

	public static final RegistryObject<AxeItem> GALVANIZED_ENDERSTEEL_AXE = ITEMS.register("galvanized_endersteel_axe",
			() -> new AxeItem(Tiers.ENDERSTEEL, 6, -3.1f, new Item.Properties()));

	public static final RegistryObject<PickaxeItem> GALVANIZED_ENDERSTEEL_PICKAXE = ITEMS.register("galvanized_endersteel_pickaxe",
			() -> new PickaxeItem(Tiers.ENDERSTEEL, 1, -2.8f, new Item.Properties()));

	public static final RegistryObject<ShovelItem> GALVANIZED_ENDERSTEEL_SHOVEL = ITEMS.register("galvanized_endersteel_shovel",
			() -> new ShovelItem(Tiers.ENDERSTEEL, (float) 1.5, -3.0f, new Item.Properties()));

	public static final RegistryObject<HoeItem> GALVANIZED_ENDERSTEEL_HOE = ITEMS.register("galvanized_endersteel_hoe",
			() -> new HoeItem(Tiers.ENDERSTEEL, -5, -3.85f, new Item.Properties()));
	
	public static void register (IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

	public static class Tiers {
		public static final Tier ENDERSTEEL = new ForgeTier(5, 4064, 12.0f, 5.0f, 20, null, () -> Ingredient.of(ModItem.GALVANIZED_ENDERSTEEL.get()));
	}
}
