package net.soundsofthesun.smoothStone.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.soundsofthesun.smoothStone.SmoothStone;

import java.util.concurrent.CompletableFuture;

public class TagProvider extends FabricTagProvider.BlockTagProvider {
    public TagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SmoothStone.POLISHED_SMOOTH_STONE_WALL)
                .add(SmoothStone.SMOOTH_STONE_WALL)
                .add(SmoothStone.SMOOTH_STONE_STAIRS)
                .add(SmoothStone.POLISHED_SMOOTH_STONE_STAIRS)
                .add(SmoothStone.POLISHED_SMOOTH_STONE)
                .setReplace(false);

    }
}
