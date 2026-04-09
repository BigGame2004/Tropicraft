package net.tropicraft.core.common.block.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
/*
public class TileEntityBambooMug extends TileEntity {
    public ItemStack cocktail;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("Cocktail")) {
            this.cocktail = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("Cocktail"));
        } else {
            this.cocktail = null;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt2) {
        super.writeToNBT(nbt2);
        if (this.cocktail != null) {
            NBTTagCompound nbt = new NBTTagCompound();
            this.cocktail.writeToNBT(nbt);
            nbt2.setTag("Cocktail", nbt);
        }
        return nbt2;
    }

    public void sync() {
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public boolean isEmpty() {
        return this.cocktail == null;
    }

    public void setCocktail(ItemStack cocktail) {
        this.cocktail = cocktail;
        this.sync();
    }

    public int getMetadata() {
        return worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }

    @Override
    public boolean canUpdate() {
        return false;
    }
}*/