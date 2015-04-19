package jeckelmiscmod.content.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeLead
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(Items.lead, 1),
				"SS ",
				"SS ",
				"  S",
				'S', new ItemStack(Items.string));
	}
}
