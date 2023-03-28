package com.aximilius.endersteel.datagen;

import java.util.function.Consumer;

import com.aximilius.endersteel.Endersteel;
import com.aximilius.endersteel.block.ModBlock;
import com.aximilius.endersteel.item.ModItem;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(PackOutput output) {
		super(output);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

			ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.RAW_ENDERSTEEL.get(), 9)
            		.requires(ModBlock.RAW_ENDERSTEEL_BLOCK.get())
            		.unlockedBy("has_raw_endersteel_block", inventoryTrigger(ItemPredicate.Builder.item()
            				.of(ModBlock.RAW_ENDERSTEEL_BLOCK.get()).build()))
            		.save(consumer);
			
			ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.GALVANIZED_ENDERSTEEL.get(), 9)
            		.requires(ModBlock.GALVANIZED_ENDERSTEEL_BLOCK.get())
					.group("galvanized_endersteel_from_block")
            		.unlockedBy("has_galvanized_endersteel_block", inventoryTrigger(ItemPredicate.Builder.item()
            				.of(ModBlock.GALVANIZED_ENDERSTEEL_BLOCK.get()).build()))
            		.save(consumer, "endersteel:galvanized_endersteel_from_block");

			ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.ENDERSTEEL_NUGGET.get(), 9)
				.requires(ModItem.GALVANIZED_ENDERSTEEL.get())
				.unlockedBy("has_galvanized_endersteel", inventoryTrigger(ItemPredicate.Builder.item()
						.of(ModItem.GALVANIZED_ENDERSTEEL.get()).build()))
				.save(consumer);
			
			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.RAW_ENDERSTEEL_BLOCK.get())
	        		.define('B', ModItem.RAW_ENDERSTEEL.get())
	        		.pattern("BBB")
	        		.pattern("BBB")
	        		.pattern("BBB")
	        		.unlockedBy("has_raw_endersteel", inventoryTrigger(ItemPredicate.Builder.item()
	        				.of(ModItem.RAW_ENDERSTEEL.get()).build()))
	        		.save(consumer);
			
			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.GALVANIZED_ENDERSTEEL_BLOCK.get())
    				.define('B', ModItem.GALVANIZED_ENDERSTEEL.get())
    				.pattern("BBB")
    				.pattern("BBB")
    				.pattern("BBB")
    				.unlockedBy("has_galvanized_endersteel", inventoryTrigger(ItemPredicate.Builder.item()
    						.of(ModItem.GALVANIZED_ENDERSTEEL.get()).build()))
    				.save(consumer);

			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.GALVANIZED_ENDERSTEEL.get())
					.define('B', ModItem.ENDERSTEEL_NUGGET.get())
					.pattern("BBB")
					.pattern("BBB")
					.pattern("BBB")
					.group("galvanized_endersteel_from_nugget")
					.unlockedBy("has_endersteel_nugget", inventoryTrigger(ItemPredicate.Builder.item()
							.of(ModItem.ENDERSTEEL_NUGGET.get()).build()))
					.save(consumer, "endersteel:galvanized_endersteel_from_nugget");
			/*
			SmithingTransformRecipeBuilder.smithing(Ingredient.of(),
					Ingredient.of(Blocks.NETHERITE_BLOCK),
					Ingredient.of(ModItem.RAW_ENDERSTEEL.get()),
					RecipeCategory.MISC, ModItem.GALVANIZED_ENDERSTEEL.get())
					.unlocks("has_galvanized_endersteel", has(ModItem.GALVANIZED_ENDERSTEEL.get())).save(consumer, getItemName(ModItem.GALVANIZED_ENDERSTEEL.get()) + "_smithing");
			 */
	}

}
