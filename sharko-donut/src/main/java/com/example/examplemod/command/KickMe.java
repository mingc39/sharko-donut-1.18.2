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

public class KickMe {
	
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		LiteralArgumentBuilder<CommandSourceStack> kickMe = Commands.literal("kickme");
		kickMe.executes(context -> kickme(context.getSource()));
		dispatcher.register(kickMe);
	}
	
	public static int kickme(CommandSourceStack source) {
		try {
			ServerPlayer player = source.getPlayerOrException();
			player.connection.disconnect(new TextComponent("킼미킼미킼미없"));
			LogUtils.getLogger().info("플레이어 \"" + player.getName().getString() + "\"(이)가 대오하였습니다.");
		} catch (CommandSyntaxException e) {
			//e.printStackTrace();
			LogUtils.getLogger().error("플레이어가 아닌 엔티티가 대오하려 하빈다. 서버가 폭파됩니다");
			source.getServer().stopServer();
		}
		/*
		if (source.getEntity() instanceof Player) {
			Player player = (Player)source.getEntity();
			player.con
		}*/
		
		return Command.SINGLE_SUCCESS;
	}

}
