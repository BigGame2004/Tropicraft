package net.tropicraft.core.common.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.tropicraft.core.registry.BlockRegistry;

import java.util.Random;
/*
public class WorldgenWaterFall extends TCDirectionalGen {

    private static final Block WATER_BLOCK = BlockRegistry.tropicsWater;

    public WorldGenWaterfall(World world, Random random) {
        super(world, random);
    }

    @Override
    public boolean generate(int i, int j, int k) {
        if(this.worldObj.getBlock(i, j, k) == Blocks.STONE) {
            int size = rand.nextInt(4) + 3;
            if(this.worldObj.getBlock(i + 1, j, k) == Blocks.AIR) {
                int dir = this.worldObj.getBlock(i, j, k + 1) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i, j, k + x, WATER_BLOCK, 0, blockGenNotifyFlag);
                    if(this.worldObj.getBlock(i + 1, j, k + x + dir) != Blocks.AIR || this.worldObj.getBlock(i + x + dir, j, k) != Blocks.STONE) {
                        break;
                    }
                }
            }

            if(this.worldObj.getBlock(i - 1, j, k) == Blocks.AIR) {
                int dir = this.worldObj.getBlock(i, j, k + 1) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i, j, k + x, WATER_BLOCK, 0, blockGenNotifyFlag);
                    if(this.worldObj.getBlock(i - 1, j, k + x + dir) != Blocks.AIR || this.worldObj.getBlock(i + x + dir, j, k) != Blocks.STONE) {
                        break;
                    }
                }
            }

            if(this.worldObj.getBlock(i, j, k + 1) == Blocks.AIR) {
                int dir = this.worldObj.getBlock(i + 1, j, k) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i + x, j, k, WATER_BLOCK, 0, blockGenNotifyFlag);
                    if(this.worldObj.getBlock(i + x + dir, j, k + 1) != Blocks.AIR || this.worldObj.getBlock(i + x + dir, j, k) != Blocks.STONE) {
                        break;
                    }
                }
            }

            if(this.worldObj.getBlock(i, j, k - 1) == Blocks.AIR) {
                int dir = this.worldObj.getBlock(i + 1, j, k) == Blocks.STONE ? 1 : -1;
                size *= dir;
                for(int x = 0; x < size; x += dir) {
                    this.worldObj.setBlock(i + x, j, k, WATER_BLOCK, 0, blockGenNotifyFlag);
                    if(this.worldObj.getBlock(i + x + dir, j, k + 1) != Blocks.AIR || this.worldObj.getBlock(i + x + dir, j, k) != Blocks.STONE) {
                        break;
                    }
                }
            }
        }

        return true;
    }
}
*/