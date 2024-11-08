package cofh.asmhooks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockTickingWater extends BlockDynamicLiquid {

	public BlockTickingWater(Material mat) {

		super(mat);
	}


	@Override
	public boolean isAssociatedBlock(Block block) {

		return super.isAssociatedBlock(block) || block == Blocks.water;
	}

}
