package net.soundsofthesun.smoothStone.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.soundsofthesun.smoothStone.SmoothStone;

import java.util.concurrent.CompletableFuture;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(SmoothStone.SMOOTH_STONE_STAIRS);
        dropSelf(SmoothStone.SMOOTH_STONE_WALL);
        dropSelf(SmoothStone.POLISHED_SMOOTH_STONE);
        dropSelf(SmoothStone.POLISHED_SMOOTH_STONE_STAIRS);
        dropSelf(SmoothStone.POLISHED_SMOOTH_STONE_WALL);
    }
}
