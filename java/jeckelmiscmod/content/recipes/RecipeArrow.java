package jeckelmiscmod.content.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeArrow
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(Items.arrow, 4),
				"T", "M", "B",
				'T', new ItemStack(Items.flint),
				'M', new ItemStack(Items.stick),
				'B', new ItemStack(Items.paper));
		GameRegistry.addShapedRecipe(new ItemStack(Items.arrow, 4),
				"T", "M", "B",
				'T', new ItemStack(Blocks.stone),
				'M', new ItemStack(Items.stick),
				'B', new ItemStack(Items.feather));
		GameRegistry.addShapedRecipe(new ItemStack(Items.arrow, 4),
				"T", "M", "B",
				'T', new ItemStack(Blocks.stone),
				'M', new ItemStack(Items.stick),
				'B', new ItemStack(Items.paper));
	}
}
