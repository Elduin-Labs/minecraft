package com.elduin.minecraft_mod;

import com.elduin.minecraft_mod.platform.Platform;
import com.elduin.minecraft_mod.platform.fabric.FabricPlatform;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.core.Registry;

@SuppressWarnings("LoggingSimilarMessage")
public class ModTemplate {

	public static final String MOD_ID = /*$ mod_id*/ "minecraft_mod";
	public static final String MOD_VERSION = /*$ mod_version*/ "1.0.0";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Minecraft Mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Item LAUNCH_ORB = registerLaunchOrb();

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_ID, ModTemplate.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
		LOGGER.info("Loaded launch orb item at {}", BuiltInRegistries.ITEM.getKey(LAUNCH_ORB));
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}", MOD_ID, ModTemplate.xplat().loader());
		LOGGER.debug("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		return new FabricPlatform();
	}

	private static Item registerLaunchOrb() {
		Item item = new LaunchOrbItem(new Item.Properties().stacksTo(16));
		return Registry.register(BuiltInRegistries.ITEM, id("launch_orb"), item);
	}

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	private static Identifier id(String namespace, String path) {
		return Identifier.fromNamespaceAndPath(namespace, path);
	}
}
