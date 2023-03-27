package com.aximilius.endersteel.datagen;

import com.aximilius.endersteel.Endersteel;
import com.aximilius.endersteel.item.ModItem;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
}
