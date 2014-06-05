package com.lilolbear.dragonkeeper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import com.lilolbear.dragonkeeper.blocks.ModBlocks;
import com.lilolbear.dragonkeeper.entities.ModEntities;
import com.lilolbear.dragonkeeper.handlers.ModRecipes;
import com.lilolbear.dragonkeeper.helpers.Reference;
import com.lilolbear.dragonkeeper.items.ModItems;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class DragonKeeper 
{
    /**
     * Register all of the Blocks, recipes and items you will be using
     * @param event
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModBlocks.loadBlocks();
        ModEntities.loadEntities();
        ModRecipes.loadRecipes();
        ModItems.loadItems();
    }

    /**
     * data structures
     * @param event
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }

    /**
     * Place stuff for between mods here.  
     * @param event
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		// 
    }

}
