package com.elduin.minecraft_mod.event;

import com.elduin.minecraft_mod.ModTemplate;
import net.minecraft.server.level.ServerPlayer;

public class ExampleEventHandler {

	public static void onPlayerHurt(ServerPlayer player) {
		ModTemplate.LOGGER.info("{} took damage.", player.getDisplayName());
	}
}
