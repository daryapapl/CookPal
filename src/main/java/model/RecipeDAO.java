package model;

import java.util.List;

public interface RecipeDAO {
    public boolean addRecipe(Recipe recipe, User user);
    public Recipe modifyRecipe(Recipe recipe);
    public boolean deleteRecipe(Recipe recipe);
    public List<Recipe> getAllUserRecipes(User user);

    boolean addCategoryToRecipe(Recipe recipe, Category category);
    boolean deleteCategoryFromRecipe(Recipe recipe, Category category);
}
