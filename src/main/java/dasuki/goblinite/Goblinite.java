package dasuki.goblinite;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Goblinite implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final Item GOBLINITE_SCYTHE = new Item(new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item GOBLINITE_SHARD = new Item(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("goblinite", "goblinite_scythe"), GOBLINITE_SCYTHE);
		Registry.register(Registry.ITEM, new Identifier("goblinite", "goblinite_shard"), GOBLINITE_SHARD);
	}
}
