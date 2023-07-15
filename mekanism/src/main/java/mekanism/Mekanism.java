package mekanism;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import mekanism.registries.MekanismBlocks;
import mekanism.registries.MekanismItemGroups;
import mekanism.registries.MekanismItems;
import mekanism.registries.MekanismWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mekanism implements ModInitializer {
	public static final String MODID = "mekanism";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Loading {}", MODID);
		MekanismItems.registerItems();
		MekanismBlocks.registerBlocks();
		MekanismItemGroups.registerItemGroups();
		MekanismWorldGen.registerWorldGen();
	}
}