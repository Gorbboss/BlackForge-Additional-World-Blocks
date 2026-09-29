package net.mcreator.evenbetternether.world.features;
import com.mojang.serialization.Codec;
import net.mcreator.evenbetternether.init.BlackForgeImportedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
/** BetterEnd-style Umbralith arch for the Umbra Valley and End highlands. */
public class ImportedUmbralithArchFeature extends Feature<NoneFeatureConfiguration> {
 public ImportedUmbralithArchFeature(){super(NoneFeatureConfiguration.CODEC);}
 @Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> c){WorldGenLevel w=c.level();RandomSource r=c.random();BlockPos o=c.origin();int span=12+r.nextInt(17),height=8+r.nextInt(13),thick=2+r.nextInt(2);boolean xAxis=r.nextBoolean();boolean placed=false;for(int i=-span/2;i<=span/2;i++){double n=Math.abs(i)/(span/2.0);int y=(int)Math.round(height*(1.0-n*n));for(int t=-thick;t<=thick;t++)for(int q=0;q<thick;q++){BlockPos p=xAxis?o.offset(i,y+t,q):o.offset(q,y+t,i);if(w.getBlockState(p).canBeReplaced()){w.setBlock(p,BlackForgeImportedBlocks.UMBRALITH.get().defaultBlockState(),2);placed=true;}}}return placed;}
}
