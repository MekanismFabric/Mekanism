package mekanism.tools;

import mekanism.tools.datagen.BaseItemModelProvider;
import mekanism.tools.item.ItemMekanismPaxel;
import mekanism.tools.item.ItemMekanismShield;
import mekanism.tools.registries.ToolsItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Map;

import static mekanism.tools.MekanismTools.id;

public class MekanismToolsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MekanismToolsItemGenerator::new);
        pack.addProvider(MekanismToolsLangGenerator::new);
    }

    private static class MekanismToolsItemGenerator extends BaseItemModelProvider {

        public MekanismToolsItemGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            for (Map.Entry<Item, String> entry : ToolsItems.ALL_ITEMS.entrySet()) {
                Item item = entry.getKey();
                String itemKey = entry.getValue();
                Identifier texture = getTexture(item, itemKey);

                if (item instanceof ArmorItem) {
                    armorWithTrim(itemModelGenerator, item, texture);
                } else {
                    handheld(itemModelGenerator, item, texture);
                }
            }
        }

        private Identifier getTexture(Item item, String itemKey) {
            if (isVanilla(item, itemKey)) {
                return id("item/" + itemKey);
            }
            int index = itemKey.lastIndexOf('_');
            return id("item/" + itemKey.substring(0, index) + '/' + itemKey.substring(index + 1));
        }

        private boolean isVanilla(Item item, String name) {
            if (item instanceof ItemMekanismPaxel) {
                return name.startsWith("netherite") || name.startsWith("diamond") || name.startsWith("gold") || name.startsWith("iron") ||
                        name.startsWith("stone") || name.startsWith("wood");
            }
            return false;
        }
    }

    private static class MekanismToolsLangGenerator extends FabricLanguageProvider {

        FabricDataOutput dataGenerator;

        private MekanismToolsLangGenerator(FabricDataOutput dataGenerator) {
            super(dataGenerator, "en_us");
            this.dataGenerator = dataGenerator;
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add("itemgroup.mekanismtools.items", "Mekanism Tools");

            for (Map.Entry<Item, String> entry : ToolsItems.ALL_SHIELDS.entrySet()) {
                ItemMekanismShield shield = (ItemMekanismShield) entry.getKey();
                String itemKey = entry.getValue();

                translationBuilder.add(shield, convertItemKeyToDisplay(itemKey));
            }

            for (Map.Entry<Item, String> entry : ToolsItems.ALL_ITEMS.entrySet()) {
                Item item = entry.getKey();
                String itemKey = entry.getValue();

                translationBuilder.add(item, convertItemKeyToDisplay(itemKey));
            }
        }

        private String convertItemKeyToDisplay(String itemKey) {
            String[] words = itemKey.replaceAll("_", " ").split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append(WordUtils.capitalizeFully(word)).append(" ");
            }

            return result.toString().trim();
        }
    }
}
