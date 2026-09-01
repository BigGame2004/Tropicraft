package net.tropicraft.core.common.enchanting;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.tropicraft.core.common.config.TropicsConfigs;
import net.tropicraft.core.common.entity.hostile.EntityIguana;

import java.util.ArrayList;
import java.util.List;

public class EnchantmentBaneOfReptiles extends TropiEnchantment {

	public final int damageType;
	//public static List<String> REPTILE_LIST;

	public EnchantmentBaneOfReptiles(int damageTypeIn) {
		super(Rarity.UNCOMMON, EnumEnchantmentType.ALL, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setRegistryName("bane_of_reptiles");
		this.setName("bane_of_reptiles");
		this.damageType = damageTypeIn;
	}

	/**
	 * Calculates the additional damage that will be dealt by an item with this enchantment. This alternative to
	 * calcModifierDamage is sensitive to the targets EnumCreatureAttribute.
	 */
	/*
	@Override
	public float calcDamageByCreature(int level, EnumCreatureAttribute creatureType)
	{
		//if (EntityLivingBase instanceof EntityIguana) {}
		//return (float)level * 2.5F;
		return (float) level * 0F;
    }
    */

	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof ItemSword;
	}

	@Override
	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof EnchantmentBaneOfReptiles);
	}

	// None of this does anything, hooray!
	/*
	public static boolean isReptile(Entity entity)
	{
		if (EntityList.getKey(entity) != null)
		{
			String name = EntityList.getKey(entity).toString();
			boolean contains = REPTILE_LIST.contains(name);
			return contains;
		}
		return true;
	}
	*/

	/**
	 * Called whenever a mob is damaged with an item that has this enchantment on it.
	 */

	public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
	{
		// This used to be for CarryOn's entity whitelist
		/*
		String[] reptiles = TropicsConfigs.reptilesList;
		REPTILE_LIST = new ArrayList<String>();
		for (int i = 0; i < reptiles.length; i++)
		{
			if (reptiles[i].contains("*"))
			{
				String modid = reptiles[i].replace("*", "");
				for (int k = 0; k < ForgeRegistries.ENTITIES.getKeys().size(); k++)
				{
					if (ForgeRegistries.ENTITIES.getKeys().toArray()[k].toString().contains(modid))
					{
						REPTILE_LIST.add(ForgeRegistries.ENTITIES.getKeys().toArray()[k].toString());
					}
				}
			}
			REPTILE_LIST.add(reptiles[i]);
		}
		*/

		if (target instanceof EntityLivingBase)
		{
			EntityLivingBase entitylivingbase = (EntityLivingBase)target;

			//if (entitylivingbase == REPTILE_LIST)
			// Yes I do know this is not the right way to compare if the entity being damaged is part of the reptile list ;)
			if (entitylivingbase instanceof EntityIguana)
			{
				int i = 20 + user.getRNG().nextInt(10 * level);
				int x = user.getRNG().nextInt(level);
				//int x = 2 + level;
				// What the extra damage should look like:
				// lvl 1 = 2.5 damage
				// lvl 2 = 5 damage
				// lvl 3 = 7.5 damage
				// lvl 4 = 10 damage
				// lvl 5 = 12.5 damage
				entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, i, 3));
				entitylivingbase.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, x));
				// In reality:
				// lvl 1 = 2 damage
				// lvl 2 = 12 damage
				// lvl 3 = 12 damage (again ?)
				// lvl 4 = 20+ damage
				// lvl 5 = ? damage
			}
		}
	}
}