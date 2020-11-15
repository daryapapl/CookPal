package model;

public interface UserDAO {
    public boolean addUser(User user);
    public User getUser(String email);
    public boolean checkPassword(User user);
    public User editUsername(User user);
    public User editPassword(User user);

}
