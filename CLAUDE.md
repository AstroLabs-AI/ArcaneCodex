# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

- `./gradlew build` - Build the mod JAR file
- `./gradlew runClient` - Launch Minecraft client with the mod installed
- `./gradlew runServer` - Launch Minecraft server with the mod installed
- `./gradlew clean` - Clean build outputs
- `./gradlew publish` - Publish mod to local Maven repository

## Architecture Overview

Arcane Codex is an advanced magic-tech Minecraft Forge mod (1.20.1, Java 17) that reimagines Thaumcraft through quantum physics and digital sorcery.

- **Main Mod Class**: `com.astrolabs.arcanecodex.ArcaneCodex` - Entry point and registry initialization
- **Mod ID**: `arcanecodex` - Used for all resource locations and registrations
- **Package Structure**: `com.astrolabs.arcanecodex` - Root package following the design doc structure

### Core Systems

1. **Quantum Energy System** (`api.IQuantumEnergy`)
   - Six energy types: Coherent Light, Quantum Foam, Neural Charge, Temporal Flux, Dark Current, Synthesis Wave
   - Living energy that evolves based on usage
   - Resonance cascades and phase states

2. **Consciousness System** (`api.IConsciousness`)
   - 3D holographic research tree
   - Player augmentation with body slots
   - Neural charge as player resource

3. **Reality Programming Language (RPL)**
   - Custom language for world manipulation
   - Interpreted at runtime for effects

4. **Dimension Creation**
   - Procedural dimension generation
   - Player-created dimensions with custom rules

Key directories:
- `src/main/java/com/astrolabs/arcanecodex/` - Main source code
- `src/main/java/com/astrolabs/arcanecodex/api/` - Public API interfaces
- `src/main/java/com/astrolabs/arcanecodex/common/` - Core mod content
- `src/main/java/com/astrolabs/arcanecodex/client/` - Client-side rendering/GUI
- `src/main/resources/` - Assets and data files

## Development Guidelines

- All quantum calculations should use worker threads
- Energy networks must be optimized for large bases
- Client-server sync is critical for multiplayer
- Use capabilities for player data storage
- Follow the tier progression system (0-5)
- Visual effects should reflect quantum state

## Testing Commands

- `./gradlew test` - Run unit tests
- `./gradlew runData` - Generate data files (recipes, tags, etc.)

## Key Implementation Details

### Registry System
All content is registered through dedicated registry classes:
- `ModBlocks` - Block registration
- `ModItems` - Item registration
- `ModBlockEntities` - Tile entity registration
- `ModMenuTypes` - GUI container registration
- `ModParticles` - Particle effect registration
- `ModCapabilities` - Capability registration

### Network System
- `ModNetworking` handles all packet registration
- Packets are in `network.packets` package
- Use for client-server sync of complex data

### Data Generation
- Recipes are JSON files in `src/main/resources/data/arcanecodex/recipes/`
- Block states and models in `src/main/resources/assets/arcanecodex/`
- Language files in `src/main/resources/assets/arcanecodex/lang/`

### Current Development State
- Phase 2 (Consciousness Systems) in progress
- Core blocks and energy system implemented
- RPL parser functional with basic commands
- GUI systems and research tree pending implementation