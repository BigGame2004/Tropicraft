package net.tropicraft.core.common.compatibility;

import cofh.core.util.helpers.ItemHelper;
import cofh.thermalexpansion.util.managers.device.CoolantManager;
import cofh.thermalexpansion.util.managers.device.TapperManager;
import cofh.thermalexpansion.util.managers.dynamo.NumismaticManager;
import cofh.thermalexpansion.util.managers.machine.*;
import cofh.thermalfoundation.item.ItemMaterial;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.tropicraft.core.registry.TCFluidRegistry;

import java.lang.reflect.Method;

import static net.minecraft.init.Items.*;
import static net.tropicraft.core.registry.BlockRegistry.*;
import static net.tropicraft.core.registry.ItemRegistry.*;

public class Thermal {

    public static void preInit() {}

    public static void init() {

        ItemStack Pineapple = new ItemStack(pineapple);
        ItemStack Iris = new ItemStack(iris);
        ItemStack Bamboo = new ItemStack(bambooShoot);
        ItemStack Coconut = new ItemStack(coconut);
        ItemStack Seaweed = new ItemStack(seaweed);

        ItemStack PalmSapling = new ItemStack(saplings,1, 0);
        ItemStack MahoganySapling = new ItemStack(saplings, 1, 1);
        ItemStack GrapefruitSapling= new ItemStack(saplings, 1, 2);
        ItemStack LemonSapling= new ItemStack(saplings, 1, 3);
        ItemStack LimeSapling= new ItemStack(saplings, 1, 4);
        ItemStack OrangeSapling= new ItemStack(saplings, 1, 5);

        ItemStack PalmLog = new ItemStack(logs, 1, 1);
        ItemStack MahoganyLog = new ItemStack(logs, 1, 0);

        ItemStack BambooBundle = new ItemStack(bundles, 1, 1);

        //FluidStack sap = new FluidStack(TFFluids.fluidSap, 50);
        //FluidStack resin = new FluidStack(TFFluids.fluidResin, 50);

        // Phytogenic Insolator

        InsolatorManager.addDefaultRecipe(Pineapple, ItemHelper.cloneStack(Pineapple, 2), ItemStack.EMPTY, 0);
        InsolatorManager.addDefaultRecipe(Iris, ItemHelper.cloneStack(Iris, 2), ItemStack.EMPTY, 0);
        InsolatorManager.addDefaultRecipe(Coconut, ItemHelper.cloneStack(Coconut, 2), ItemStack.EMPTY, 0);
        InsolatorManager.addDefaultRecipe(Bamboo, ItemHelper.cloneStack(Bamboo, 2), ItemStack.EMPTY, 0);
        InsolatorManager.addDefaultRecipe(Seaweed, ItemHelper.cloneStack(Seaweed, 2), ItemStack.EMPTY, 0);

        // Phytogenic Insolator tree augment

        InsolatorManager.addDefaultTreeRecipe(4800, PalmSapling, ItemHelper.cloneStack(PalmLog, 6), PalmSapling, 100);
        InsolatorManager.addDefaultTreeRecipe(4800, MahoganySapling, ItemHelper.cloneStack(MahoganyLog, 6), MahoganySapling, 100);

        InsolatorManager.addDefaultTreeRecipe(4800, GrapefruitSapling, new ItemStack(grapefruit, 4), GrapefruitSapling, 100);
        InsolatorManager.addDefaultTreeRecipe(4800, LemonSapling, new ItemStack(lemon, 4), LemonSapling, 100);
        InsolatorManager.addDefaultTreeRecipe(4800, LimeSapling, new ItemStack(lime, 4), LimeSapling, 100);
        InsolatorManager.addDefaultTreeRecipe(4800, OrangeSapling, new ItemStack(orange, 4), OrangeSapling, 100);

        // Igneous Extruder

        ExtruderManager.addRecipeIgneous(800, new ItemStack(chunk), new FluidStack(FluidRegistry.LAVA, 0), new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME));

        // Igneous Extruder sedimentary

        for (int i = 0; i < 4; i++) {
            ExtruderManager.addRecipeSedimentary(3200, new ItemStack(sands, 1, i), new FluidStack(FluidRegistry.LAVA, 0), new FluidStack(FluidRegistry.WATER, 1500));
        }

        // Sawmill

        SawmillManager.addRecipe(2000, new ItemStack(coffeeBeans, 8, 2), ItemMaterial.dustBiomass, new ItemStack(coffeeBeans, 1, 0), 50);

        // Redstone Furnace Pyrolysis conversion

        FurnaceManager.addRecipePyrolysis(2000, BambooBundle, new ItemStack(Items.COAL, 1, 1), 50);

        // Numismatic Dynamo Gem augemnt

        NumismaticManager.addGemFuel(new ItemStack(azurite), 40000);
        NumismaticManager.addGemFuel(new ItemStack(zircon), 200000);
        NumismaticManager.addGemFuel(new ItemStack(eudialyte), 80000);
        NumismaticManager.addGemFuel(new ItemStack(zirconium), 300000);

        // Coolant

        CoolantManager.addCoolant("tropicraft.water", 300000, 35);

        // Tapper

        //TapperManager.addStandardMapping(PalmLog, sap);
        //TapperManager.addStandardMapping(MahoganyLog, resin);

        //addLeafMapping(logs, 1, leaves, 1);
        //addLeafMapping(logs, 0, leaves, 0);

        // Tapper Fuel
        //TapperManager.addFertilizer(fertilizerCompound, 2);

        // All this because someone decided to make the addFertilizer function private.
        try {
            Method addFertilizer = TapperManager.class.getDeclaredMethod("addFertilizer", ItemStack.class, int.class);
            addFertilizer.setAccessible(true);
            addFertilizer.invoke(null, new ItemStack(fertilizer), 2);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        // Fluid Transposer

        TransposerManager.addFillRecipe(4000, new ItemStack(BUCKET), new ItemStack(tropicsWaterBucket), new FluidStack(TCFluidRegistry.tropicsWater, 1000), false);

        TransposerManager.addExtractRecipe(400, new ItemStack(tropicsWaterBucket), new ItemStack(BUCKET), new FluidStack(TCFluidRegistry.tropicsWater, 1000), 0, false);

    }

    public static void postInit() {}
}