package mekanism.tools.datagen;

import mekanism.tools.registries.ToolsItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class ToolsRecipeHelper {

    private static ShapedRecipeJsonBuilder helmet(ItemConvertible input, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("bbb")
                .pattern("b b")
                .input('b', input)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input));
    }

    private static ShapedRecipeJsonBuilder chestplate(ItemConvertible input, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("b b")
                .pattern("bbb")
                .pattern("bbb")
                .input('b', input)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input));
    }

    private static ShapedRecipeJsonBuilder leggings(ItemConvertible input, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("bbb")
                .pattern("b b")
                .pattern("b b")
                .input('b', input)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input));
    }

    private static ShapedRecipeJsonBuilder boots(ItemConvertible input, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("b b")
                .pattern("b b")
                .input('b', input)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input));
    }

    private static ShapedRecipeJsonBuilder shield(ItemConvertible input, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("bsb")
                .pattern("bbb")
                .pattern(" b ")
                .input('b', input)
                .input('s', Items.SHIELD)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(Items.SHIELD), FabricRecipeProvider.conditionsFromItem(Items.SHIELD));
    }

    private static void registerArmorSet(Consumer<RecipeJsonProvider> exporter, String setName, ItemConvertible input,
                                        ItemConvertible helmet, ItemConvertible chestplate,
                                        ItemConvertible leggings, ItemConvertible boots, ItemConvertible shield) {
        String group = setName + "/armor/";

        helmet(input, helmet).group(group).offerTo(exporter);
        chestplate(input, chestplate).group(group).offerTo(exporter);
        leggings(input, leggings).group(group).offerTo(exporter);
        boots(input, boots).group(group).offerTo(exporter);
        shield(input, shield).group(group).offerTo(exporter);
    }

    private static ShapedRecipeJsonBuilder sword(ItemConvertible input, ItemConvertible rod, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("b")
                .pattern("b")
                .pattern("s")
                .input('b', input)
                .input('s', rod)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(rod), FabricRecipeProvider.conditionsFromItem(rod));
    }

    private static ShapedRecipeJsonBuilder axe(ItemConvertible input, ItemConvertible rod, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("bb")
                .pattern("bs")
                .pattern(" s")
                .input('b', input)
                .input('s', rod)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(rod), FabricRecipeProvider.conditionsFromItem(rod));
    }

    private static ShapedRecipeJsonBuilder pickaxe(ItemConvertible input, ItemConvertible rod, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("bbb")
                .pattern(" s ")
                .pattern(" s ")
                .input('b', input)
                .input('s', rod)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(rod), FabricRecipeProvider.conditionsFromItem(rod));
    }

    private static ShapedRecipeJsonBuilder shovel(ItemConvertible input, ItemConvertible rod, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("b")
                .pattern("s")
                .pattern("s")
                .input('b', input)
                .input('s', rod)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(rod), FabricRecipeProvider.conditionsFromItem(rod));
    }

    private static ShapedRecipeJsonBuilder hoe(ItemConvertible input, ItemConvertible rod, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("bb")
                .pattern(" s")
                .pattern(" s")
                .input('b', input)
                .input('s', rod)
                .criterion(FabricRecipeProvider.hasItem(input), FabricRecipeProvider.conditionsFromItem(input))
                .criterion(FabricRecipeProvider.hasItem(rod), FabricRecipeProvider.conditionsFromItem(rod));
    }

    private static ShapedRecipeJsonBuilder vanillaPaxel(Consumer<RecipeJsonProvider> exporter, ItemConvertible axe,
                                                        ItemConvertible pickaxe, ItemConvertible shovel, ItemConvertible rod,
                                                        ItemConvertible output, ItemConvertible nugget) {
        if (nugget != null) {
            String nuggetFromBase = Registries.ITEM.getKey(nugget.asItem()).get() + "_from_";
            registerSmeltingBlastingRecipe(exporter, nuggetFromBase, output, nugget);
        }
        return paxel(axe, pickaxe, shovel, rod, output);
    }

    private static ShapedRecipeJsonBuilder paxel(ItemConvertible axe, ItemConvertible pickaxe, ItemConvertible shovel,
                                                 ItemConvertible rod, ItemConvertible output) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("aps")
                .pattern(" r ")
                .pattern(" r ")
                .input('a', axe)
                .input('p', pickaxe)
                .input('s', shovel)
                .input('r', rod)
                .criterion(FabricRecipeProvider.hasItem(axe), FabricRecipeProvider.conditionsFromItem(axe))
                .criterion(FabricRecipeProvider.hasItem(pickaxe), FabricRecipeProvider.conditionsFromItem(pickaxe))
                .criterion(FabricRecipeProvider.hasItem(shovel), FabricRecipeProvider.conditionsFromItem(shovel))
                .criterion(FabricRecipeProvider.hasItem(rod), FabricRecipeProvider.conditionsFromItem(rod));
    }

    private static void registerToolSet(Consumer<RecipeJsonProvider> exporter, String setName, ItemConvertible input, ItemConvertible rod,
                                        ItemConvertible sword, ItemConvertible pickaxe, ItemConvertible axe,
                                        ItemConvertible shovel, ItemConvertible hoe, ItemConvertible paxel) {
        String group = setName + "/tools/";

        sword(input, rod, sword).group(group).offerTo(exporter);
        pickaxe(input, rod, pickaxe).group(group).offerTo(exporter);
        axe(input, rod, axe).group(group).offerTo(exporter);
        shovel(input, rod, shovel).group(group).offerTo(exporter);
        hoe(input, rod, hoe).group(group).offerTo(exporter);
        paxel(axe, pickaxe, shovel, rod, paxel).group(group).offerTo(exporter);
    }

    private static void registerSmeltingBlastingRecipe(Consumer<RecipeJsonProvider> exporter, String groupName,
                                                       ItemConvertible input, ItemConvertible output) {
        RecipeProvider.offerSmelting(exporter, List.of(input), RecipeCategory.MISC, output, 0.1F, 200, groupName + "smelting");
        RecipeProvider.offerBlasting(exporter, List.of(input), RecipeCategory.MISC, output, 0.1F, 200, groupName + "blasting");
    }

    public static void registerVanillaPaxels(Consumer<RecipeJsonProvider> exporter) {
        vanillaPaxel(exporter, Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.STICK, ToolsItems.WOOD_PAXEL, null).group("vanilla/tools/").offerTo(exporter);
        vanillaPaxel(exporter, Items.STONE_AXE, Items.STONE_PICKAXE, Items.STONE_SHOVEL, Items.STICK, ToolsItems.STONE_PAXEL, null).group("vanilla/tools/").offerTo(exporter);
        vanillaPaxel(exporter, Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.STICK, ToolsItems.IRON_PAXEL, Items.IRON_NUGGET).group("vanilla/tools/").offerTo(exporter);
        vanillaPaxel(exporter, Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.STICK, ToolsItems.GOLD_PAXEL, Items.GOLD_NUGGET).group("vanilla/tools/").offerTo(exporter);
        vanillaPaxel(exporter, Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.STICK, ToolsItems.DIAMOND_PAXEL, null).group("vanilla/tools/").offerTo(exporter);
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ToolsItems.DIAMOND_PAXEL), Ingredient.ofItems(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS, ToolsItems.NETHERITE_PAXEL)
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ToolsItems.DIAMOND_PAXEL),
                        FabricRecipeProvider.conditionsFromItem(ToolsItems.DIAMOND_PAXEL))
                .offerTo(exporter, new Identifier("vanilla/tools/" + FabricRecipeProvider.getRecipeName(ToolsItems.NETHERITE_PAXEL)));
    }

    public static void registerRecipeSet(Consumer<RecipeJsonProvider> exporter, String setName, ItemConvertible helmet,
                                         ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots,
                                         ItemConvertible sword, ItemConvertible pickaxe, ItemConvertible axe,
                                         ItemConvertible shovel, ItemConvertible hoe, ItemConvertible paxel,
                                         ItemConvertible shield, ItemConvertible ingot, ItemConvertible rod,
                                         @Nullable ItemConvertible nugget) {
        registerArmorSet(exporter, setName, ingot, helmet, chestplate, leggings, boots, shield);
        registerToolSet(exporter, setName, ingot, rod, sword, pickaxe, axe, shovel, hoe, paxel);
        if (nugget != null) {
            String nuggetFromBase = setName + "/nugget_from_";
            registerSmeltingBlastingRecipe(exporter, nuggetFromBase, paxel, nugget);
        }
    }
}
