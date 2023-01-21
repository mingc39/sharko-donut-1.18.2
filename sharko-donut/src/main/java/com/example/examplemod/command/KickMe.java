package com.example.examplemod.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.logging.LogUtils;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.server.ServerLifecycleHooks;

public class KickMe {
	
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		LiteralArgumentBuilder<CommandSourceStack> kickMe = Commands.literal("kickme");
		kickMe.executes(context -> kickme(context.getSource()));
		dispatcher.register(kickMe);
	}
	
	public static int kickme(CommandSourceStack source) {
		try { // 플레이어가 실행할때
			ServerPlayer player = source.getPlayerOrException();
			
			// 실행자 킼
			player.connection.disconnect(new TextComponent("킼미킼미킼미없"));
			
			// 콘솔 및 다른 플레이어에 공지
			LogUtils.getLogger().info("[KickMe] 플레이어 \"" + player.getName().getString() + "\"(이)가 대오하였습니다.");
			TextComponent textComponent = new TextComponent("플레이어 \"" + player.getName().getString() + "\"(이)가 대오하였습니다.");
			source.getServer().getPlayerList().getPlayers().forEach(p -> p.sendMessage(textComponent, null));
			
		} catch (CommandSyntaxException e) {
			LogUtils.getLogger().error("[KickMe] 플레이어가 아닌 엔티티가 대오하려 하빈다. 서버가 폭파됩니다");
			source.getServer().halt(false);
			//ServerLifecycleHooks.getCurrentServer().halt(false);
			
		}
		/*
		if (source.getEntity() instanceof Player) {
			Player player = (Player)source.getEntity();
			player.con
		}*/
		
		return Command.SINGLE_SUCCESS;
	}

}
