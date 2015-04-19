package jeckelmiscmod.content.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeNameTag
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(Items.name_tag),
				" S ",
				"KPK",
				'P', new ItemStack(Items.paper),
				'S', new ItemStack(Items.string),
				'K', new ItemStack(Items.stick));
	}
}
