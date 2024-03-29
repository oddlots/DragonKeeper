package com.lilolbear.dragonkeeper.blocks;

import java.util.List;
import java.util.Random;

import com.lilolbear.dragonkeeper.helpers.BlockShifter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockShiftingGold extends BlockFalling
{
    public static final String[] field_149838_a = new String[] {"default", "red"};
    @SideOnly(Side.CLIENT)
    private static IIcon field_149837_b;
    @SideOnly(Side.CLIENT)
    private static IIcon field_149839_N;
    private static final String __OBFID = "CL_00000303";

	public BlockShiftingGold()
	{
		super();
		setBlockName("shiftingGold");
	}

    /**
     * Ticks the block if it's been scheduled. Overridden to allow for sliding on update
     */
	@Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
		super.updateTick(world, x, y, z, rand);
        if (!world.isRemote)
        {
        	BlockShifter.shiftBlock(world, this, x, y, z, fallInstantly);
        }
    }
	
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_2_ == 1 ? field_149839_N : field_149837_b;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        field_149837_b = p_149651_1_.registerIcon("sand");
        field_149839_N = p_149651_1_.registerIcon("red_sand");
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
    }

    public MapColor getMapColor(int p_149728_1_)
    {
        return p_149728_1_ == 1 ? MapColor.dirtColor : MapColor.sandColor;
    }
}
