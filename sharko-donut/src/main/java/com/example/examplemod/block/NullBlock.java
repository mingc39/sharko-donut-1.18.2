package com.example.examplemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class NullBlock extends Block {

	public NullBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void neighborChanged(BlockState blockState, Level level, BlockPos pos, Block block,
			BlockPos fromPos, boolean isMoving) {
		boolean signal = level.hasNeighborSignal(pos);
		throw new NullPointerException("Null block got redstone signal");
	}

}
