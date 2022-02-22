package data;

import java.util.Arrays;

public abstract class Business {
    protected String name;
    protected String location;
    public Review[] reviews = new Review[2] ;

    public Business(String name, String location, Review[] reviews) {
        this.name = name;
        this.location = location;
        this.reviews = reviews;
    }

    public float reviewAverage (){
        //The average needs to be a float
        float average = 0 ;
        for ( int i = 0 ; i < reviews.length ; i++ ){
            average += reviews[i].getRating();
        }
        average /= reviews.length;
        return average ;
    }

    @Override
    public String toString() {
        return "->"+ name + "( "+ location + " )" +
                " review average=" + reviewAverage();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }

}
