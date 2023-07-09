package net.panda.mekanismfabric;

import net.fabricmc.api.ModInitializer;
import net.panda.mekanismfabric.registries.MekanismBlocks;
import net.panda.mekanismfabric.registries.MekanismItemGroups;
import net.panda.mekanismfabric.registries.MekanismItems;
import net.panda.mekanismfabric.registries.MekanismWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mekanism implements ModInitializer {
	public static final String MODID = "mekanism-fabric";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading {}", MODID);
		MekanismItems.registerItems();
		MekanismBlocks.registerBlocks();
		MekanismItemGroups.registerItemGroups();
		MekanismWorldGen.registerWorldGen();
	}
}