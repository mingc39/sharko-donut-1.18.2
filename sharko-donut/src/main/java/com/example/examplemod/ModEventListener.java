package com.example.examplemod;

import com.example.examplemod.command.KickMe;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid="examplemod")
public class ModEventListener {
	
	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		KickMe.register(event.getDispatcher());
	}

}
