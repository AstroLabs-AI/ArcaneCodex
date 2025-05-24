# Arcane Codex

An advanced magic-tech Minecraft mod that reimagines Thaumcraft through quantum physics and digital sorcery.

## Overview

Arcane Codex brings together cutting-edge quantum mechanics and mystical forces in Minecraft 1.20.1. Harness six types of living quantum energy, expand your consciousness through neural augmentation, and manipulate reality itself using the Reality Programming Language (RPL).

## Features

- **Quantum Energy System**: Six unique energy types that evolve and interact
  - Coherent Light
  - Quantum Foam
  - Neural Charge
  - Temporal Flux
  - Dark Current
  - Synthesis Wave

- **Consciousness Expansion**: Augment your player with neural implants and body modifications
- **Reality Programming**: Write code to manipulate the world using RPL
- **Advanced Machines**: Quantum harvesters, neural interfaces, and reality compilers
- **Research System**: 3D holographic research tree with memory fragments
- **Particle Effects**: Stunning visual feedback for all quantum interactions

## Requirements

- Minecraft 1.20.1
- Minecraft Forge 47.2.0 or higher
- Java 17

## Installation

1. Download the latest release from the [Releases](https://github.com/AstroLabs-AI/ArcaneCodex/releases) page
2. Place the JAR file in your Minecraft mods folder
3. Launch Minecraft with Forge

## Development

### Building from Source

```bash
git clone https://github.com/AstroLabs-AI/ArcaneCodex.git
cd ArcaneCodex
./gradlew build
```

The built JAR will be in `build/libs/`

### Development Commands

- `./gradlew build` - Build the mod
- `./gradlew runClient` - Launch test client
- `./gradlew runServer` - Launch test server
- `./gradlew clean` - Clean build outputs

### Auto-commit Script

The repository includes an auto-commit script with version bumping:

```bash
# Regular commit
./auto-commit.sh

# Commit with version bump
./auto-commit.sh --bump-patch  # 0.2.0 -> 0.2.1
./auto-commit.sh --bump-minor  # 0.2.0 -> 0.3.0
./auto-commit.sh --bump-major  # 0.2.0 -> 1.0.0
```

## CI/CD

This project uses GitHub Actions for automated builds and releases:

- **Automatic Builds**: Every push and PR triggers a build
- **Auto-tagging**: Pushing to main creates version tags automatically
- **Release Creation**: Tags trigger automatic GitHub releases with JAR artifacts
- **Version Management**: Manual version bump workflow available

## Contributing

Contributions are welcome! Please feel free to submit issues and pull requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Credits

Created by AstroLabs AI