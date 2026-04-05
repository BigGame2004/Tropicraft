package net.tropicraft.core.common.compatibility;

import exnihilocreatio.texturing.Color;
import net.minecraft.item.ItemStack;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.tropicraft.core.registry.*;

import static net.minecraft.init.Blocks.*;
import static net.tropicraft.core.registry.BlockRegistry.*;
import static net.tropicraft.core.registry.ItemRegistry.*;
import static exnihilocreatio.registries.manager.ExNihiloRegistryManager.*;

public class ExNihiloCreatio {

    public static void preInit() {}

    public static void init() {

        //BlockInfo Cobblestone = new BlockInfo(COBBLESTONE);
        BlockInfo Dirt = new BlockInfo(DIRT);
        //BlockInfo Mycelium = new BlockInfo(MYCELIUM);
        //BlockInfo Obsidian = new BlockInfo(OBSIDIAN);

        ItemInfo Bamboo = new ItemInfo(new ItemStack(bambooShoot));
        ItemInfo BrainCoral = new ItemInfo(new ItemStack(coral, 1, 2));
        ItemInfo Coconut = new ItemInfo(new ItemStack(coconut));
        ItemInfo CoconutChunks = new ItemInfo(new ItemStack(coconutChunk));
        ItemInfo CoffeeBerry = new ItemInfo(new ItemStack(coffeeBeans, 1, 2));
        ItemInfo FireCoral = new ItemInfo(new ItemStack(coral, 1, 3));
        ItemInfo GreenCoral = new ItemInfo(new ItemStack(coral, 1, 5));
        ItemInfo HotPinkCoral = new ItemInfo(new ItemStack(coral, 1, 6));
        ItemInfo Iris = new ItemInfo(new ItemStack(iris));
        ItemInfo Nori = new ItemInfo(new ItemStack(rawNori));
        ItemInfo Pineapple = new ItemInfo(new ItemStack(pineapple));
        ItemInfo PineappleCubes = new ItemInfo(new ItemStack(pineappleCubes));
        ItemInfo PinkCoral = new ItemInfo(new ItemStack(coral, 1, 0));
        ItemInfo RoastedCoffeeSeed = new ItemInfo(new ItemStack(coffeeBeans, 1, 1));
        ItemInfo SpiralCoral = new ItemInfo(new ItemStack(coral, 1, 4));
        ItemInfo TealyCoral = new ItemInfo(new ItemStack(coral, 1, 1));
        ItemInfo ToastedNori = new ItemInfo(new ItemStack(toastedNori));
        ItemInfo Foliage = new ItemInfo(new ItemStack(flowers, 1, 13));

        //ItemInfo  = new ItemInfo(new ItemStack());

        // Compost

        COMPOST_REGISTRY.register(Bamboo, 0.2f, Dirt, new Color("98AE67"));
        COMPOST_REGISTRY.register(BrainCoral, 0.10f, Dirt, new Color("CED04E"));
        COMPOST_REGISTRY.register(Coconut, 0.10f, Dirt, new Color("432E1D"));
        COMPOST_REGISTRY.register(CoconutChunks, 0.05f, Dirt, new Color("F8F1E7"));
        COMPOST_REGISTRY.register(CoffeeBerry, 0.10f, Dirt, new Color("F2424D"));
        COMPOST_REGISTRY.register(FireCoral, 0.10f, Dirt, new Color("DB4B00"));
        COMPOST_REGISTRY.register(GreenCoral, 0.10f, Dirt, new Color("03BA91"));
        COMPOST_REGISTRY.register(HotPinkCoral, 0.10f, Dirt, new Color("FF21D2"));
        COMPOST_REGISTRY.register(Iris, 0.10f, Dirt, new Color("3C2088"));
        COMPOST_REGISTRY.register(Nori, 0.16f, Dirt, new Color("191E04"));
        COMPOST_REGISTRY.register(Pineapple, 0.10f, Dirt, new Color("85A600"));
        COMPOST_REGISTRY.register(PineappleCubes, 0.05f, Dirt, new Color("E3BC1E"));
        COMPOST_REGISTRY.register(PinkCoral, 0.10f, Dirt, new Color("DE5A9B"));
        COMPOST_REGISTRY.register(RoastedCoffeeSeed, 0.08f, Dirt, new Color("704327"));
        COMPOST_REGISTRY.register(SpiralCoral, 0.10f, Dirt, new Color("DB8420"));
        COMPOST_REGISTRY.register(TealyCoral, 0.10f, Dirt, new Color("A75D39"));
        COMPOST_REGISTRY.register(ToastedNori, 0.20f, Dirt, new Color("404822"));
        COMPOST_REGISTRY.register(Foliage, 0.10f, Dirt, new Color("97CD00"));

        //COMPOST_REGISTRY.register(, 0.f, Dirt, new Color(""));

        // Fluid on top

        //FluidStack Lava = new FluidStack(FluidRegistry.LAVA, 1000);
        //FluidStack TropicsWater = new FluidStack(TCFluidRegistry.tropicsWater, 1000);

        //FLUID_ON_TOP_REGISTRY.register(Lava.getFluid(), TropicsWater.getFluid(), Obsidian);
        //FLUID_ON_TOP_REGISTRY.register(TropicsWater.getFluid(), Lava.getFluid(), Cobblestone);

        // Fluid Transform

        //FLUID_TRANSFORM_REGISTRY.register("tropicsWater", "witchwater", 12000, arrayOf(Mycelium), arrayOf(BlockInfo(Blocks.BROWN_MUSHROOM.defaultState), BlockInfo(Blocks.RED_MUSHROOM.defaultState)));
    }

    public static void postInit() {}
}