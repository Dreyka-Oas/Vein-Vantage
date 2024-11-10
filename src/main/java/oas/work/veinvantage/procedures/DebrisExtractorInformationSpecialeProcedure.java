package oas.work.veinvantage.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class DebrisExtractorInformationSpecialeProcedure {
	public static String execute(ItemStack itemstack) {
		String dirt_txt = "";
		String gravel_txt = "";
		String cobblestone_txt = "";
		String diorite_txt = "";
		String granite_txt = "";
		String andesite = "";
		String deepslate_txt = "";
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("dirt") > 0) {
			dirt_txt = "dirt : " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("dirt")) + "\n";
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("gravel") > 0) {
			gravel_txt = "gravel : " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("gravel")) + "\n";
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("cobblestone") > 0) {
			cobblestone_txt = "cobblestone : " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("cobblestone")) + "\n";
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("diorite") > 0) {
			diorite_txt = "diorite : " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("diorite")) + "\n";
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("granite") > 0) {
			granite_txt = "granite : " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("granite")) + "\n";
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("andesite") > 0) {
			andesite = "andesite : " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("andesite")) + "\n";
		}
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deepslate") > 0) {
			deepslate_txt = "deepslate : " + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deepslate"));
		}
		return dirt_txt + "" + gravel_txt + cobblestone_txt + diorite_txt + granite_txt + andesite + deepslate_txt;
	}
}
