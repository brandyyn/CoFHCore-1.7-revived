package cofh.asmhooks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockWater extends BlockStaticLiquid {

	public BlockWater(Material mat) {

		super(mat);
	}


	@Override
	public boolean isAssociatedBlock(Block block) {

		return super.isAssociatedBlock(block) || block == Blocks.flowing_water;
	}

}
