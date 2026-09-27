package net.mcreator.evenbetternether.init;

import java.util.function.Supplier;
import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.mcreator.evenbetternether.block.ImportedStalactiteBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Selective, dependency-free BetterNether imports.
 *
 * <p>This registry deliberately lives beside the reconstructed MCreator
 * registries so imported content can be added incrementally without pulling
 * BCLib or WunderLib into the finished mod.</p>
 */
public final class BlackForgeImportedBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EvenbetternetherMod.MODID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EvenbetternetherMod.MODID);

    private static final BlockBehaviour.Properties OBSIDIAN = BlockBehaviour.Properties.copy(Blocks.OBSIDIAN);
    private static final BlockBehaviour.Properties OBSIDIAN_GLASS_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS)
            .strength(50.0F, 1200.0F)
            .noOcclusion();

    public static final RegistryObject<Block> BASALT_BRICK_WALL = wall("basalt_brick_wall", Blocks.POLISHED_BASALT);
    public static final RegistryObject<Block> SOUL_SANDSTONE_WALL = wall("soul_sandstone_wall", Blocks.SANDSTONE);

    public static final RegistryObject<Block> NETHERRACK_STALACTITE = stalactite("netherrack_stalactite", Blocks.NETHERRACK);
    public static final RegistryObject<Block> GLOWSTONE_STALACTITE = stalactite("glowstone_stalactite", Blocks.GLOWSTONE);
    public static final RegistryObject<Block> BLACKSTONE_STALACTITE = stalactite("blackstone_stalactite", Blocks.BLACKSTONE);
    public static final RegistryObject<Block> BASALT_STALACTITE = stalactite("basalt_stalactite", Blocks.BASALT);
    public static final RegistryObject<Block> BONE_STALACTITE = stalactite("bone_stalactite", Blocks.BONE_BLOCK);

    public static final RegistryObject<Block> WEEPING_OBSIDIAN = solid("weeping_obsidian");
    public static final RegistryObject<Block> OBSIDIAN_BRICKS = solid("obsidian_bricks");
    public static final RegistryObject<Block> OBSIDIAN_BRICKS_STAIRS = stairs("obsidian_bricks_stairs", OBSIDIAN_BRICKS);
    public static final RegistryObject<Block> OBSIDIAN_BRICKS_SLAB = slab("obsidian_bricks_slab");
    public static final RegistryObject<Block> OBSIDIAN_TILE = solid("obsidian_tile");
    public static final RegistryObject<Block> OBSIDIAN_TILE_SMALL = solid("obsidian_tile_small");
    public static final RegistryObject<Block> OBSIDIAN_TILE_STAIRS = stairs("obsidian_tile_stairs", OBSIDIAN_TILE);
    public static final RegistryObject<Block> OBSIDIAN_TILE_SLAB = slab("obsidian_tile_slab");
    public static final RegistryObject<Block> OBSIDIAN_ROD_TILES = solid("obsidian_rod_tiles");
    public static final RegistryObject<Block> OBSIDIAN_GLASS = glass("obsidian_glass");
    public static final RegistryObject<Block> OBSIDIAN_GLASS_PANE = pane("obsidian_glass_pane");

    public static final RegistryObject<Block> BLUE_OBSIDIAN = solid("blue_obsidian");
    public static final RegistryObject<Block> BLUE_CRYING_OBSIDIAN = solid("blue_crying_obsidian");
    public static final RegistryObject<Block> BLUE_WEEPING_OBSIDIAN = solid("blue_weeping_obsidian");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS = solid("blue_obsidian_bricks");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS_STAIRS = stairs("blue_obsidian_bricks_stairs", BLUE_OBSIDIAN_BRICKS);
    public static final RegistryObject<Block> BLUE_OBSIDIAN_BRICKS_SLAB = slab("blue_obsidian_bricks_slab");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE = solid("blue_obsidian_tile");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE_SMALL = solid("blue_obsidian_tile_small");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE_STAIRS = stairs("blue_obsidian_tile_stairs", BLUE_OBSIDIAN_TILE);
    public static final RegistryObject<Block> BLUE_OBSIDIAN_TILE_SLAB = slab("blue_obsidian_tile_slab");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_ROD_TILES = solid("blue_obsidian_rod_tiles");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_GLASS = glass("blue_obsidian_glass");
    public static final RegistryObject<Block> BLUE_OBSIDIAN_GLASS_PANE = pane("blue_obsidian_glass_pane");

    private BlackForgeImportedBlocks() {
    }

    private static RegistryObject<Block> solid(String name) {
        return register(name, () -> new Block(OBSIDIAN));
    }

    private static RegistryObject<Block> slab(String name) {
        return register(name, () -> new SlabBlock(OBSIDIAN));
    }

    private static RegistryObject<Block> stairs(String name, RegistryObject<Block> base) {
        return register(name, () -> new StairBlock(base.get().defaultBlockState(), OBSIDIAN));
    }

    private static RegistryObject<Block> glass(String name) {
        return register(name, () -> new GlassBlock(OBSIDIAN_GLASS_PROPERTIES));
    }

    private static RegistryObject<Block> pane(String name) {
        return register(name, () -> new IronBarsBlock(OBSIDIAN_GLASS_PROPERTIES));
    }

    private static RegistryObject<Block> wall(String name, Block source) {
        return register(name, () -> new WallBlock(BlockBehaviour.Properties.copy(source)));
    }

    private static RegistryObject<Block> stalactite(String name, Block source) {
        return register(name, () -> new ImportedStalactiteBlock(source));
    }

    private static RegistryObject<Block> register(String name, Supplier<? extends Block> factory) {
        RegistryObject<Block> block = BLOCKS.register(name, factory);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
