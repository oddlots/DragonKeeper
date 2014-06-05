package com.lilolbear.dragonkeeper.helpers;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RegisterHelper 
{
	public static void registerBlock( Block block )
	{
		GameRegistry.registerBlock(block, Reference.MODID + "_" + block.getUnlocalizedName().substring(5) );
        System.out.println("registerBlock called for " + block.getUnlocalizedName().substring(5) );
	}
	
	public static void registerItem( Item item )
	{
		GameRegistry.registerItem(item, Reference.MODID + "_" + item.getUnlocalizedName().substring(5) );
        System.out.println("registerItem called for " + item.getUnlocalizedName().substring(5) );
		
	}	
}
