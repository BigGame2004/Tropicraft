package net.tropicraft.core.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
//import net.tropicraft.core.common.block.tileentity.TileEntityBambooMug;
import net.tropicraft.core.common.block.tileentity.TileEntityFactory;
import net.tropicraft.core.registry.ItemRegistry;

import java.util.Random;
/*
public class BlockBambooMug extends BlockContainer {
    // edited classes: BlockBambooMug, TileEntityBambooMug, TileEntityBambooMugRenderer, ModelBabooMug
    // TropicraftMod, Drink*, ItemDrink, /tropicalmod/bamboomug.png /tropicalmod/tropiitems.png

    protected static final AxisAlignedBB BAMBOO_MUG_AABB = new AxisAlignedBB(0.275D, 0.0D, 0.275D, 0.725D, 1.0D, 0.725);

    public BlockBambooMug() {
        super();
        this.setBlockBounds(0.3f, 0.0f, 0.3f, 0.7f, 0.45f, 0.7f);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return super.canPlaceBlockAt(world, x, y, z) && world.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        TileEntityBambooMug mug = (TileEntityBambooMug) world.getTileEntity(x, y, z);

        if (mug.isEmpty()) {
            return new ItemStack(ItemRegistry.bambooMug);
        }

        return mug.cocktail.copy();
    }

    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
        if (!world.isRemote) {
            TileEntityBambooMug mug = (TileEntityBambooMug) world.getTileEntity(x, y, z);
            if (!mug.isEmpty()) {
                dropBlockAsItem(world, x, y, z, mug.cocktail.copy());
            } else {
                dropBlockAsItem(world, x, y, z, new ItemStack(ItemRegistry.bambooMug));
            }
        }
        super.breakBlock(world, x, y, z, par5, par6);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BAMBOO_MUG_AABB;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return BAMBOO_MUG_AABB;
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return TileEntityFactory.getBambooMugTE();
    }
}
*/