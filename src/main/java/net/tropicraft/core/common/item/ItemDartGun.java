package net.tropicraft.core.common.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.tropicraft.core.common.entity.projectile.EntityDart;
import net.tropicraft.core.common.sound.TropicraftSounds;
import net.tropicraft.core.registry.ItemRegistry;

public class ItemDartGun extends ItemTropicraft {
    public ItemDartGun() {
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(110);
        this.addPropertyOverride(new ResourceLocation("pull"), (itemStack, world, living) -> {
            if (living != null) {
                ItemStack gun = living.getActiveItemStack();
                if (living instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) living;
                    if (!gun.isEmpty() && gun.getItem() == ItemRegistry.dartGun) {
                        int i = itemStack.getMaxItemUseDuration() - player.getItemInUseCount();
                        if (i > 12) {
                            return 0.9F;
                        }
                        if (i > 0) {
                            return 0.65F;
                        }
                    }
                }
            }
            return 0.0F;
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), (itemStack, world, living) -> living != null && living.isHandActive() && living.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.BOW;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityLivingBase living, int timeLeft) {
        if (!(living instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) living;
        boolean creative = player.capabilities.isCreativeMode;
        ItemStack dartStack = findDart(player);
        int chargeTicks = this.getMaxItemUseDuration(itemStack) - timeLeft;
        chargeTicks = ForgeEventFactory.onArrowLoose(itemStack, world, player, chargeTicks, !dartStack.isEmpty() || creative);
        if (chargeTicks < 0) return;
        float velocity = ItemBow.getArrowVelocity(chargeTicks);
        if (velocity < 0.1F) return;
        if (dartStack.isEmpty()) {
            dartStack = new ItemStack(ItemRegistry.dart);
        }
        if (!world.isRemote) {
            EntityDart dart = new EntityDart(world, player, velocity * 3.0F);
            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, itemStack) > 0) {
                dart.setFire(100);
            }
            world.spawnEntity(dart);
        }
        world.playSound(null, player.posX, player.posY, player.posZ, TropicraftSounds.DARTBLOW, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);
        itemStack.damageItem(1, player);
        if (!creative && !player.capabilities.isCreativeMode) {
            dartStack.shrink(1);
            if (dartStack.isEmpty()) {
                player.inventory.deleteStack(dartStack);
            }
        }
        player.addStat(StatList.getObjectUseStats(this));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        boolean hasDart = !findDart(player).isEmpty();
        if (!player.capabilities.isCreativeMode && !hasDart) {
            return new ActionResult<>(EnumActionResult.FAIL, stack);
        }
        player.setActiveHand(hand);
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    private ItemStack findDart(EntityPlayer player) {
        if (isDart(player.getHeldItem(EnumHand.OFF_HAND))) return player.getHeldItem(EnumHand.OFF_HAND);
        if (isDart(player.getHeldItem(EnumHand.MAIN_HAND))) return player.getHeldItem(EnumHand.MAIN_HAND);
        for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
            ItemStack stack = player.inventory.getStackInSlot(i);
            if (isDart(stack)) return stack;
        }
        return ItemStack.EMPTY;
    }

    private boolean isDart(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() == ItemRegistry.dart;
    }
}
