package model;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCategoryDAO implements CategoryDAO{
    private DataSource dataSource;

    private static final String GET_ALL_CATEGORIES_QUERY = "SELECT categoryName FROM categories";
    private static final String GET_CATEGORIES_FOR_RECIPE_QUERY =
            "SELECT categories.categoryName " +
            "FROM categories " +
            "JOIN recipeCategory ON categories.id = recipeCategory.categoryId " +
            "JOIN recipes ON recipeCategory.recipeId = recipes.id";
    private static final String GET_RECIPES_FOR_CATEGORY_QUERY =
            "SELECT title " +
            "FROM categories " +
            "JOIN recipeCategory ON categories.id = recipeCategory.categoryId " +
            "JOIN recipes ON recipeCategory.recipeId = recipes.id";

    public DatabaseCategoryDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Category> categories = new ArrayList<Category>();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                categories.add(new Category(name));
            }
            return categories;
        }catch(SQLException throwables) {
            return null;
        }
    }

    @Override
    public List<Category> getRecipeCategories(Recipe recipe) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORIES_FOR_RECIPE_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Category> categories = new ArrayList<Category>();
            while(resultSet.next()){
                String categoryName = resultSet.getString("name");
                categories.add(new Category(categoryName));
            }
            return categories;
        }catch(SQLException throwables) {
            return null;
        }
    }

    @Override
    public List<Recipe> getCategoryRecipes(Category category) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_RECIPES_FOR_CATEGORY_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Recipe> recipes = new ArrayList<Recipe>();
            while(resultSet.next()){
                String recipeTitle = resultSet.getString("title");
                recipes.add(new Recipe(recipeTitle));
            }
            return recipes;
        }catch(SQLException throwables) {
            return null;
        }
    }

    @Override
    public boolean addCategory() {
        return false;
    }

    @Override
    public boolean deleteCategory() {
        return false;
    }

    @Override
    public boolean modifyCategory() {
        return false;
    }
}
