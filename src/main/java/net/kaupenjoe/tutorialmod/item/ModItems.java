package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CCORE = registerItem("ccore",
            new Item(new FabricItemSettings()));
    public static final Item ASSACP = registerItem("assacp",
            new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine",
            new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, CCORE);
        addToItemGroup(ItemGroups.INGREDIENTS, ASSACP);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_CITRINE);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        addItemsToItemGroup();
    }

    Identifier itemId = new Identifier("modid", "custom_item");

    // Create a custom effect
    public static final StatusEffect CUSTOM_EFFECT = new StatusEffect(
            StatusEffectType.BENEFICIAL,
            0x00FF00 // Green color
    );

    // Register the custom effect
    public static void registerCustomEffect() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("modid", "custom_effect"), CUSTOM_EFFECT);
    }

    // Apply the effect when the player is holding the custom item
    public static void applyCustomEffect(PlayerEntity player) {
        ItemStack mainHandStack = player.getMainHandStack();
        if (mainHandStack.getItem() == CCORE) {
            player.addStatusEffect(new StatusEffectInstance(CUSTOM_EFFECT, 200, 0));
        }
    }

}


