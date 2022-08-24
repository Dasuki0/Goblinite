package dasuki.goblinite.entity;

import dasuki.goblinite.Goblinite;
import dasuki.goblinite.entity.custom.GoblinEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<GoblinEntity> GOBLIN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Goblinite.MOD_ID, "goblin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GoblinEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.75f)).build());
}