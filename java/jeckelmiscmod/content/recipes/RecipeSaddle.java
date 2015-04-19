package jeckelmiscmod.content.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeSaddle
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(Items.saddle),
				"LLL",
				"K K",
				"S S",
				'L', new ItemStack(Items.leather),
				'S', new ItemStack(Items.string),
				'K', new ItemStack(Items.stick));
	}
}
