package dasuki.goblinite.enchantment;

import dasuki.goblinite.effects.ModEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class LifestealEnchantment extends Enchantment {
    public LifestealEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (EnchantmentHelper.getLevel(ModEnchantments.LIFESTEAL, user.getMainHandStack()) == 0 || target.distanceTo(user) >= 6)
            return;
        if (user.getStatusEffect(ModEffects.LIFESTEAL_COOLDOWN_EFFECT) == null) {
            List<LivingEntity> list = target.world.getNonSpectatingEntities(LivingEntity.class, target.getBoundingBox()
                    .expand(1 + level, 0.25D, 1 + level));
            int counter = 0;

            for (LivingEntity e : list) {
                if (!e.equals(user)) {
                    counter++;
                    e.damage(DamageSource.MAGIC, 1.0f);

                    if (target.world instanceof ServerWorld) {
                        double xdif = e.getX() - user.getX();
                        double ydif = e.getBodyY(0.5D) - user.getBodyY(0.5D);
                        double zdif = e.getZ() - user.getZ();

                        int particleNumConstant = 20; //number of particles
                        double x = 0;
                        double y = 0;
                        double z = 0;
                        while(Math.abs(x) < Math.abs(xdif))
                        {
                            ((ServerWorld) target.world).spawnParticles(ParticleTypes.COMPOSTER, user.getX() + x,
                                    user.getBodyY(0.5D) + y, user.getZ() + z, 0, 1, 0.0D, 1, 0.0D);
                            x = x + xdif/particleNumConstant;
                            y = y + ydif/particleNumConstant;
                            z = z + zdif/particleNumConstant;
                        }
                    }
                }
            }
            user.heal(counter + (level) + 1f);
            user.addStatusEffect(new StatusEffectInstance(ModEffects.LIFESTEAL_COOLDOWN_EFFECT, 100 - (level * 20)));
            if(user.world instanceof ServerWorld)
                ((ServerWorld) user.world).spawnParticles(ParticleTypes.HEART, user.getX(), user.getBodyY(0.5D), user.getZ(), 3, 0.4, 0.5, 0.4, 0.0D);
        }
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}