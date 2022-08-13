package dasuki.goblinite;

import dasuki.goblinite.block.ModBlocks;
import dasuki.goblinite.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Goblinite implements ModInitializer {
	public static final String MOD_ID = "goblinite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
