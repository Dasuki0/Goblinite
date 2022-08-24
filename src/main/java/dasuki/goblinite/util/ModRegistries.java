package dasuki.goblinite.util;


import dasuki.goblinite.entity.ModEntities;
import dasuki.goblinite.entity.custom.GoblinEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.GOBLIN, GoblinEntity.setAttributes());
    }

}