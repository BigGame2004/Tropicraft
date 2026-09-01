package net.tropicraft.core.common.enchanting;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class TropiEnchantment extends Enchantment {

    protected TropiEnchantment(Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return true;
        // Originally none of the enchants added by tropicraft were supposed to be obtainable at an enchantment table, although it is unclear if this was intentional or not.
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 17 + (enchantmentLevel) * 10;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return this.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
