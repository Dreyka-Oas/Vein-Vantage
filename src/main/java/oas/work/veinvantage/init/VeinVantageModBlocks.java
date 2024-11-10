
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package oas.work.veinvantage.init;

import oas.work.veinvantage.block.ForgeMineraleBlock;
import oas.work.veinvantage.VeinVantageMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

public class VeinVantageModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(VeinVantageMod.MODID);
	public static final DeferredBlock<Block> FORGE_MINERALE = REGISTRY.register("forge_minerale", ForgeMineraleBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
