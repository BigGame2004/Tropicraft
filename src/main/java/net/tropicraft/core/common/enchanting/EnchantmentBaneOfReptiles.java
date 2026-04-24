package net.tropicraft.core.common.enchanting;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.tropicraft.core.common.entity.TropiCreatureAttribute;

public class EnchantmentBaneOfReptiles extends Enchantment {

	public final int damageType;

	public EnchantmentBaneOfReptiles(int damageTypeIn) {
		super(Enchantment.Rarity.UNCOMMON, EnumEnchantmentType.ALL, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("bane_of_reptiles");
		this.setName("bane_of_reptiles");
		this.damageType = damageTypeIn;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
		// Originally none of the enchants added by tropicraft were supposed to be obtainable at an enchantment table, although it is unclear this was intentional or not.
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof ItemSword;
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

	@Override
	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof EnchantmentBaneOfReptiles);
	}

	/**
	 * Calculates the additional damage that will be dealt by an item with this enchantment. This alternative to
	 * calcModifierDamage is sensitive to the targets TropiCreatureAttribute.
	 */
	public float calcDamageByCreature(int level, TropiCreatureAttribute creatureType)
	{
		if (this.damageType == 0)
		{
			return 1.0F + (float)Math.max(0, level - 1) * 0.5F;
		}
		else
		{
			return this.damageType == 1 && creatureType == TropiCreatureAttribute.REPTILE ? (float)level * 2.5F : 0.0F;
		}
	}
}