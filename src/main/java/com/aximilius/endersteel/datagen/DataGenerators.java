package com.aximilius.endersteel.datagen;

import java.util.concurrent.CompletableFuture;

import com.aximilius.endersteel.Endersteel;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Endersteel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		
		generator.addProvider(true,  new ModRecipeProvider(packOutput));
		generator.addProvider(true,  ModLootTableProvider.create(packOutput));
		generator.addProvider(true,  new ModBlockStateProvider(packOutput, existingFileHelper));
		generator.addProvider(true,  new ModItemModelProvider(packOutput, existingFileHelper));
		generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
	}

}
