
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package oas.work.veinvantage.init;

import oas.work.veinvantage.client.gui.ForgeMineraleGUIScreen;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VeinVantageModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(VeinVantageModMenus.FORGE_MINERALE_GUI.get(), ForgeMineraleGUIScreen::new);
	}
}
