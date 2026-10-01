package com.elduin.minecraft_mod.platform.fabric;

//? fabric {

import com.elduin.minecraft_mod.ModTemplate;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		ModTemplate.onInitialize();
		FabricEventSubscriber.registerEvents();
	}
}
//?}
