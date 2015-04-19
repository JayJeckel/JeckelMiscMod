package jeckelmiscmod.content.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHorseArmor
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(Items.iron_horse_armor),
				" RT",
				"LLL",
				"T T",
				'L', new ItemStack(Items.leather),
				'R', new ItemStack(Items.lead),
				'T', new ItemStack(Items.iron_ingot));

		GameRegistry.addShapedRecipe(new ItemStack(Items.golden_horse_armor),
				" RT",
				"LLL",
				"T T",
				'L', new ItemStack(Items.leather),
				'R', new ItemStack(Items.lead),
				'T', new ItemStack(Items.gold_ingot));

		GameRegistry.addShapedRecipe(new ItemStack(Items.diamond_horse_armor),
				" RT",
				"LLL",
				"T T",
				'L', new ItemStack(Items.leather),
				'R', new ItemStack(Items.lead),
				'T', new ItemStack(Items.diamond));
	}
}
