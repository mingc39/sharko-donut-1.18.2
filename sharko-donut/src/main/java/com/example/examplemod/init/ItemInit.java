package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);
	
	public static final RegistryObject<Item> SHARKO_ITEM = ITEMS.register("sharko_item",
			() -> new Item(new Item.Properties().tab(ExampleMod.CREATIVE_TAB)));
	
	public static final RegistryObject<BlockItem> SHARKO_BLOCK_ITEM = ITEMS.register("sharko_block", 
			() -> new BlockItem(BlockInit.SHARKO_BLOCK.get(), new Item.Properties().tab(ExampleMod.CREATIVE_TAB)));
	public static final RegistryObject<BlockItem> NULL_BLOCK_ITEM = ITEMS.register("null_block", 
			() -> new BlockItem(BlockInit.NULL_BLOCK.get(), new Item.Properties().tab(ExampleMod.CREATIVE_TAB)));

}
