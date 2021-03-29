package gui;

public class Cirkel {

    private Punt middelpunt;
    private int radius;

    public Cirkel(Punt middelpunt, int radius){
        setMiddelPunt(middelpunt);
        setRadius(radius);
    }

    public void setRadius(int radius) {
        if(radius < 0) throw new IllegalArgumentException("radius mag niet negatief zijn!");
        this.radius = radius;
    }

    public void setMiddelPunt(Punt middelpunt) {
        if(middelpunt.getX() < 0 || middelpunt.getY() < 0) throw new IllegalArgumentException("middelpunt mag niet negatief zijn!");
        this.middelpunt = middelpunt;
    }

    public Punt getMiddelpunt(){
        return this.middelpunt;
    }

    public int getRadius(){
        return this.radius;
    }

    public boolean equals(Cirkel andere){
        if(this == andere) return true;
        return false;
    }

    public String toString(){
        return "Cirkel met middelpunt (" + this.middelpunt.getX() + " , " + this.middelpunt.getY() +") en radius " + getRadius();
    }

}
