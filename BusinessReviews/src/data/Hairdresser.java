package data;

import java.util.Arrays;

public class Hairdresser extends Business{
    Boolean unisex ;

    public Hairdresser(String name, String location, Review[] reviews, Boolean unisex) {
        super(name, location, reviews);
        this.unisex = unisex;
    }

    @Override
    public String toString() {
        //I use the unisex variable to write the to string
        if ( unisex ) { return "Hairdresser " + name + " ( " + location + " ) - " + " unisex" + '\n' + "-Average: "+ reviewAverage() + " /5"; }
        else return "Hairdresser " + name + " ( " + location + " ) - " + "not unisex" + '\n' + "-Average: "+ reviewAverage()  + " /5";
    }

    public Boolean getUnisex() {
        return unisex;
    }

    public void setUnisex(Boolean unisex) {
        this.unisex = unisex;
    }
}
