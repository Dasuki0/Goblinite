package dasuki.goblinite.item;

import dasuki.goblinite.Goblinite;
import dasuki.goblinite.entity.ModEntities;
import dasuki.goblinite.item.custom.ModScytheItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item GOBLINITE_SHARD = registerItem("goblinite_shard",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item GOBLINITE_SCYTHE = registerItem("goblinite_scythe",
            new ModScytheItem(ModToolMaterials.GOBLINITE, 4, -2f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item GOBLIN_SPAWN_EGG = registerItem("goblin_spawn_egg",
            new SpawnEggItem(ModEntities.GOBLIN, 0x949494, 0x98b599, new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Goblinite.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Goblinite.LOGGER.info("Registering Mod items for " + Goblinite.MOD_ID);
    }
}
