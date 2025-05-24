package com.astrolabs.arcanecodex.common.items.augments;

import com.astrolabs.arcanecodex.api.IConsciousness;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.UUID;

public class PhaseShiftAugment extends AugmentItem {
    
    private static final UUID HEALTH_MODIFIER_UUID = UUID.fromString("8a7b5f32-7e82-4d8e-9b2e-4c5f8a9b3d7e");
    
    public PhaseShiftAugment(Properties properties) {
        super(properties, "skeletal", 3);
    }
    
    @Override
    protected void applyAugmentEffects(Player player, IConsciousness consciousness) {
        // Add health modifier
        player.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(
            new AttributeModifier(HEALTH_MODIFIER_UUID, "Phase Shift Health", 4.0, AttributeModifier.Operation.ADDITION)
        );
        player.setHealth(player.getHealth() + 4.0f);
    }
    
    @Override
    protected void removeAugmentEffects(Player player, IConsciousness consciousness) {
        // Remove health modifier
        player.getAttribute(Attributes.MAX_HEALTH).removeModifier(HEALTH_MODIFIER_UUID);
        if (player.getHealth() > player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
        }
    }
    
    @Override
    protected void addAugmentDescription(List<Component> tooltip) {
        tooltip.add(Component.literal("+2 Hearts")
            .withStyle(ChatFormatting.RED));
        tooltip.add(Component.literal("Phase through reality")
            .withStyle(ChatFormatting.DARK_RED));
        tooltip.add(Component.literal("Damage resistance when phasing")
            .withStyle(ChatFormatting.DARK_RED));
    }
}