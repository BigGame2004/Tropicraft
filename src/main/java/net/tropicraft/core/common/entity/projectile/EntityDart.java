package net.tropicraft.core.common.entity.projectile;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tropicraft.core.registry.ItemRegistry;

public class EntityDart extends EntityArrow implements IProjectile, IEntityAdditionalSpawnData {
    private static final DataParameter<Integer> DART_TYPE = EntityDataManager.createKey(EntityDart.class, DataSerializers.VARINT);

    // TODO somehow make this entity use the DARTHIT sound event

    public EntityDart(World world) {
        super(world);
        this.setSize(0.5F, 0.5F);
    }

    public EntityDart(World world, EntityLivingBase shooter, float velocity) {
        super(world, shooter);
        this.setSize(0.5F, 0.5F);
        this.setDamage(3.0D);
        this.shoot(shooter, shooter.rotationPitch, shooter.rotationYaw, 0.0F, velocity, 1.0F);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(DART_TYPE, 0);
    }

    public DartType getDartType() {
        return DartType.values()[this.dataManager.get(DART_TYPE)];
    }

    public void setDartType(DartType type) {
        this.dataManager.set(DART_TYPE, type.ordinal());
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("DartType", this.getDartType().ordinal());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setDartType(DartType.values()[compound.getInteger("DartType")]);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(ItemRegistry.dart);
    }

    @Override
    public void writeSpawnData(ByteBuf buffer) {
        buffer.writeInt(this.shootingEntity != null ? this.shootingEntity.getEntityId() : -1);
    }

    @Override
    public void readSpawnData(ByteBuf buffer) {
        Entity e = this.world.getEntityByID(buffer.readInt());
        if (e instanceof EntityLivingBase) this.shootingEntity = e;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender() {
        return 15728880;
    }

    public enum DartType {
        DART,
        PARALYZE,
        POISON,
        MOVE_SLOWDOWN,
        HARM,
        CONFUSION,
        HUNGER,
        WEAKNESS
    }
}
