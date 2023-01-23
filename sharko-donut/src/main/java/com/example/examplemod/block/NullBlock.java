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
		System.out.println("pos1: " + pos.toShortString());
		System.out.println("from pos: " + pos.toShortString());
		boolean signal = level.hasNeighborSignal(pos);
		System.out.println("signal " + signal);
		throw new NullPointerException("Null block got redstone signal");
	}

}
