package com.astrolabs.arcanecodex.client;

import com.astrolabs.arcanecodex.ArcaneCodex;
import com.astrolabs.arcanecodex.client.gui.holographic.ResearchTreeScreen;
import com.astrolabs.arcanecodex.client.particles.HolographicParticle;
import com.astrolabs.arcanecodex.client.particles.NeuralSparkParticle;
import com.astrolabs.arcanecodex.common.particles.ModParticles;
import com.astrolabs.arcanecodex.common.particles.QuantumParticle;
import com.astrolabs.arcanecodex.common.registry.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ArcaneCodex.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuTypes.RESEARCH_TREE.get(), ResearchTreeScreen::new);
            MenuScreens.register(ModMenuTypes.REALITY_COMPILER.get(), 
                com.astrolabs.arcanecodex.client.gui.RealityCompilerScreen::new);
        });
    }
    
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        // Register particle factories - the particles should be registered by now
        event.registerSpriteSet(ModParticles.QUANTUM_ENERGY.get(), QuantumParticle.Factory::new);
        event.registerSpriteSet(ModParticles.NEURAL_SPARK.get(), NeuralSparkParticle.Factory::new);
        event.registerSpriteSet(ModParticles.HOLOGRAPHIC.get(), HolographicParticle.Factory::new);
        event.registerSpriteSet(ModParticles.REALITY_GLITCH.get(), QuantumParticle.Factory::new);
    }
}