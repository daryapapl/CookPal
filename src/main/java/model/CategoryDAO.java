package model;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();
    List<Category> getRecipeCategories(Recipe recipe);
    List<Recipe> getCategoryRecipes(Category category);

    boolean addCategory();
    boolean deleteCategory();
    boolean modifyCategory();


}
