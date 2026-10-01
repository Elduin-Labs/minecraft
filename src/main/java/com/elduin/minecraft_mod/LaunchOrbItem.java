package com.elduin.minecraft_mod;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class LaunchOrbItem extends Item {

	public LaunchOrbItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (level.isClientSide()) {
			return InteractionResult.SUCCESS;
		}

		if (!player.getCooldowns().isOnCooldown(stack)) {
			Vec3 motion = player.getDeltaMovement();
			player.setDeltaMovement(motion.x, 1.25D, motion.z);
			player.hurtMarked = true;
			player.getCooldowns().addCooldown(stack, 10);
			level.playSound(null, player.blockPosition(), SoundEvents.GHAST_SHOOT, SoundSource.PLAYERS, 1.0F, 1.2F);
			player.displayClientMessage(Component.literal("Boop!"), true);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.SUCCESS;
		}

		return InteractionResult.PASS;
	}
}
