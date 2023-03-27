package com.aximilius.endersteel.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.aximilius.endersteel.Endersteel;
import com.aximilius.endersteel.worldgen.ModConfiguredFeatures;
import com.aximilius.endersteel.worldgen.ModPlacedFeatures;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Endersteel.MOD_ID));
    }
}
