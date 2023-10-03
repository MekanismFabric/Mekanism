package panda.mekanismfabric;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import panda.mekanismfabric.block.MekanismBlocks;
import panda.mekanismfabric.item.MekanismItemGroup;
import panda.mekanismfabric.item.MekanismItems;
import panda.mekanismfabric.resource.ResourceType;

import java.util.Map;

public class MekanismFabricDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(MekanismFabricModelGenerator::new);
		fabricDataGenerator.addProvider(MekanismFabricLanguageGenerator::new);
	}

	private static class MekanismFabricModelGenerator extends FabricModelProvider {
		private MekanismFabricModelGenerator(FabricDataGenerator output) {
			super(output);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			for (Block block : MekanismBlocks.ALL_BLOCKS.values()) {
				blockStateModelGenerator.registerSimpleCubeAll(block);
			}
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			for (Item item : MekanismItems.ALL_ITEMS.values()) {
				itemModelGenerator.register(item, Models.GENERATED);
			}
		}
	}

	private static class MekanismFabricLanguageGenerator extends FabricLanguageProvider {
		private MekanismFabricLanguageGenerator(FabricDataGenerator output) {
			super(output);
		}

		private String properFormat(String unsplit) {
			String[] parts = unsplit.split("_");
			StringBuilder strBuilder = new StringBuilder();
			for (String part : parts) {
				strBuilder.append(part.substring(0, 1).toUpperCase());
				strBuilder.append(part.substring(1).toLowerCase());
				strBuilder.append(" ");
			}
			return strBuilder.toString().trim();
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(MekanismItemGroup.MEKANISM, "Mekanism");

			for (Map.Entry<String, Block> blockEntry : MekanismBlocks.ALL_BLOCKS.entrySet()) {
				translationBuilder.add(blockEntry.getValue(), properFormat(blockEntry.getKey()));
			}

			MekanismItems.PROCESSED_RESOURCES.columnMap().forEach((resource, value) -> {
                for (Map.Entry<ResourceType, Item> subEntry : value.entrySet()) {
                    ResourceType type = subEntry.getKey();
                    translationBuilder.add(subEntry.getValue(),
							properFormat(resource.getName() + "_" + type.getPathPrefix()));
                }
            });

			for (Map.Entry<String, Item> itemEntry : MekanismItems.ALL_ITEMS.entrySet()) {
				try {
					translationBuilder.add(itemEntry.getValue(), properFormat(itemEntry.getKey()));
				} catch (RuntimeException ignored) {
					// TODO: Handle processed resource separation better.
	}
}
		}
	}
}
