package com.astrolabs.arcanecodex.common.items.augments;

import com.astrolabs.arcanecodex.api.IConsciousness;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class QuantumCoreAugment extends AugmentItem {
    
    public QuantumCoreAugment(Properties properties) {
        super(properties, "cardiovascular", 4);
    }
    
    @Override
    protected void applyAugmentEffects(Player player, IConsciousness consciousness) {
        // Increase max neural charge by modifying consciousness level
        consciousness.setConsciousnessLevel(consciousness.getConsciousnessLevel() + 1);
    }
    
    @Override
    protected void removeAugmentEffects(Player player, IConsciousness consciousness) {
        // Decrease consciousness level
        consciousness.setConsciousnessLevel(Math.max(0, consciousness.getConsciousnessLevel() - 1));
    }
    
    @Override
    protected void addAugmentDescription(List<Component> tooltip) {
        tooltip.add(Component.literal("+100 Max Neural Charge")
            .withStyle(ChatFormatting.GOLD));
        tooltip.add(Component.literal("+50% Energy Resonance")
            .withStyle(ChatFormatting.YELLOW));
        tooltip.add(Component.literal("Quantum coherence amplification")
            .withStyle(ChatFormatting.DARK_PURPLE));
    }
}