package net.tropicraft.core.registry;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.tropicraft.Names;
import net.tropicraft.core.common.fluid.FluidTropicsPortal;
import net.tropicraft.core.common.fluid.FluidTropicsWater;

@Mod.EventBusSubscriber
public class TCFluidRegistry {

	public static final Fluid tropicsWater = new FluidTropicsWater(TropicraftRegistry.getNamePrefixed(Names.TROPICS_WATER));
	public static final Fluid tropicsPortal = new FluidTropicsPortal(TropicraftRegistry.getNamePrefixed(Names.TROPICS_PORTAL));

	public static void preInit() {
		registerFluid(tropicsWater);
		registerFluid(tropicsPortal);
	}

	/**
	 * Initialization, called after BlockRegistry.init so the blocks are not null when
	 * matched up with the fluids
	 */
	public static void postInit() {
		tropicsWater.setBlock(BlockRegistry.tropicsWater);
		tropicsPortal.setBlock(BlockRegistry.tropicsPortal);

		TCFluidRegistry.registerFluid(tropicsWater);

		/*
		// This creates a forge fluid bucket containing tropical water, now here comes the hard part, using it in code that requires an itemstack ;)
		// Using forge buckets also doesn't trigger the arm swing animation
		FluidRegistry.addBucketForFluid(tropicsWater);
		// Of course doesVaporize only works with forge buckets
		tropicsWater.doesVaporize(new FluidStack(tropicsWater, 1000));
		*/
	}

	private static void registerFluid(Fluid fluid) {
		net.minecraftforge.fluids.FluidRegistry.registerFluid(fluid);
	}
}
