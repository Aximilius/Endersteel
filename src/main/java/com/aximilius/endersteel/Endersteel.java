package com.aximilius.endersteel;

import com.aximilius.endersteel.block.ModBlock;
import com.aximilius.endersteel.item.ModItem;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Endersteel.MOD_ID)
public class Endersteel {
    public static final String MOD_ID = "endersteel";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Endersteel() {
    	
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModItem.register(modEventBus);
        ModBlock.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
       
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
    	if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
    		event.accept(ModItem.RAW_ENDERSTEEL);
    		event.accept(ModItem.GALVANIZED_ENDERSTEEL);
    	}
    	
    	if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
    		event.accept(ModBlock.GALVANIZED_ENDERSTEEL_BLOCK);
    	}
    	
    	if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
    		event.accept(ModBlock.ENDERSTEEL_DEPOSIT);
    		event.accept(ModBlock.RAW_ENDERSTEEL_BLOCK);
    	}

        if (event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ModItem.GALVANIZED_ENDERSTEEL_SWORD);
            event.accept(ModItem.GALVANIZED_ENDERSTEEL_AXE);
        }

        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItem.GALVANIZED_ENDERSTEEL_SHOVEL);
            event.accept(ModItem.GALVANIZED_ENDERSTEEL_PICKAXE);
            event.accept(ModItem.GALVANIZED_ENDERSTEEL_AXE);
            event.accept(ModItem.GALVANIZED_ENDERSTEEL_HOE);
        }
    }
    
    
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
