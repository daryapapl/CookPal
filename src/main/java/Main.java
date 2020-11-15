import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import model.DatabaseUserDAO;
import model.User;
import model.UserDAO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String [] args){
        staticFileLocation("/style");

        HikariConfig hikariConfig = new HikariConfig("/resources.properties");
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        UserDAO userDAO = new DatabaseUserDAO(hikariDataSource);

        get("/", (req, res) -> {
            return new ModelAndView(null, "/logged-out.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sign-up", (req, res) -> {
            return new ModelAndView(null, "/sign-up.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sign-in", (req, res) -> {
            return new ModelAndView(null, "/sign-in.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sign-in/:incorrectPassword", (req, res) -> {
            boolean incorrectPassword = Boolean.parseBoolean(req.params("incorrectPassword"));

            Map<String, Object> model = new HashMap<>();
            model.put("incorrectPassword", incorrectPassword);

            return new ModelAndView(model, "/sign-in.hbs");
        }, new HandlebarsTemplateEngine());

//        TODO: change for the session
        get("/categories", (req, res) -> {
            return new ModelAndView(null, "/categories.hbs");
        }, new HandlebarsTemplateEngine());

        get("/weekly-plan", (req, res) -> {
            return new ModelAndView(null, "/weeklyPlan.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-up-form", (req, res) -> {
            String username = req.queryParams("username");
            String email = req.queryParams("email");
            String password = req.queryParams("password");
            User user = new User(username, email, password);
            userDAO.addUser(user);
            res.redirect("/sign-in");
            return null;
        });

        post("/sign-in-form", (req, res) -> {
           String email = req.queryParams("email");
           String password = req.queryParams("password");
           User user = new User(email, password);
           boolean correctPassword = userDAO.checkPassword(user);

           if (correctPassword){
               req.session(true);
               req.session().attribute("email", email);
               res.redirect("/");
           }else{
               res.redirect("/sign-in/true");
           }
           return null;
        });


}
}
