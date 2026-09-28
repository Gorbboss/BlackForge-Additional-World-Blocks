package net.mcreator.evenbetternether.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

/** Procedural dependency-free versions of the selected BetterEnd trees. */
public class ImportedEndTreeSaplingBlock extends BushBlock implements BonemealableBlock {
    public enum Kind { HELIX, MOSSY_GLOWSHROOM, DRAGON }
    private final Kind kind;
    public ImportedEndTreeSaplingBlock(Kind kind){super(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).randomTicks().noCollission());this.kind=kind;}
    @Override public boolean isValidBonemealTarget(LevelReader l,BlockPos p,BlockState s,boolean c){return true;}
    @Override public boolean isBonemealSuccess(Level l,RandomSource r,BlockPos p,BlockState s){return true;}
    @Override public void performBonemeal(ServerLevel l,RandomSource r,BlockPos p,BlockState s){grow(l,r,p);}
    @Override public void randomTick(BlockState s,ServerLevel l,BlockPos p,RandomSource r){if(r.nextInt(12)==0)grow(l,r,p);}
    private Block get(String ns,String id){return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ns,id));}
    private void grow(ServerLevel l,RandomSource r,BlockPos p){switch(kind){case HELIX->helix(l,r,p);case MOSSY_GLOWSHROOM->mushroom(l,r,p);case DRAGON->dragon(l,r,p);}}
    private boolean clear(ServerLevel l,BlockPos p,int h,int radius){for(int y=1;y<=h;y++)for(int x=-radius;x<=radius;x++)for(int z=-radius;z<=radius;z++)if(!l.getBlockState(p.offset(x,y,z)).canBeReplaced())return false;return true;}
    private void helix(ServerLevel l,RandomSource r,BlockPos p){int h=9+r.nextInt(5);if(!clear(l,p,h,3))return;Block log=get("deeperdarker","echo_log"),leaves=get("evenbetternether","helix_tree_leaves");for(int y=0;y<h;y++){l.setBlock(p.above(y),log.defaultBlockState(),2);double a=y*1.15;for(int n=1;n<=3;n++)l.setBlock(p.offset((int)Math.round(Math.cos(a)*n),y,(int)Math.round(Math.sin(a)*n)),leaves.defaultBlockState(),2);}crown(l,p.above(h),leaves,2);}
    private void mushroom(ServerLevel l,RandomSource r,BlockPos p){int h=6+r.nextInt(4);if(!clear(l,p,h,4))return;Block log=get("deeperdarker","echo_log"),cap=get("evenbetternether","mossy_glowshroom_cap"),under=get("evenbetternether","mossy_glowshroom_hymenophore");for(int y=0;y<h;y++)l.setBlock(p.above(y),log.defaultBlockState(),2);BlockPos top=p.above(h);for(int x=-3;x<=3;x++)for(int z=-3;z<=3;z++)if(x*x+z*z<=11){l.setBlock(top.offset(x,0,z),cap.defaultBlockState(),2);if(Math.abs(x)+Math.abs(z)>1)l.setBlock(top.offset(x,-1,z),under.defaultBlockState(),2);}}
    private void dragon(ServerLevel l,RandomSource r,BlockPos p){int h=8+r.nextInt(5);if(!clear(l,p,h,3))return;Block log=get("evenbetternether","dragon_tree_log"),leaves=get("evenbetternether","dragon_tree_leaves");for(int y=0;y<h;y++)l.setBlock(p.above(y),log.defaultBlockState(),2);for(int y=h/2;y<h;y+=2){int dx=r.nextBoolean()?1:-1,dz=r.nextBoolean()?1:-1;for(int n=1;n<=3;n++)l.setBlock(p.offset(dx*n,y,dz*n),log.defaultBlockState(),2);crown(l,p.offset(dx*3,y,dz*3),leaves,2);}crown(l,p.above(h),leaves,2);}
    private void crown(ServerLevel l,BlockPos p,Block leaves,int radius){for(int x=-radius;x<=radius;x++)for(int y=-1;y<=1;y++)for(int z=-radius;z<=radius;z++)if(x*x+z*z+y*y<=radius*radius+1&&l.getBlockState(p.offset(x,y,z)).canBeReplaced())l.setBlock(p.offset(x,y,z),leaves.defaultBlockState(),2);}
}
