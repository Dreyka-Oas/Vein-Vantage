
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package oas.work.veinvantage.init;

import oas.work.veinvantage.item.DebrisExtractorItem;
import oas.work.veinvantage.VeinVantageMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class VeinVantageModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(VeinVantageMod.MODID);
	public static final DeferredItem<Item> DEBRIS_EXTRACTOR = REGISTRY.register("debris_extractor", DebrisExtractorItem::new);
	public static final DeferredItem<Item> FORGE_MINERALE = block(VeinVantageModBlocks.FORGE_MINERALE);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
