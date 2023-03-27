package com.aximilius.endersteel.worldgen;

import com.aximilius.endersteel.Endersteel;
import com.aximilius.endersteel.block.ModBlock;


import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

public class ModConfiguredFeatures {
	
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERSTEEL_DEPOSIT_KEY = registerKey("endersteel_deposit");

	 public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

	        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

	        register(context, ENDERSTEEL_DEPOSIT_KEY, Feature.ORE, new OreConfiguration(endstoneReplaceables,
	                ModBlock.ENDERSTEEL_DEPOSIT.get().defaultBlockState(), 9));
	    }
	
	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Endersteel.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
