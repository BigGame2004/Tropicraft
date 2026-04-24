package net.tropicraft.core.registry;

import net.minecraftforge.fml.common.Mod;
import net.tropicraft.Info;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.tropicraft.core.common.enchanting.EnchantmentBaneOfReptiles;

@Mod.EventBusSubscriber(modid = Info.MODID)
public class EnchantmentRegistry {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Enchantment> event) {
        IForgeRegistry<Enchantment> registry = event.getRegistry();

        registry.register(new EnchantmentBaneOfReptiles(1));
        //registry.register(new EnchantmentFruit());
        //registry.register(new EnchantmentFruit());
        //registry.register(new EnchantmentScubaSteve());
        //registry.register(new EnchantmentCombing());
        //registry.register(new EnchantmentMidas());

    }
}