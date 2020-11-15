package model;
import java.util.*;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;


    public User(Integer id, String email, String password, String username){
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User(String username, String email, String password){
        this.id = null;
        this.email = email;
        this.password = password;
        this.username = username;
    }
    public User(int id, String email){
        this.id = id;
        this.email = email;
    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

