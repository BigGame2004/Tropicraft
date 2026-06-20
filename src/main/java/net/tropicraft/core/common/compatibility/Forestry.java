package net.tropicraft.core.common.compatibility;

import forestry.api.core.ForestryAPI;
import forestry.api.fuels.FermenterFuel;
import forestry.api.fuels.FuelManager;
import forestry.api.recipes.RecipeManagers;
import forestry.api.storage.ICrateRegistry;
import forestry.api.storage.StorageManager;
import forestry.core.config.Constants;
import forestry.core.fluids.Fluids;
import forestry.core.items.ItemRegistryCore;
import forestry.farming.FarmRegistry;
import forestry.farming.logic.FarmLogicArboreal;
import forestry.farming.logic.ForestryFarmIdentifier;
import forestry.farming.logic.farmables.FarmableAgingCrop;
import forestry.farming.logic.farmables.FarmableSapling;
import forestry.modules.ForestryModuleUids;
import forestry.modules.ModuleHelper;

import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import static forestry.api.core.ForestryAPI.moduleManager;
import static forestry.core.ModuleCore.getItems;

import static net.tropicraft.core.registry.BlockRegistry.*;
import static net.tropicraft.core.registry.ItemRegistry.*;

public class Forestry {

    public static void preInit() {}

    public static void init() {

        // Read if forestry's Factory module is enabled run the code below
        if (ModuleHelper.isEnabled(ForestryModuleUids.FACTORY)) {

            ItemRegistryCore coreItems = getItems();
            //ItemStack mulch = new ItemStack(coreItems.mulch);

            int seedOilMultiplier = ForestryAPI.activeMode.getIntegerSetting("squeezer.liquid.seed");
            //int appleMulchAmount = ForestryAPI.activeMode.getIntegerSetting("squeezer.mulch.apple");
            int appleJuiceAmount = ForestryAPI.activeMode.getIntegerSetting("squeezer.liquid.apple");

            Fluid seedOil = Fluids.SEED_OIL.getFluid();
            Fluid juice = Fluids.JUICE.getFluid();

            // Squeezer recipes

            if (seedOil != null) {
                RecipeManagers.squeezerManager.addRecipe(20, new ItemStack(coffeeBeans, 1, 0), new FluidStack(seedOil, seedOilMultiplier));
            }

            // Add recipes to turn tropicraft's fruits (and pineapple) into fruit juice in a squeezer
            if (juice != null) {
                RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(grapefruit), new FluidStack(juice, 2 * appleJuiceAmount), coreItems.mulch.getItemStack(), 10);
                RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(lemon), new FluidStack(juice, 2 * appleJuiceAmount), coreItems.mulch.getItemStack(), 10);
                RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(lime), new FluidStack(juice, 2 * appleJuiceAmount), coreItems.mulch.getItemStack(), 10);
                RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(orange), new FluidStack(juice, 2 * appleJuiceAmount), coreItems.mulch.getItemStack(), 10);
                RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(pineapple), new FluidStack(juice, 2 * appleJuiceAmount), coreItems.mulch.getItemStack(), 10);
                RecipeManagers.squeezerManager.addRecipe(10, new ItemStack(coconut), new FluidStack(juice, 2 * appleJuiceAmount), coreItems.mulch.getItemStack(), 10);
            }

            // Fermenter fuels

            // Add tropical fertilizer as a valid fuel for the fermenter
            FuelManager.fermenterFuel.put(new ItemStack(fertilizer), new FermenterFuel(new ItemStack(fertilizer),
                    ForestryAPI.activeMode.getIntegerSetting("fermenter.value.fertilizer"),
                    ForestryAPI.activeMode.getIntegerSetting("fermenter.cycles.fertilizer")));

            // Crates
            /*
            ItemStack PalmLog = new ItemStack(logs, 1, 1);
            ItemStack MahoganyLog = new ItemStack(logs, 1, 0);
            ItemStack Bamboo = new ItemStack(bambooShoot);
            ItemStack PalmSapling = new ItemStack(saplings, 1, 0);
            ItemStack MahoganySapling = new ItemStack(saplings, 1, 1);
            ItemStack GrapefruitSapling = new ItemStack(saplings, 1, 2);
            ItemStack LemonSapling = new ItemStack(saplings, 1, 3);
            ItemStack LimeSapling = new ItemStack(saplings, 1, 4);
            ItemStack OrangeSapling = new ItemStack(saplings, 1, 5);
            ItemStack CoffeeBean = new ItemStack(coffeeBeans, 1, 2);

            // Currently, forestry doesn't want to register these crate's item models or recipes, so this is disabled for
            // now.

            if (moduleManager.isModuleEnabled(Constants.MOD_ID, ForestryModuleUids.CRATE)) {

                ICrateRegistry crateRegistry = StorageManager.crateRegistry;

                crateRegistry.registerCrate(MahoganyLog);
                crateRegistry.registerCrate(PalmLog);

                crateRegistry.registerCrate(Bamboo);

                crateRegistry.registerCrate(PalmSapling);
                crateRegistry.registerCrate(MahoganySapling);
                crateRegistry.registerCrate(GrapefruitSapling);
                crateRegistry.registerCrate(LemonSapling);
                crateRegistry.registerCrate(LimeSapling);
                crateRegistry.registerCrate(OrangeSapling);

                crateRegistry.registerCrate(coconut);
                crateRegistry.registerCrate(pineapple);

                crateRegistry.registerCrate(azurite);
                crateRegistry.registerCrate(eudialyte);
                crateRegistry.registerCrate(zircon);
                crateRegistry.registerCrate(zirconium);

                crateRegistry.registerCrate(grapefruit);
                crateRegistry.registerCrate(lemon);
                crateRegistry.registerCrate(lime);
                crateRegistry.registerCrate(orange);

                crateRegistry.registerCrate(CoffeeBean);

                crateRegistry.registerCrate(blackPearl);
                crateRegistry.registerCrate(whitePearl);
                crateRegistry.registerCrate(fertilizer);
                crateRegistry.registerCrate(iguanaLeather);
            }

            // Arboretum

            // Let TC saplings be used in the arboretum
            FarmRegistry.getInstance().registerFarmables(ForestryFarmIdentifier.ARBOREAL, new FarmableSapling(new ItemStack(saplings, 1, 0), new ItemStack[0]));

            // Makes all tropicraft sands useable as arboretum soil
            FarmRegistry.getInstance().registerLogic(ForestryFarmIdentifier.ARBOREAL, FarmLogicArboreal::new).registerSoil(new ItemStack(sands, 1, 0), sands.getDefaultState());
            */
            // Crop Farm

            // Lets tropicraft coffee be farmed using a crop farm
            if (ModuleHelper.isEnabled(ForestryModuleUids.FARMING) && ForestryFarmIdentifier.CROPS != null) {
                FarmRegistry.getInstance().registerFarmables(ForestryFarmIdentifier.CROPS, new FarmableAgingCrop(new ItemStack(coffeeBeans, 1, 0), coffeePlant, (IProperty<Integer>) coffeePlant.getBlockState().getProperty("age"), 6));
            }
        }
    }

    public static void postInit() {}
}