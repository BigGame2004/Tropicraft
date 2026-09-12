package net.tropicraft.core.common.block;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tropicraft.Tropicraft;

import javax.annotation.Nullable;
import java.util.List;

public class BlockBambooCraftingTable extends BlockWorkbench {

    public BlockBambooCraftingTable() {
        super();
        this.setSoundType(SoundType.PLANT);
        this.setHardness(0.2F);
        this.setResistance(5.0F);
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            playerIn.openGui(Tropicraft.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
    }
    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        //tooltip.add(I18n.format("tropicraft.tooltip.bamboo_crafting_table"));
    }
}