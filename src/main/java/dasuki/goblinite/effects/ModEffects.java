package dasuki.goblinite.effects;

//public static final StatusEffect LIFESTEAL_COOLDOWN_EFFECT = new LifestealCooldownEffect();
import dasuki.goblinite.Goblinite;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect LIFESTEAL_COOLDOWN_EFFECT = register("lifesteal_cooldown",
            new LifestealCooldownEffect(StatusEffectCategory.HARMFUL));

    private static StatusEffect register(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Goblinite.MOD_ID, name), effect);
    }

    public static void registerModEffects() {
        System.out.println("Registering Effects for " + Goblinite.MOD_ID);
    }
}
