package model;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRecipeDAO implements RecipeDAO{

    private DataSource dataSource;

    private static final String ADD_RECIPE_QUERY =
            "INSERT INTO recipes (timeDate, instructions, numPortions, timeToPrepare, isFavorite, userId, title) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?) ";
    private final static String MODIFY_RECIPE_QUERY = "UPDATE recipes SET instructions = ? where id = ? ";
    private static final String DELETE_RECIPE_QUERY = "DELETE FROM recipes WHERE id = ? ";
    private static final String GET_ALL_RECIPES_QUERY =
            "SELECT id, title, timeDate, instructions, numPortions, timeToPrepare, isFavorite, userId " +
                    "FROM recipes WHERE userId = ? ";
    private static final String ADD_CATEGORY_TO_RECIPE_QUERY =
            "INSERT INTO recipeCategory (recipeId, categoryId) VALUES (" +
                "(SELECT id FROM recipes WHERE id = ?), " +
                "(SELECT id FROM categories WHERE id = ?)); ";
    private static final String DELETE_CATEGORY_FROM_RECIPE_QUERY =
            "DELETE FROM recipeCategory WHERE recipeId = ? AND categoryId = ? ";


    public DatabaseRecipeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean addRecipe(Recipe recipe, User user) {
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_RECIPE_QUERY);
            preparedStatement.setObject(1, LocalDateTime.now());
            preparedStatement.setString(2, recipe.getInstructions());
            preparedStatement.setDouble(3, recipe.getNumPortions());
            preparedStatement.setDouble(4, recipe.getTimeToPrepare());
            preparedStatement.setBoolean(5, recipe.isFavorite());
            preparedStatement.setInt(6, user.getId());
            preparedStatement.setString(7, recipe.getTitle());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    @Override
    public Recipe modifyRecipe(Recipe recipe) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(MODIFY_RECIPE_QUERY);
            preparedStatement.setString(1, recipe.getInstructions());
            preparedStatement.setInt(2, recipe.getId());
            preparedStatement.executeUpdate();
            return recipe;
        }catch(SQLException throwables){
            return null;
        }

    }

    @Override
    public boolean deleteRecipe(Recipe recipe) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RECIPE_QUERY);
            preparedStatement.setInt(1, recipe.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException throwables) {
            return false;
        }
    }

    @Override
    public List<Recipe> getAllUserRecipes(User user) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RECIPES_QUERY);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Recipe> recipes = new ArrayList<Recipe>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                LocalDateTime timeDate = (LocalDateTime) resultSet.getObject("timeDate");
                String instructions = resultSet.getString("instructions");
                double numPortions = resultSet.getDouble("numPortions");
                double timeToPrepare = resultSet.getDouble("timeToPrepare");
                boolean isFavorite = resultSet.getBoolean("isFavorite");
                Recipe recipe = new Recipe(id, title, timeDate, instructions, numPortions, timeToPrepare, isFavorite, user.getId());
                recipes.add(recipe);
            }
            return recipes;
        }catch(SQLException throwables) {
            return null;
        }
    }

    @Override
    public boolean addCategoryToRecipe(Recipe recipe, Category category) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CATEGORY_TO_RECIPE_QUERY);
            preparedStatement.setInt(1, recipe.getId());
            preparedStatement.setInt(2, category.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException throwables) {
            return false;
        }
    }

    @Override
    public boolean deleteCategoryFromRecipe(Recipe recipe, Category category) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_FROM_RECIPE_QUERY);
            preparedStatement.setInt(1, recipe.getId());
            preparedStatement.setInt(2, category.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException throwables) {
            return false;
        }
    }
}
