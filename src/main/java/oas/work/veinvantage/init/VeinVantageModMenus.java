
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package oas.work.veinvantage.init;

import oas.work.veinvantage.world.inventory.ForgeMineraleGUIMenu;
import oas.work.veinvantage.VeinVantageMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

public class VeinVantageModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, VeinVantageMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<ForgeMineraleGUIMenu>> FORGE_MINERALE_GUI = REGISTRY.register("forge_minerale_gui", () -> IMenuTypeExtension.create(ForgeMineraleGUIMenu::new));
}
