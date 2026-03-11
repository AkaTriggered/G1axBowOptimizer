# G1axBowOptimizer

<div align="center">

![Minecraft](https://img.shields.io/badge/Minecraft-1.21.11-green.svg)
![Fabric](https://img.shields.io/badge/Mod%20Loader-Fabric-dbd0b4.svg)
![Side](https://img.shields.io/badge/Side-Client-blue.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

**A Fabric client-side mod that removes artificial delays when using bows and crossbows**

[Download](https://github.com/AkaTriggered/G1axBowOptimizer/releases) • [Modrinth](https://modrinth.com/mod/g1axbowoptimizer) • [Issues](https://github.com/AkaTriggered/G1axBowOptimizer/issues)

</div>

---

## 🎯 What It Does

G1axBowOptimizer eliminates the client-side delay caused by server round-trip times when using bows and crossbows:

- ⚡ **Instant arrow/bolt release** - Fire immediately when you release right-click
- 🎨 **No animation desync** - Bow stays drawn for the correct duration
- 🌐 **Consistent on any ping** - Works the same on 10ms or 200ms ping
- 🔄 **Instant item switching** - Switch items immediately after firing
- 🏹 **Responsive rapid fire** - Spam shooting feels smooth and consistent

## ❌ The Problem

By default, Minecraft requires server confirmation before registering a bow/crossbow shot. On high ping servers this causes:

- Visible delay between releasing and arrow firing
- Animation desync where the bow stays drawn too long
- Inconsistent arrow timing due to server recalls
- Sluggish item switching after firing
- Unresponsive rapid firing

## ✅ The Solution

G1axBowOptimizer processes bow and crossbow mechanics **entirely client-side**:

- Tracks draw/charge progress locally without waiting for server
- Suppresses server-sent desync packets when client has correctly completed the action
- Allows instant item switching after release
- Works on **any server** (vanilla, modded, public SMPs) - no server-side changes needed

## 📦 Installation

1. Install [Fabric Loader](https://fabricmc.net/use/)
2. Install [Fabric API](https://modrinth.com/mod/fabric-api)
3. Download `g1axbowoptimizer-1.0.0.jar` from [Releases](https://github.com/AkaTriggered/G1axBowOptimizer/releases)
4. Drop the jar into your `.minecraft/mods` folder
5. Launch Minecraft and enjoy instant bow mechanics!

## 🔧 Compatibility

| | |
|---|---|
| **Minecraft Version** | 1.21.11 |
| **Mod Loader** | Fabric |
| **Side** | Client-only |
| **Dependencies** | Fabric API |
| **Compatible with** | OptiFine, Sodium, Lithium, Iris, and other client optimization mods |

## 🧪 Testing

To verify the mod works:

1. **High Ping Test**: Join a server with 100+ ms ping
   - Without mod: Notice delay between release and arrow firing
   - With mod: Arrow fires instantly on release

2. **Rapid Fire Test**: Spam click with a bow
   - Without mod: Inconsistent timing, feels sluggish
   - With mod: Consistent, responsive rapid fire

3. **Item Switch Test**: Fire bow then immediately switch items
   - Without mod: Delay before you can switch
   - With mod: Instant switching

## 🛠️ Technical Details

The mod uses Mixin to:
- Hook into `BowItem` and `CrossbowItem` to track usage
- Intercept `ClientPlayerInteractionManager` to detect when drawing starts/stops
- Suppress unnecessary server packets via `ClientPlayNetworkHandler`
- Track charge progress via `ClientPlayerEntity` tick events

**Note**: The server still authoritatively handles all damage and arrow physics. This mod only optimizes client perception and input responsiveness.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**AkaTriggered / G1ax**

- GitHub: [@AkaTriggered](https://github.com/AkaTriggered)
- Project: [G1axBowOptimizer](https://github.com/AkaTriggered/G1axBowOptimizer)

## 🐛 Issues & Support

Found a bug or have a suggestion? [Open an issue](https://github.com/AkaTriggered/G1axBowOptimizer/issues)!

---

<div align="center">

Made with ❤️ for the Minecraft community

</div>
