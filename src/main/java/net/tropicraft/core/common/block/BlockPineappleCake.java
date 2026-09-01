package net.tropicraft.core.common.block;

import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;

public class BlockPineappleCake extends BlockCake {

    public BlockPineappleCake()
    {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BITES, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setSoundType(SoundType.CLOTH);
    }
}
