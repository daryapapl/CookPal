package model;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUserDAO implements UserDAO{

    private DataSource dataSource;

    private final static String ADD_USER_QUERY =
            "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
    private static final String GET_USER_QUERY =
            "SELECT id, username, email, password FROM users WHERE email = ?";
    private static final String CHECK_PASSWORD_QUERY =
            "SELECT password FROM users WHERE email = ? ";
    private static final String EDIT_USERNAME_QUERY =
            "UPDATE users SET username = ? WHERE email = ?";
    private static final String EDIT_PASSWORD_QUERY =
            "UPDATE users SET password = ? WHERE email = ?";

    public DatabaseUserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean addUser(User user) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_QUERY);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

            return true;
        }catch(SQLException throwables){
            return false;
        }
    }

    @Override
    public User getUser(String email) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            return new User(id, email, password, username);
        }catch(SQLException throwables){
            return null;
        }
    }

    @Override
    public boolean checkPassword(User user) {
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_PASSWORD_QUERY);
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String password = resultSet.getString("password");
            System.out.println(password);
            System.out.println(user.getPassword().equals(password));
            if(user.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }catch(SQLException throwables) {
            return false;
        }
    }


    @Override
    public User editUsername(User user) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USERNAME_QUERY);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public User editPassword(User user) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PASSWORD_QUERY);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.executeUpdate();
            return user;
        }catch(SQLException throwables) {
            return null;
        }
    }


}
