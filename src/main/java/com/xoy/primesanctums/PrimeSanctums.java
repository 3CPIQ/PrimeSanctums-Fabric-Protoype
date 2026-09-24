package com.xoy.primesanctums;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.literal;

public class PrimeSanctums implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(literal("prime")
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("p1")
                    .then(literal("start").executes(ctx -> run(ctx, "p1:start", "Started P-1")))
                    .then(literal("only")
                        .then(literal("minos").executes(ctx -> run(ctx, "primesanctums:only/minos", "Spawned Minos Prime only")))
                        .then(literal("fleshprison").executes(ctx -> run(ctx, "primesanctums:only/fleshprison", "Spawned Flesh Prison only")))))
                .then(literal("p2")
                    .then(literal("start").executes(ctx -> run(ctx, "p2:start", "Started P-2")))
                    .then(literal("only")
                        .then(literal("sisyphus").executes(ctx -> run(ctx, "primesanctums:only/sisyphus", "Spawned Sisyphus Prime only")))
                        .then(literal("panopticon").executes(ctx -> run(ctx, "primesanctums:only/panopticon", "Spawned Panopticon only")))))
            )
        );
    }

    private static int run(CommandContext<ServerCommandSource> context, String function, String message) {
        ServerCommandSource source = context.getSource();
        int result = source.getServer().getCommandManager().executeWithPrefix(source, "function " + function);
        source.sendFeedback(() -> Text.literal("[Prime Sanctums] " + message), true);
        return result;
    }
}
