package net.mcreator.evenbetternether.world.features;
import net.mcreator.evenbetternether.init.BlackForgeBetterEndBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
/** Layered Pallidium ground formation, intentionally left unassigned to a biome. */
public class ImportedPallidiumFormationFeature extends Feature<NoneFeatureConfiguration> {
 public ImportedPallidiumFormationFeature(){super(NoneFeatureConfiguration.CODEC);}
 @Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> c){WorldGenLevel w=c.level();RandomSource r=c.random();BlockPos o=c.origin();int radius=5+r.nextInt(8);boolean placed=false;for(int x=-radius;x<=radius;x++)for(int z=-radius;z<=radius;z++){double d=Math.sqrt(x*x+z*z)/radius;if(d>1||r.nextDouble()<d*.25)continue;int y=w.getHeight(Heightmap.Types.WORLD_SURFACE_WG,o.getX()+x,o.getZ()+z)-1;BlockPos p=new BlockPos(o.getX()+x,y,o.getZ()+z);if(!w.getBlockState(p).is(net.minecraft.world.level.block.Blocks.END_STONE))continue;Block b=d<.35?BlackForgeBetterEndBlocks.PALLIDIUM_FULL.get():d<.58?BlackForgeBetterEndBlocks.PALLIDIUM_HEAVY.get():d<.8?BlackForgeBetterEndBlocks.PALLIDIUM_THIN.get():BlackForgeBetterEndBlocks.PALLIDIUM_TINY.get();w.setBlock(p,b.defaultBlockState(),2);placed=true;}return placed;}
}
