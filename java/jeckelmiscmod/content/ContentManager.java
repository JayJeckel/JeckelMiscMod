package jeckelmiscmod.content;

import jeckelmiscmod.content.recipes.RecipeArrow;
import jeckelmiscmod.content.recipes.RecipeHorseArmor;
import jeckelmiscmod.content.recipes.RecipeLead;
import jeckelmiscmod.content.recipes.RecipeNameTag;
import jeckelmiscmod.content.recipes.RecipeSaddle;

public class ContentManager
{
	public static class ModBlocks { }

	public static class ModItems { }

	public void pre() { }

	public void initialize()
	{
		RecipeArrow.register();
		RecipeLead.register();
		RecipeNameTag.register();
		RecipeSaddle.register();
		RecipeHorseArmor.register();
	}

	public void post() { }
}
