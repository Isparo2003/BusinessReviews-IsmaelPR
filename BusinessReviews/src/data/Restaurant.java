package data;

import java.util.Arrays;

public class Restaurant extends Business{
    private String food_type;

    public Restaurant(String name, String location, Review[] reviews, String food_type) {
        super(name, location, reviews);
        this.food_type = food_type;
    }

    @Override
    public String toString() {
        return "Restaurant " + name + " ( " + location + " ) - " + food_type + '\n'+ "-Average: "+ reviewAverage() + " /5";
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }
}
