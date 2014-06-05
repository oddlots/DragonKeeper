package com.lilolbear.dragonkeeper.helpers;


import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.world.World;

public class BlockShifter 
{
	static int[][] positions = new int[][]{ {1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1} };
	
	public static Boolean isShiftable( Block block )
	{
		if ( block instanceof BlockFalling )
		{
			return true;
		}
		// else if ( block instanceof BlockDirt && world.isRaining )
		return false;
	}
	
	public static void shiftBlock( World world, Block block, int x, int y, int z, Boolean fallInstantly )
	{
        if ( y > 0 && isShiftable( block ) && isShiftable( world.getBlock(x, y - 1, z) ) )
        {
        	//look for a position to shift it to
        	for ( int i:randomIndexArray() )
        	{
        		// is there a space for it to shift to
        		if ( BlockFalling.func_149831_e( world, x+positions[i][0], y - 1, z+positions[i][1] ) )
        		{
        			// if the spot above it is available then shift to there and let the falling animation do it
            		if ( BlockFalling.func_149831_e( world, x+positions[i][0], y - 1, z+positions[i][1] ) )
            		{
            			world.setBlock(x+positions[i][0], y, z+positions[i][1], block);
            		}
            		else
            		{
            			world.setBlock(x+positions[i][0], y - 1, z+positions[i][1], block);
            		}
        			world.setBlockToAir(x, y, z);
        			break;
        		}
        	}
	    }
	}
	
	public static int[] randomIndexArray()
	{
		int[] ar = new int[]{ 0,1,2,3,4,5,6,7 };
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
		return ar;
	}
}
