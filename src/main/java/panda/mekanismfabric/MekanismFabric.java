package panda.mekanismfabric;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import panda.mekanismfabric.block.MekanismBlocks;
import panda.mekanismfabric.item.MekanismItems;

public class MekanismFabric implements ModInitializer {

	public static final String MODID = "mekanismfabric";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		MekanismItems.registerMekanismItems();
		MekanismBlocks.registerMekanismBlocks();
	}

	public static Identifier id(String name) {
		return new Identifier(MODID, name);
	}
}