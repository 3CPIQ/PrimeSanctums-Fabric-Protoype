# Prime Sanctums Fabric Prototype

Standalone Fabric 1.20.1 port of the Prime Sanctums P-1/P-2 datapack + resource pack.

Ultracraft is optional: the mod is designed to run without it, while optional compatibility excludes common Ultracraft projectile/entity types if Ultracraft is installed.

## Commands

- `/prime p1 start` — starts Flesh Prison → Minos Prime
- `/prime p2 start` — starts Panopticon → Sisyphus Prime
- `/prime p1 only minos` — Minos only; no P-1 chain
- `/prime p1 only fleshprison` — Flesh Prison only; no Minos release
- `/prime p2 only sisyphus` — Sisyphus only; no P-2 chain
- `/prime p2 only panopticon` — Panopticon only; no Sisyphus release

Commands require permission level 2.

## Port strategy

This first prototype preserves the existing datapack/Animated-Java boss implementation by bundling the datapack data and resource-pack assets inside the Fabric mod JAR. The command layer is native Fabric/Brigadier Java.

Hard Ultracraft entity selectors are replaced with optional compatibility tags, and Ultracraft-only shockwave summons are replaced with standalone vanilla fallbacks.

## Resource bundle

The complete transformed resource bundle is `vendor/prime_sanctums_resources.zip`. The initial ChatGPT GitHub connector can write source files but cannot directly upload this ~30 MB binary archive, so use the complete project ZIP from the chat to add the vendor archive to this repo before the first build.
