package com.aximilius.endersteel.item;

import com.aximilius.endersteel.Endersteel;

import net.minecraft.sounds.SoundEvents;
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
	public static final RegistryObject<Item> ENDERSTEEL_NUGGET = ITEMS.register("endersteel_nugget",
			() -> new Item(new Item.Properties()));

	public static final RegistryObject<SwordItem> GALVANIZED_ENDERSTEEL_SWORD = ITEMS.register("galvanized_endersteel_sword",
			() -> new SwordItem(ToolTiers.ENDERSTEEL, 4, -2.4f, new Item.Properties()));
	public static final RegistryObject<AxeItem> GALVANIZED_ENDERSTEEL_AXE = ITEMS.register("galvanized_endersteel_axe",
			() -> new AxeItem(ToolTiers.ENDERSTEEL, 6, -3.1f, new Item.Properties()));
	public static final RegistryObject<PickaxeItem> GALVANIZED_ENDERSTEEL_PICKAXE = ITEMS.register("galvanized_endersteel_pickaxe",
			() -> new PickaxeItem(ToolTiers.ENDERSTEEL, 1, -2.8f, new Item.Properties()));
	public static final RegistryObject<ShovelItem> GALVANIZED_ENDERSTEEL_SHOVEL = ITEMS.register("galvanized_endersteel_shovel",
			() -> new ShovelItem(ToolTiers.ENDERSTEEL, (float) 1.5, -3.0f, new Item.Properties()));
	public static final RegistryObject<HoeItem> GALVANIZED_ENDERSTEEL_HOE = ITEMS.register("galvanized_endersteel_hoe",
			() -> new HoeItem(ToolTiers.ENDERSTEEL, -5, -3.85f, new Item.Properties()));

	public static final RegistryObject<ArmorItem> GALVANIZED_ENDERSTEEL_HELMET = ITEMS.register("galvanized_endersteel_helmet",
			() -> new ArmorItem(ModArmorMaterials.ENDERSTEEL, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<ArmorItem> GALVANIZED_ENDERSTEEL_CHESTPLATE = ITEMS.register("galvanized_endersteel_chestplate",
			() -> new ArmorItem(ModArmorMaterials.ENDERSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<ArmorItem> GALVANIZED_ENDERSTEEL_LEGGINGS = ITEMS.register("galvanized_endersteel_leggings",
			() -> new ArmorItem(ModArmorMaterials.ENDERSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<ArmorItem> GALVANIZED_ENDERSTEEL_BOOTS = ITEMS.register("galvanized_endersteel_boots",
			() -> new ArmorItem(ModArmorMaterials.ENDERSTEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
	
	public static void register (IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

	public static class ToolTiers {
		public static final Tier ENDERSTEEL = new ForgeTier(5, 4064, 12.0f, 5.0f, 20, null, () -> Ingredient.of(ModItem.GALVANIZED_ENDERSTEEL.get()));
	}
}
