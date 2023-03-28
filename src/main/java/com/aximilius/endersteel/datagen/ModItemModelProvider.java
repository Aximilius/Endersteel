package com.aximilius.endersteel.datagen;

import com.aximilius.endersteel.Endersteel;
import com.aximilius.endersteel.item.ModItem;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Endersteel.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerModels() {
		// TODO Auto-generated method stub
		simpleItem(ModItem.RAW_ENDERSTEEL);
		simpleItem(ModItem.GALVANIZED_ENDERSTEEL);
		simpleItem(ModItem.ENDERSTEEL_NUGGET);

		swordItem(ModItem.GALVANIZED_ENDERSTEEL_SWORD);
		axeItem(ModItem.GALVANIZED_ENDERSTEEL_AXE);
		pickaxeItem(ModItem.GALVANIZED_ENDERSTEEL_PICKAXE);
		shovelItem(ModItem.GALVANIZED_ENDERSTEEL_SHOVEL);
		hoeItem(ModItem.GALVANIZED_ENDERSTEEL_HOE);

		armorItem(ModItem.GALVANIZED_ENDERSTEEL_HELMET);
		armorItem(ModItem.GALVANIZED_ENDERSTEEL_CHESTPLATE);
		armorItem(ModItem.GALVANIZED_ENDERSTEEL_LEGGINGS);
		armorItem(ModItem.GALVANIZED_ENDERSTEEL_BOOTS);
	}
	
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(), 
				new ResourceLocation("item/generated")).texture("layer0", 
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}

	private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}

	private ItemModelBuilder swordItem(RegistryObject<SwordItem> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}

	private ItemModelBuilder axeItem(RegistryObject<AxeItem> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}
	private ItemModelBuilder pickaxeItem(RegistryObject<PickaxeItem> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}
	private ItemModelBuilder shovelItem(RegistryObject<ShovelItem> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}
	private ItemModelBuilder hoeItem(RegistryObject<HoeItem> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}

	private ItemModelBuilder armorItem(RegistryObject<ArmorItem> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(Endersteel.MOD_ID, "item/" + item.getId().getPath()));
	}
}
