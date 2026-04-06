package net.tropicraft.core.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.tropicraft.core.common.enums.BlockHardnessValues;

// Use these... somehow

import extendedrenderer.ExtendedRenderer;
import extendedrenderer.particle.ParticleRegistry;
import extendedrenderer.particle.behavior.ParticleBehaviors;
import extendedrenderer.particle.entity.EntityRotFX;

import javax.annotation.Nullable;
import java.util.Random;

import static net.tropicraft.core.registry.BlockRegistry.*;

public class BlockFirePit extends BlockTropicraft {

    protected static final AxisAlignedBB FIRE_PIT_AABB = new AxisAlignedBB(0.05D, 0D, 0.05D, 0.95D, 0.1D, 0.95D);

    public BlockFirePit() {
        super(Material.ROCK);
        this.setHardness(2.0F);
        this.setResistance(BlockHardnessValues.CHUNK.resistance);
        this.lightValue = (int)(15.0F);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return FIRE_PIT_AABB;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return FIRE_PIT_AABB;
    }

    @Override
    public boolean isTopSolid(IBlockState state) {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    /*
    // Damage any entity sitting on top of this block.
    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        entity.attackEntityFrom(DamageSource.HOT_FLOOR, 0.5F);
    }
    */

    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
        double d = (float) pos.getX() + 0.5F;
        double d1 = (float) pos.getY() + 0.3F;
        double d2 = (float) pos.getZ() + 0.5F;

        world.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);

        // TODO if CoroUtil is present use it's smoke particles instead, also probably make this into a tile entity for that.

        //if (Loader.isModLoaded("coroutil")) {

        //} else {
            world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d, d1, d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle(EnumParticleTypes.FLAME, d, d1, d2, 0.0D, 0.0D, 0.0D);
        //}
    }

    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
            return super.getLightValue(state, world, pos);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(firePit);
    }
}
