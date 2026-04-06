package net.tropicraft.core.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.tropicraft.Info;

public class LootRegistry extends TropicraftRegistry {

    // Chests

    public static ResourceLocation buriedTreasure;
    public static ResourceLocation sunkenShip;
    public static ResourceLocation tropicsPortal;
    public static ResourceLocation homeTree;

    // Sifter

    public static ResourceLocation sifterRegular;
    public static ResourceLocation sifterHeated;
    public static ResourceLocation sifterRare;

    // Mobs

    public static ResourceLocation eih;
    public static ResourceLocation iguana;
    public static ResourceLocation tropiSpider;
    public static ResourceLocation treeFrogGreen;
    public static ResourceLocation treeFrogRed;
    public static ResourceLocation treeFrogBlue;
    public static ResourceLocation treeFrogYellow;
    public static ResourceLocation tropiSkeleton;
    public static ResourceLocation failgull;
    public static ResourceLocation manOWar;
    public static ResourceLocation seaUrchin;
    public static ResourceLocation seaTurtle;
    public static ResourceLocation starfish;
    public static ResourceLocation dolphin;
    public static ResourceLocation eagleRay;
    public static ResourceLocation marlin;
    public static ResourceLocation piranha;
    public static ResourceLocation sardine;
    public static ResourceLocation shark;
    public static ResourceLocation tropicalFish;

    //public static ResourceLocation ;

    public static void postInit() {

        // Chests

        buriedTreasure = LootTableList.register(new ResourceLocation(Info.MODID, "chests/buried_treasure"));
        sunkenShip = LootTableList.register(new ResourceLocation(Info.MODID, "chests/sunken_ship"));
        tropicsPortal = LootTableList.register(new ResourceLocation(Info.MODID, "chests/tropics_portal"));
        homeTree = LootTableList.register(new ResourceLocation(Info.MODID, "chests/home_tree"));

        // Sifter

        sifterRegular = LootTableList.register(new ResourceLocation(Info.MODID, "sifter/sifter_regular"));
        sifterHeated = LootTableList.register(new ResourceLocation(Info.MODID, "sifter/sifter_heated"));
        sifterRare = LootTableList.register(new ResourceLocation(Info.MODID, "sifter/sifter_rare"));

        // Mobs

        eih = LootTableList.register(new ResourceLocation(Info.MODID, "entities/eih"));
        iguana = LootTableList.register(new ResourceLocation(Info.MODID, "entities/iguana"));
        tropiSpider = LootTableList.register(new ResourceLocation(Info.MODID, "entities/tropi_spider"));
        treeFrogGreen = LootTableList.register(new ResourceLocation(Info.MODID, "entities/tree_frog_green"));
        treeFrogRed = LootTableList.register(new ResourceLocation(Info.MODID, "entities/tree_frog_red"));
        treeFrogBlue = LootTableList.register(new ResourceLocation(Info.MODID, "entities/tree_frog_blue"));
        treeFrogYellow = LootTableList.register(new ResourceLocation(Info.MODID, "entities/tree_frog_yellow"));
        tropiSkeleton = LootTableList.register(new ResourceLocation(Info.MODID, "entities/tropi_skeleton"));
        failgull = LootTableList.register(new ResourceLocation(Info.MODID, "entities/failgull"));
        manOWar = LootTableList.register(new ResourceLocation(Info.MODID, "entities/man_o_war"));
        seaUrchin = LootTableList.register(new ResourceLocation(Info.MODID, "entities/sea_urchin"));
        seaTurtle = LootTableList.register(new ResourceLocation(Info.MODID, "entities/sea_turtle"));
        starfish = LootTableList.register(new ResourceLocation(Info.MODID, "entities/starfish"));
        dolphin = LootTableList.register(new ResourceLocation(Info.MODID, "entities/dolphin"));
        eagleRay = LootTableList.register(new ResourceLocation(Info.MODID, "entities/eagle_ray"));
        marlin = LootTableList.register(new ResourceLocation(Info.MODID, "entities/marlin"));
        piranha = LootTableList.register(new ResourceLocation(Info.MODID, "entities/piranha"));
        sardine = LootTableList.register(new ResourceLocation(Info.MODID, "entities/sardine"));
        shark = LootTableList.register(new ResourceLocation(Info.MODID, "entities/shark"));
        tropicalFish = LootTableList.register(new ResourceLocation(Info.MODID, "entities/tropical_fish"));

        // = LootTableList.register(new ResourceLocation(Info.MODID, "entities/"));
    }
}
