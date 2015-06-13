package com.cricketcraft.chisel.block.stone;

import com.cricketcraft.chisel.block.BlockCarvable;
import com.cricketcraft.chisel.init.ChiselProperties;
import com.cricketcraft.chisel.init.ChiselTabs;
import com.cricketcraft.chisel.util.BlockVariant;
import com.cricketcraft.chisel.util.IBlockWithSubtypes;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockBricks extends BlockCarvable implements IBlockWithSubtypes {

	public BlockBricks(){
		super();
		setCreativeTab(ChiselTabs.tabStoneChiselBlocks);
		setDefaultState(this.getBlockState().getBaseState().withProperty(ChiselProperties.BRICKS_VARIANTS, ChiselProperties.BRICKS_VARIANTS.fromMeta(0)));
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for (BlockVariant variant : ChiselProperties.BRICKS_VARIANTS.getAllowedValues()) {
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ChiselProperties.BRICKS_VARIANTS, ChiselProperties.BRICKS_VARIANTS.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockVariant) state.getValue(ChiselProperties.BRICKS_VARIANTS)).getMeta();
	}

	@Override
	public String getSubtypeUnlocalizedName(ItemStack stack) {
		return ChiselProperties.BRICKS_VARIANTS.fromMeta(stack.getMetadata()).getName();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, ChiselProperties.BRICKS_VARIANTS);
	}
}
