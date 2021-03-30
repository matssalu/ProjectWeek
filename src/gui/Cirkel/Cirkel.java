package gui.Cirkel;

import gui.Punt.Punt;
import gui.Vorm.Vorm;

public class Cirkel extends Vorm {

    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt middelpunt, int radius){
        setMiddelPunt(middelpunt);
        setRadius(radius);
    }

    public void setRadius(int radius) {
        if(radius <= 0) throw new IllegalArgumentException("radius moet groter dan nul zijn!");
        this.radius = radius;
    }

    public void setMiddelPunt(Punt middelpunt) {
        if(middelpunt == null) throw new IllegalArgumentException("middelpunt mag niet negatief zijn!");
        this.middelpunt = middelpunt;
    }

    public Punt getMiddelpunt(){
        return this.middelpunt;
    }

    public int getRadius(){
        return this.radius;
    }

    public boolean equals(Cirkel andere){
        if(andere == null || this == null) return false;
        if(this.toString() == andere.toString()) return true;
        return false;
    }

    public String toString(){
        return "Cirkel: middelpunt: (" + this.middelpunt.getX() + ", " + this.middelpunt.getY() +") - straal: " + getRadius();
    }

}
