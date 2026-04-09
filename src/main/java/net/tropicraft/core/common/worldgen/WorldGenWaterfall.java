package net.tropicraft.core.common.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tropicraft.core.registry.BlockRegistry;

import java.util.Random;

public class WorldGenWaterfall extends TCDirectionalGen {

    private static final Block WATER_BLOCK = BlockRegistry.tropicsWater;

    public WorldGenWaterfall(World world, Random random) {
        super(world, random);
    }

    @Override
    public boolean generate(BlockPos pos) {

        int i = pos.getX(), j = pos.getY(), k = pos.getZ();

        if(TCGenUtils.getBlock(worldObj, i, j, k) == Blocks.STONE) {
            int size = rand.nextInt(4) + 3;
            if(TCGenUtils.getBlock(worldObj, i + 1, j, k) == Blocks.AIR) {
                int dir = TCGenUtils.getBlock(worldObj, i, j, k + 1) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    TCGenUtils.setBlock(worldObj, i, j, k + x, WATER_BLOCK);
                    if(TCGenUtils.getBlock(worldObj, i + 1, j, k + x + dir) != Blocks.AIR || TCGenUtils.getBlock(worldObj, i + x + dir, j, k) != Blocks.STONE) {
                        System.out.println("Waterfall generated at "+i+" "+j+" "+k);
                        break;
                    }
                }
            }

            if(TCGenUtils.getBlock(worldObj, i - 1, j, k) == Blocks.AIR) {
                int dir = TCGenUtils.getBlock(worldObj, i, j, k + 1) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    TCGenUtils.setBlock(worldObj, i, j, k + x, WATER_BLOCK);
                    if(TCGenUtils.getBlock(worldObj, i - 1, j, k + x + dir) != Blocks.AIR || TCGenUtils.getBlock(worldObj, i + x + dir, j, k) != Blocks.STONE) {
                        System.out.println("Waterfall generated at "+i+" "+j+" "+k);
                        break;
                    }
                }
            }

            if(TCGenUtils.getBlock(worldObj, i, j, k + 1) == Blocks.AIR) {
                int dir = TCGenUtils.getBlock(worldObj, i + 1, j, k) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    TCGenUtils.setBlock(worldObj, i + x, j, k, WATER_BLOCK);
                    if(TCGenUtils.getBlock(worldObj, i + x + dir, j, k + 1) != Blocks.AIR || TCGenUtils.getBlock(worldObj, i + x + dir, j, k) != Blocks.STONE) {
                        System.out.println("Waterfall generated at "+i+" "+j+" "+k);
                        break;
                    }
                }
            }

            if(TCGenUtils.getBlock(worldObj, i, j, k - 1) == Blocks.AIR) {
                int dir = TCGenUtils.getBlock(worldObj, i + 1, j, k) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    TCGenUtils.setBlock(worldObj, i + x, j, k, WATER_BLOCK);
                    if(TCGenUtils.getBlock(worldObj, i + x + dir, j, k + 1) != Blocks.AIR || TCGenUtils.getBlock(worldObj, i + x + dir, j, k) != Blocks.STONE) {
                        System.out.println("Waterfall generated at "+i+" "+j+" "+k);
                        break;
                    }
                }
            }
        }
        return true;
    }
}