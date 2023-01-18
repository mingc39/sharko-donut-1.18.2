package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	
	private BlockInit() {}
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);
	
	public static final RegistryObject<Block> SHARKO_BLOCK = BLOCKS.register("sharko_block", 
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

}
