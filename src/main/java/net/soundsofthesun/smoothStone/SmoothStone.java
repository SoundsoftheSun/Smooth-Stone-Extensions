package net.soundsofthesun.smoothStone;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class SmoothStone implements ModInitializer {
    public static final String MOD_ID = "smooth_stone_extensions";

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.accept(SMOOTH_STONE_STAIRS.asItem());
            itemGroup.accept(SMOOTH_STONE_WALL.asItem());
            itemGroup.accept(POLISHED_SMOOTH_STONE.asItem());
            itemGroup.accept(POLISHED_SMOOTH_STONE_WALL.asItem());
            itemGroup.accept(POLISHED_SMOOTH_STONE_STAIRS.asItem());
        });
    }

    public static final Block POLISHED_SMOOTH_STONE = register(
            "polished_smooth_stone",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE),
            true
    );

    public static final Block SMOOTH_STONE_STAIRS = register(
            "smooth_stone_stairs",
            p -> new StairBlock(Blocks.SMOOTH_STONE.defaultBlockState(), p),
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS),
            true
    );

    public static final Block SMOOTH_STONE_WALL = register(
            "smooth_stone_wall",
            WallBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.SMOOTH_STONE).forceSolidOn(),
            true
    );

    public static final Block POLISHED_SMOOTH_STONE_WALL = register(
            "polished_smooth_stone_wall",
            WallBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.SMOOTH_STONE).forceSolidOn(),
            true
    );

    public static final Block POLISHED_SMOOTH_STONE_STAIRS = register(
            "polished_smooth_stone_stairs",
            p -> new StairBlock(Blocks.SMOOTH_STONE.defaultBlockState(), p),
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS),
            true
    );

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
    }


}
