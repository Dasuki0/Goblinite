package dasuki.goblinite.block;

import dasuki.goblinite.Goblinite;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block GOBLINITE_BLOCK = registerBlock("goblinite_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(6f).requiresTool()), ItemGroup.BUILDING_BLOCKS);


    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Goblinite.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Goblinite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group((group))));
    }

    public static void registerModBlocks() {
        Goblinite.LOGGER.info("Registering ModBlocks for " + Goblinite.MOD_ID);
    }
}
