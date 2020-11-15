package model;

import java.time.LocalDateTime;
import java.util.List;

public class Recipe {

    private int id;
    private String title;
    private LocalDateTime timeDate;
    private String instructions;
    private double numPortions;
    private double timeToPrepare;
    private boolean isFavorite;
    private int userId;
//    private List<Ingredient> ingredients;
    private List<Category> categories;

    public Recipe(int id, String instructions){
        this.id = id;
        this.instructions = instructions;
    }
    public Recipe(int id, String instructions, int userId){
        this.id = id;
        this.instructions = instructions;
        this.userId = userId;
    }


    public Recipe(String instructions, int userId){
        this.instructions = instructions;
        this.userId = userId;
    }

    public Recipe(String title) {
        this.title = title;
    }

    public Recipe(int id, String title, LocalDateTime timeDate, String instructions, double numPortions, double timeToPrepare, boolean isFavorite, int userId) {
        this.id = id;
        this.title = title;
        this.timeDate = timeDate;
        this.instructions = instructions;
        this.numPortions = numPortions;
        this.timeToPrepare = timeToPrepare;
        this.isFavorite = isFavorite;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(LocalDateTime timeDate) {
        this.timeDate = timeDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public double getNumPortions() {
        return numPortions;
    }

    public void setNumPortions(double numPortions) {
        this.numPortions = numPortions;
    }

    public double getTimeToPrepare() {
        return timeToPrepare;
    }

    public void setTimeToPrepare(double timeToPrepare) {
        this.timeToPrepare = timeToPrepare;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", timeDate=" + timeDate +
                ", instructions='" + instructions + '\'' +
                ", numPortions=" + numPortions +
                ", timeToPrepare=" + timeToPrepare +
                ", isFavorite=" + isFavorite +
                ", userId=" + userId +
                '}';
    }
}

