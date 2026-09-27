package net.mcreator.evenbetternether.init;

import java.util.function.Supplier;
import net.mcreator.evenbetternether.EvenbetternetherMod;
import net.mcreator.evenbetternether.block.ImportedStalactiteBlock;
import net.mcreator.evenbetternether.block.ImportedNetherPlantBlock;
import net.mcreator.evenbetternether.block.ImportedHangingVineBlock;
import net.mcreator.evenbetternether.block.ImportedWillowSaplingBlock;
import net.mcreator.evenbetternether.block.ImportedHookMushroomBlock;
import net.mcreator.evenbetternether.block.ImportedMossCoverBlock;
import net.mcreator.evenbetternether.block.ImportedWallPlantBlock;
import net.mcreator.evenbetternether.block.ImportedNetherCactusBlock;
import net.mcreator.evenbetternether.block.ImportedGiantMoldBlock;
import net.mcreator.evenbetternether.block.ImportedGiantMoldSaplingBlock;
import net.mcreator.evenbetternether.block.ImportedLumabusVineBlock;
import net.mcreator.evenbetternether.block.ImportedLumabusSeedBlock;
import net.mcreator.evenbetternether.block.ImportedWillowLeavesBlock;
import net.mcreator.evenbetternether.block.ImportedWillowBranchBlock;
import net.mcreator.evenbetternether.block.ImportedAgaveBlock;
import net.mcreator.evenbetternether.block.ImportedStalagnateBlock;
import net.mcreator.evenbetternether.block.ImportedStalagnateSeedBlock;
import net.mcreator.evenbetternether.block.ImportedWartSeedBlock;
import net.mcreator.evenbetternether.block.ImportedStalagnateStemBlock;
import net.mcreator.evenbetternether.block.ImportedBetterFeatherFernBlock;
import net.mcreator.evenbetternether.block.ImportedBoneMushroomBlock;
import net.mcreator.evenbetternether.block.ImportedSepiaBoneGrassBlock;
import net.mcreator.evenbetternether.block.ImportedWillowTorchBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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

    public static final RegistryObject<Block> HOOK_MUSHROOM = register("hook_mushroom", ImportedHookMushroomBlock::new);
    public static final RegistryObject<Block> MOSS_COVER = register("moss_cover", ImportedMossCoverBlock::new);
    public static final RegistryObject<Block> JUNGLE_MOSS = register("jungle_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> SCULK_MOSS = register("sculk_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> WALL_MOSS = register("wall_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> LUMINOUS_MOSS = register("luminous_moss", () -> new ImportedWallPlantBlock(12));
    public static final RegistryObject<Block> ROTTEN_MUTATED_MOSS = register("rotten_mutated_moss", ImportedWallPlantBlock::new);
    public static final RegistryObject<Block> NETHER_CACTUS = register("nether_cactus", ImportedNetherCactusBlock::new);
    public static final RegistryObject<Block> NETHER_GRASS = plant("nether_grass", 0);
    public static final RegistryObject<Block> GLOOMGRASS = plant("gloomgrass", 2);
    public static final RegistryObject<Block> PALE_GLOOMGRASS = plant("pale_gloomgrass", 1);
    public static final RegistryObject<Item> AGAVE_LEAF = ITEMS.register("agave_leaf", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Block> AGAVE = register("agave", () -> new ImportedAgaveBlock().leaf(AGAVE_LEAF));
    public static final RegistryObject<Block> BETTER_NETHER_FEATHER_FERN = register("better_nether_feather_fern", ImportedBetterFeatherFernBlock::new);
    public static final RegistryObject<Block> BONE_MUSHROOM = register("bone_mushroom", () -> new ImportedBoneMushroomBlock(EvenbetternetherModBlocks.SMOOTH_BONE_BLOCK));
    public static final RegistryObject<Block> SEPIA_BONE_GRASS = register("sepia_bone_grass", ImportedSepiaBoneGrassBlock::new);
    public static final RegistryObject<Block> NETHER_MUSHROOM_STEM = register("nether_mushroom_stem", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));
    public static final RegistryObject<Block> GIANT_MOLD = registerNoItem("giant_mold", () -> new ImportedGiantMoldBlock(NETHER_MUSHROOM_STEM));
    public static final RegistryObject<Block> GIANT_MOLD_SAPLING = register("giant_mold_sapling", () -> new ImportedGiantMoldSaplingBlock(GIANT_MOLD));
    public static final RegistryObject<Block> STALAGNATE_STEM = register("stalagnate_stem", ImportedStalagnateStemBlock::new);
    public static final RegistryObject<Block> STALAGNATE_TRUNK = registerNoItem("stalagnate_trunk", () -> new ImportedStalagnateBlock(STALAGNATE_STEM));
    public static final RegistryObject<Block> STALAGNATE_SEED = register("stalagnate_seed", () -> new ImportedStalagnateSeedBlock(STALAGNATE_TRUNK));
    public static final RegistryObject<Block> WART_SEED = register("wart_seed", ImportedWartSeedBlock::new);
    public static final RegistryObject<Block> BLACK_VINE = vine("black_vine", 0);
    public static final RegistryObject<Block> BLOOMING_VINE = vine("blooming_vine", 4);
    public static final RegistryObject<Block> GOLDEN_VINE = vine("golden_vine", 15);
    public static final RegistryObject<Block> GLOOMSCULK_VINE = vine("gloomsculk_vine", 3);
    public static final RegistryObject<Block> LUMABUS_VINE = registerNoItem("lumabus_vine", ImportedLumabusVineBlock::new);
    public static final RegistryObject<Block> GOLDEN_LUMABUS_VINE = registerNoItem("golden_lumabus_vine", ImportedLumabusVineBlock::new);
    public static final RegistryObject<Block> LUMABUS_SEED = register("lumabus_seed", () -> new ImportedLumabusSeedBlock(LUMABUS_VINE, 10, 21));
    public static final RegistryObject<Block> GOLDEN_LUMABUS_SEED = register("golden_lumabus_seed", () -> new ImportedLumabusSeedBlock(GOLDEN_LUMABUS_VINE, 12, 23));

    public static final RegistryObject<Block> WILLOW_LOG = register("willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> WILLOW_BARK = register("willow_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE)));
    public static final RegistryObject<Block> WILLOW_STRIPPED_LOG = register("willow_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_STEM)));
    public static final RegistryObject<Block> WILLOW_STRIPPED_BARK = register("willow_stripped_bark", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_HYPHAE)));
    public static final RegistryObject<Block> WILLOW_PLANKS = register("willow_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WILLOW_DOOR = register("willow_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_DOOR).noOcclusion(), BlockSetType.CRIMSON));
    public static final RegistryObject<Block> WILLOW_FENCE = register("willow_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE)));
    public static final RegistryObject<Block> WILLOW_LEAVES = register("willow_leaves", ImportedWillowLeavesBlock::new);
    public static final RegistryObject<Block> WILLOW_BRANCH = register("willow_branch", ImportedWillowBranchBlock::new);
    public static final RegistryObject<Block> WILLOW_TORCH = register("willow_torch", ImportedWillowTorchBlock::new);
    public static final RegistryObject<Block> WILLOW_SAPLING = register("willow_sapling", () -> new ImportedWillowSaplingBlock(WILLOW_LOG, WILLOW_LEAVES, WILLOW_BRANCH));

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

    private static RegistryObject<Block> plant(String name, int light) {
        return register(name, () -> new ImportedNetherPlantBlock(light));
    }

    private static RegistryObject<Block> vine(String name, int light) {
        return register(name, () -> new ImportedHangingVineBlock(light));
    }

    private static RegistryObject<Block> register(String name, Supplier<? extends Block> factory) {
        RegistryObject<Block> block = BLOCKS.register(name, factory);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<Block> registerNoItem(String name, Supplier<? extends Block> factory) {
        return BLOCKS.register(name, factory);
    }
}
