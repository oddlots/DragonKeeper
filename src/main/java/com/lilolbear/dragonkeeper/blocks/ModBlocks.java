package com.lilolbear.dragonkeeper.blocks;

import com.lilolbear.dragonkeeper.helpers.RegisterHelper;

import net.minecraft.block.Block;

public class ModBlocks 
{
	public static Block shiftingGold;

	public static void loadBlocks() 
	{
		shiftingGold = new BlockShiftingGold().setBlockName("shiftingGold");
		RegisterHelper.registerBlock(shiftingGold);
		
		//TODO add in the blocks the mod will require
		//TODO egg bearing blocks blocks (like ore)
		//TODO hidden egg bearing blocks (like silverfish) like silver fish, if you improperly break these blocks perhaps the infant dragon will emerge and attack 
	}
}
