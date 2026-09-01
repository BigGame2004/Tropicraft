package net.tropicraft.core.registry;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class BrewingRegistry {

    public static void addRecipes() {
        ItemStack awkwardPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.AWKWARD);

        BrewingRecipeRegistry.addRecipe(awkwardPotion, new ItemStack(ItemRegistry.poisonFrogSkin, 1), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.POISON));
    }
}
