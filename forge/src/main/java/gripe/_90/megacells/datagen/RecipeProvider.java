package gripe._90.megacells.datagen;

import java.util.Objects;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import appeng.api.util.AEColor;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.AEParts;
import appeng.core.definitions.BlockDefinition;
import appeng.core.definitions.ItemDefinition;
import appeng.datagen.providers.tags.ConventionTags;
import appeng.items.storage.StorageTier;
import appeng.recipes.handlers.InscriberProcessType;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import appeng.recipes.transform.TransformCircumstance;
import appeng.recipes.transform.TransformRecipeBuilder;

import gripe._90.megacells.definition.MEGABlocks;
import gripe._90.megacells.definition.MEGAItems;
import gripe._90.megacells.definition.MEGAParts;
import gripe._90.megacells.definition.MEGATags;
import gripe._90.megacells.integration.appbot.AppBotItems;
import gripe._90.megacells.util.Utils;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {
    public RecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // spotless:off
        component(consumer, MEGAItems.TIER_1M, StorageTier.SIZE_256K, AEItems.SKY_DUST.asItem());
        component(consumer, MEGAItems.TIER_4M, MEGAItems.TIER_1M, AEItems.ENDER_DUST.asItem());
        component(consumer, MEGAItems.TIER_16M, MEGAItems.TIER_4M, AEItems.ENDER_DUST.asItem());
        component(consumer, MEGAItems.TIER_64M, MEGAItems.TIER_16M, AEItems.MATTER_BALL.asItem());
        component(consumer, MEGAItems.TIER_256M, MEGAItems.TIER_64M, AEItems.MATTER_BALL.asItem());

        housing(consumer, MEGAItems.MEGA_ITEM_CELL_HOUSING, MEGATags.SKY_STEEL_INGOT);
        housing(consumer, MEGAItems.MEGA_FLUID_CELL_HOUSING, ConventionTags.COPPER_INGOT);

        cell(consumer, MEGAItems.ITEM_CELL_1M, MEGAItems.CELL_COMPONENT_1M, MEGAItems.MEGA_ITEM_CELL_HOUSING, ConventionTags.IRON_INGOT);
        cell(consumer, MEGAItems.ITEM_CELL_4M, MEGAItems.CELL_COMPONENT_4M, MEGAItems.MEGA_ITEM_CELL_HOUSING, ConventionTags.IRON_INGOT);
        cell(consumer, MEGAItems.ITEM_CELL_16M, MEGAItems.CELL_COMPONENT_16M, MEGAItems.MEGA_ITEM_CELL_HOUSING, ConventionTags.IRON_INGOT);
        cell(consumer, MEGAItems.ITEM_CELL_64M, MEGAItems.CELL_COMPONENT_64M, MEGAItems.MEGA_ITEM_CELL_HOUSING, ConventionTags.IRON_INGOT);
        cell(consumer, MEGAItems.ITEM_CELL_256M, MEGAItems.CELL_COMPONENT_256M, MEGAItems.MEGA_ITEM_CELL_HOUSING, ConventionTags.IRON_INGOT);
        cell(consumer, MEGAItems.FLUID_CELL_1M, MEGAItems.CELL_COMPONENT_1M, MEGAItems.MEGA_FLUID_CELL_HOUSING, ConventionTags.COPPER_INGOT);
        cell(consumer, MEGAItems.FLUID_CELL_4M, MEGAItems.CELL_COMPONENT_4M, MEGAItems.MEGA_FLUID_CELL_HOUSING, ConventionTags.COPPER_INGOT);
        cell(consumer, MEGAItems.FLUID_CELL_16M, MEGAItems.CELL_COMPONENT_16M, MEGAItems.MEGA_FLUID_CELL_HOUSING, ConventionTags.COPPER_INGOT);
        cell(consumer, MEGAItems.FLUID_CELL_64M, MEGAItems.CELL_COMPONENT_64M, MEGAItems.MEGA_FLUID_CELL_HOUSING, ConventionTags.COPPER_INGOT);
        cell(consumer, MEGAItems.FLUID_CELL_256M, MEGAItems.CELL_COMPONENT_256M, MEGAItems.MEGA_FLUID_CELL_HOUSING, ConventionTags.COPPER_INGOT);

        portable(consumer, MEGAItems.PORTABLE_ITEM_CELL_1M, MEGAItems.CELL_COMPONENT_1M, MEGAItems.MEGA_ITEM_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_ITEM_CELL_4M, MEGAItems.CELL_COMPONENT_4M, MEGAItems.MEGA_ITEM_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_ITEM_CELL_16M, MEGAItems.CELL_COMPONENT_16M, MEGAItems.MEGA_ITEM_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_ITEM_CELL_64M, MEGAItems.CELL_COMPONENT_64M, MEGAItems.MEGA_ITEM_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_ITEM_CELL_256M, MEGAItems.CELL_COMPONENT_256M, MEGAItems.MEGA_ITEM_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_FLUID_CELL_1M, MEGAItems.CELL_COMPONENT_1M, MEGAItems.MEGA_FLUID_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_FLUID_CELL_4M, MEGAItems.CELL_COMPONENT_4M, MEGAItems.MEGA_FLUID_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_FLUID_CELL_16M, MEGAItems.CELL_COMPONENT_16M, MEGAItems.MEGA_FLUID_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_FLUID_CELL_64M, MEGAItems.CELL_COMPONENT_64M, MEGAItems.MEGA_FLUID_CELL_HOUSING);
        portable(consumer, MEGAItems.PORTABLE_FLUID_CELL_256M, MEGAItems.CELL_COMPONENT_256M, MEGAItems.MEGA_FLUID_CELL_HOUSING);
        // spotless:on

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MEGABlocks.SKY_STEEL_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', MEGATags.SKY_STEEL_INGOT)
                .unlockedBy("has_sky_steel_ingot", has(MEGATags.SKY_STEEL_INGOT))
                .save(consumer, Utils.makeId("crafting/sky_steel_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MEGAItems.SKY_STEEL_INGOT, 9)
                .requires(MEGATags.SKY_STEEL_BLOCK_ITEM)
                .unlockedBy("has_sky_steel_ingot", has(MEGATags.SKY_STEEL_INGOT))
                .save(consumer, Utils.makeId("crafting/sky_steel_ingot_from_sky_steel_block"));

        TransformRecipeBuilder.transform(consumer, Utils.makeId("transform/sky_steel_ingot"), MEGAItems.SKY_STEEL_INGOT,
                2, TransformCircumstance.fluid(FluidTags.WATER), Ingredient.of(ConventionTags.IRON_INGOT),
                Ingredient.of(AEItems.CERTUS_QUARTZ_CRYSTAL_CHARGED), Ingredient.of(AEBlocks.SKY_STONE_BLOCK));

        InscriberRecipeBuilder.inscribe(AEItems.SINGULARITY, MEGAItems.ACCUMULATION_PROCESSOR_PRESS, 1)
                .setTop(Ingredient.of(AEItems.CALCULATION_PROCESSOR_PRESS))
                .setBottom(Ingredient.of(AEItems.ENGINEERING_PROCESSOR_PRESS))
                .setMode(InscriberProcessType.PRESS)
                .save(consumer, Utils.makeId("inscriber/accumulation_processor_press"));
        InscriberRecipeBuilder.inscribe(Items.IRON_BLOCK, MEGAItems.ACCUMULATION_PROCESSOR_PRESS, 1)
                .setTop(Ingredient.of(MEGAItems.ACCUMULATION_PROCESSOR_PRESS))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(consumer, Utils.makeId("inscriber/accumulation_processor_press_extra"));

        InscriberRecipeBuilder.inscribe(MEGATags.SKY_STEEL_INGOT, MEGAItems.ACCUMULATION_PROCESSOR_PRINT, 1)
                .setTop(Ingredient.of(MEGAItems.ACCUMULATION_PROCESSOR_PRESS))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(consumer, Utils.makeId("inscriber/accumulation_processor_print"));
        InscriberRecipeBuilder.inscribe(ConventionTags.FLUIX_DUST, MEGAItems.ACCUMULATION_PROCESSOR, 1)
                .setTop(Ingredient.of(MEGAItems.ACCUMULATION_PROCESSOR_PRINT))
                .setBottom(Ingredient.of(AEItems.SILICON_PRINT))
                .setMode(InscriberProcessType.PRESS)
                .save(consumer, Utils.makeId("inscriber/accumulation_processor"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MEGAItems.BULK_CELL_COMPONENT)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aea")
                .define('a', AEItems.SKY_DUST)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', MEGAItems.CELL_COMPONENT_4M)
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('e', AEItems.SPATIAL_2_CELL_COMPONENT)
                .unlockedBy("has_cell_component_4m", has(MEGAItems.CELL_COMPONENT_4M))
                .unlockedBy("has_2_cubed_spatial_cell_component", has(AEItems.SPATIAL_2_CELL_COMPONENT))
                .save(consumer, Utils.makeId("crafting/bulk_cell_component"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MEGAItems.BULK_ITEM_CELL)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.SKY_DUST)
                .define('c', MEGAItems.BULK_CELL_COMPONENT)
                .define('d', Items.NETHERITE_INGOT)
                .unlockedBy("has_bulk_cell_component", has(MEGAItems.BULK_CELL_COMPONENT))
                .save(consumer, Utils.makeId("cells/standard/bulk_item_cell"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MEGABlocks.MEGA_ENERGY_CELL)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', AEBlocks.DENSE_ENERGY_CELL)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .unlockedBy("has_dense_energy_cell", has(AEBlocks.DENSE_ENERGY_CELL))
                .unlockedBy("has_accumulation_processor", has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(consumer, Utils.makeId("crafting/mega_energy_cell"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MEGABlocks.MEGA_CRAFTING_UNIT)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aba")
                .define('a', AEBlocks.CRAFTING_UNIT)
                .define('b', AEItems.LOGIC_PROCESSOR)
                .define('c', AEParts.SMART_CABLE.item(AEColor.TRANSPARENT))
                .define('d', MEGAItems.ACCUMULATION_PROCESSOR)
                .unlockedBy("has_logic_processor", has(AEItems.LOGIC_PROCESSOR))
                .unlockedBy("has_accumulation_processor", has(MEGAItems.ACCUMULATION_PROCESSOR))
                .save(consumer, Utils.makeId("crafting/mega_crafting_unit"));
        craftingBlock(consumer, MEGABlocks.CRAFTING_ACCELERATOR, AEItems.ENGINEERING_PROCESSOR);
        craftingBlock(consumer, MEGABlocks.CRAFTING_STORAGE_1M, MEGAItems.CELL_COMPONENT_1M);
        craftingBlock(consumer, MEGABlocks.CRAFTING_STORAGE_4M, MEGAItems.CELL_COMPONENT_4M);
        craftingBlock(consumer, MEGABlocks.CRAFTING_STORAGE_16M, MEGAItems.CELL_COMPONENT_16M);
        craftingBlock(consumer, MEGABlocks.CRAFTING_STORAGE_64M, MEGAItems.CELL_COMPONENT_64M);
        craftingBlock(consumer, MEGABlocks.CRAFTING_STORAGE_256M, MEGAItems.CELL_COMPONENT_256M);
        craftingBlock(consumer, MEGABlocks.CRAFTING_MONITOR, AEParts.STORAGE_MONITOR);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MEGAItems.GREATER_ENERGY_CARD)
                .requires(AEItems.ADVANCED_CARD)
                .requires(MEGABlocks.MEGA_ENERGY_CELL)
                .unlockedBy("has_advanced_card", has(AEItems.ADVANCED_CARD))
                .unlockedBy("has_mega_energy_cell", has(MEGABlocks.MEGA_ENERGY_CELL))
                .save(consumer, Utils.makeId("crafting/greater_energy_card"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MEGAItems.GREATER_ENERGY_CARD)
                .requires(AEItems.ENERGY_CARD)
                .requires(MEGABlocks.MEGA_ENERGY_CELL)
                .unlockedBy("has_advanced_card", has(AEItems.ADVANCED_CARD))
                .unlockedBy("has_mega_energy_cell", has(MEGABlocks.MEGA_ENERGY_CELL))
                .save(consumer, Utils.makeId("crafting/greater_energy_card_upgraded"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MEGAItems.COMPRESSION_CARD)
                .requires(AEItems.ADVANCED_CARD)
                .requires(AEItems.MATTER_BALL)
                .unlockedBy("has_advanced_card", has(AEItems.ADVANCED_CARD))
                .unlockedBy("has_matter_ball", has(AEItems.MATTER_BALL))
                .save(consumer, Utils.makeId("crafting/compression_card"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MEGAParts.DECOMPRESSION_MODULE)
                .pattern("IAI")
                .pattern("C#E")
                .pattern("ILI")
                .define('I', ConventionTags.IRON_INGOT)
                .define('A', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('C', AEItems.CALCULATION_PROCESSOR)
                .define('E', AEItems.ENGINEERING_PROCESSOR)
                .define('L', AEItems.LOGIC_PROCESSOR)
                .define('#', MEGAItems.COMPRESSION_CARD)
                .unlockedBy("has_accumulation_processor", has(MEGAItems.ACCUMULATION_PROCESSOR))
                .unlockedBy("has_compression_card", has(MEGAItems.COMPRESSION_CARD))
                .save(consumer, Utils.makeId("crafting/decompression_module"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MEGABlocks.MEGA_PATTERN_PROVIDER)
                .requires(AEBlocks.PATTERN_PROVIDER)
                .requires(MEGAItems.ACCUMULATION_PROCESSOR)
                .unlockedBy("has_accumulation_processor", has(MEGAItems.ACCUMULATION_PROCESSOR))
                .unlockedBy("has_pattern_provider", has(ConventionTags.PATTERN_PROVIDER))
                .save(consumer, Utils.makeId("network/mega_pattern_provider"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MEGAParts.MEGA_PATTERN_PROVIDER)
                .requires(MEGABlocks.MEGA_PATTERN_PROVIDER)
                .unlockedBy("has_mega_pattern_provider", has(MEGABlocks.MEGA_PATTERN_PROVIDER))
                .save(consumer, Utils.makeId("network/mega_pattern_provider_part"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MEGABlocks.MEGA_PATTERN_PROVIDER)
                .requires(MEGAParts.MEGA_PATTERN_PROVIDER)
                .unlockedBy("has_cable_mega_pattern_provider", has(MEGAParts.MEGA_PATTERN_PROVIDER))
                .save(consumer, Utils.makeId("network/mega_pattern_provider_block"));

        if (Utils.PLATFORM.isModLoaded("appbot")) {
            manaCells(consumer, AppBotItems.MANA_CELL_1M, AppBotItems.PORTABLE_MANA_CELL_1M, MEGAItems.TIER_1M);
            manaCells(consumer, AppBotItems.MANA_CELL_4M, AppBotItems.PORTABLE_MANA_CELL_4M, MEGAItems.TIER_4M);
            manaCells(consumer, AppBotItems.MANA_CELL_16M, AppBotItems.PORTABLE_MANA_CELL_16M, MEGAItems.TIER_16M);
            manaCells(consumer, AppBotItems.MANA_CELL_64M, AppBotItems.PORTABLE_MANA_CELL_64M, MEGAItems.TIER_64M);
            manaCells(consumer, AppBotItems.MANA_CELL_256M, AppBotItems.PORTABLE_MANA_CELL_256M, MEGAItems.TIER_256M);
        }
    }

    private void component(Consumer<FinishedRecipe> consumer, StorageTier tier, StorageTier preceding,
            ItemLike binder) {
        var precedingComponent = preceding.componentSupplier().get();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, tier.componentSupplier().get())
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', binder)
                .define('b', MEGAItems.ACCUMULATION_PROCESSOR)
                .define('c', precedingComponent)
                .define('d', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .unlockedBy("has_accumulation_processor", has(MEGAItems.ACCUMULATION_PROCESSOR))
                .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(precedingComponent)).getPath(),
                        has(precedingComponent))
                .save(consumer, Utils.makeId("cells/" + Objects
                        .requireNonNull(ForgeRegistries.ITEMS.getKey(tier.componentSupplier().get())).getPath()));
    }

    private void cell(Consumer<FinishedRecipe> consumer, ItemDefinition<?> cell, ItemDefinition<?> component,
            ItemDefinition<?> housing, TagKey<Item> housingMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, cell)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.SKY_DUST)
                .define('c', component)
                .define('d', housingMaterial)
                .unlockedBy("has_" + component.id().getPath(), has(component))
                .save(consumer, Utils.makeId("cells/standard/" + cell.id().getPath()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, cell)
                .requires(housing)
                .requires(component)
                .unlockedBy("has_" + component.id().getPath(), has(component))
                .unlockedBy("has_" + housing.id().getPath(), has(housing))
                .save(consumer, Utils.makeId("cells/standard/" + cell.id().getPath() + "_with_housing"));
    }

    private void portable(Consumer<FinishedRecipe> consumer, ItemDefinition<?> cell, ItemDefinition<?> component,
            ItemDefinition<?> housing) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, cell)
                .requires(AEBlocks.CHEST)
                .requires(component)
                .requires(AEBlocks.DENSE_ENERGY_CELL)
                .requires(housing)
                .unlockedBy("has_" + housing.id().getPath(), has(housing))
                .unlockedBy("has_" + component.id().getPath(), has(component))
                .unlockedBy("has_dense_energy_cell", has(AEBlocks.DENSE_ENERGY_CELL))
                .save(consumer, Utils.makeId("cells/portable/" + cell.id().getPath()));
    }

    private void housing(Consumer<FinishedRecipe> consumer, ItemDefinition<?> housing, TagKey<Item> housingMaterial) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, housing)
                .pattern("aba")
                .pattern("b b")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_VIBRANT_GLASS)
                .define('b', AEItems.SKY_DUST)
                .define('d', housingMaterial)
                .unlockedBy("has_dusts/sky_stone", has(AEItems.SKY_DUST))
                .save(consumer, Utils.makeId("cells/" + housing.id().getPath()));
    }

    private void craftingBlock(Consumer<FinishedRecipe> consumer, BlockDefinition<?> unit, ItemLike part) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, unit)
                .requires(MEGABlocks.MEGA_CRAFTING_UNIT)
                .requires(part)
                .unlockedBy("has_mega_crafting_unit", has(MEGABlocks.MEGA_CRAFTING_UNIT))
                .save(consumer, Utils.makeId("crafting/" + unit.id().getPath()));
    }

    private void manaCells(Consumer<FinishedRecipe> consumer, ItemDefinition<?> cell, ItemDefinition<?> portable,
            StorageTier tier) {
        var component = tier.componentSupplier().get();
        var componentPath = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(component)).getPath();

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, cell).requires(AppBotItems.MEGA_MANA_CELL_HOUSING)
                .requires(tier.componentSupplier().get()).unlockedBy("has_" + componentPath, has(component))
                .unlockedBy("has_mega_mana_cell_housing", has(AppBotItems.MEGA_MANA_CELL_HOUSING))
                .save(consumer, Utils.makeId("cells/standard/" + cell.id().getPath() + "_with_housing"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, portable).requires(AEBlocks.CHEST).requires(component)
                .requires(AEBlocks.DENSE_ENERGY_CELL).requires(AppBotItems.MEGA_MANA_CELL_HOUSING)
                .unlockedBy("has_mega_mana_cell_housing", has(AppBotItems.MEGA_MANA_CELL_HOUSING))
                .unlockedBy("has_" + componentPath, has(component))
                .unlockedBy("has_dense_energy_cell", has(AEBlocks.DENSE_ENERGY_CELL))
                .save(consumer, Utils.makeId("cells/portable/" + portable.id().getPath()));
    }
}