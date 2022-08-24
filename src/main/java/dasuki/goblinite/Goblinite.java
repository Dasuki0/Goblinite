package dasuki.goblinite;

import dasuki.goblinite.block.ModBlocks;
import dasuki.goblinite.effects.ModEffects;
import dasuki.goblinite.enchantment.ModEnchantments;
import dasuki.goblinite.item.ModItems;
import dasuki.goblinite.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Goblinite implements ModInitializer {
	public static final String MOD_ID = "goblinite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		ModEffects.registerModEffects();
		ModEnchantments.registerModEnchantments();

		GeckoLib.initialize();
		
	}
}
