# IMPORTANT: JAR Files in this Directory

## Available JARs:

- **`arcanecodex-0.2.0.jar`** - ✅ The compiled mod JAR ready for Minecraft
- **`arcanecodex-1.20.1-0.3.0-source.jar`** - ❌ Source code JAR (NOT for gameplay)

## For Players

**USE THIS FILE:** `arcanecodex-0.2.0.jar`

### Installation:
1. Make sure you have Minecraft Forge 1.20.1 (version 47.2.0 or higher)
2. Copy `arcanecodex-0.2.0.jar` to your Minecraft mods folder
3. Launch Minecraft with Forge

## ⚠️ WARNING: About the Source JAR ⚠️

The file `arcanecodex-1.20.1-0.3.0-source.jar` is a **source code archive**, not a compiled mod. It cannot be loaded by Minecraft Forge because it contains `.java` files instead of compiled `.class` files.

### Error You'll See If You Use the Wrong JAR:
```
[FATAL]: The Mod File has mods that were not found
```

## Building from Source

If you want to build the mod yourself:

1. Clone the repository
2. Run `./gradlew build`
3. The compiled JAR will be in `build/libs/`
4. Use the JAR without "-source" in the name

## For Developers

The source JAR (`arcanecodex-1.20.1-0.3.0-source.jar`) contains:
- Complete source code for all systems
- 40+ Java source files
- All recipes, lang files, and resources
- Implementation of:
  - Quantum Energy System
  - Consciousness System
  - Reality Programming Language
  - All blocks, items, and GUIs

This source code demonstrates advanced Minecraft modding concepts and can serve as a reference for implementing similar systems.