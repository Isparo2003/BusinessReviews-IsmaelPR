package data;

import java.util.Arrays;

public class Garage extends Business{
    private float pph;

    public Garage(String name, String location, Review[] reviews, int pph) {
        super(name, location, reviews);
        this.pph = pph;
    }

    @Override
    public String toString() {
        return "Garage " + name + " ( " + location + " ) - " + pph + " eur/h" + '\n'+"-Average: "+ reviewAverage() + " /5";
    }

    public float getPph() {
        return pph;
    }

    public void setPph(float pph) {
        this.pph = pph;
    }
}
