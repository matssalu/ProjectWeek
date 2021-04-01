package domain.Cirkel;

import domain.Omhullende.Omhullende;
import domain.Punt.Punt;
import domain.Vorm.Drawable;
import domain.Speler.Vorm;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cirkel extends Vorm implements Drawable {

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
        return "Cirkel: middelPunt: (" + this.middelpunt.getX() + ", " + this.middelpunt.getY() +") - straal: " + getRadius();
    }

    @Override
    public Punt getMiddelPunt() {
        return this.middelpunt;
    }

    public Omhullende getOmhullende(){
        int diameter = radius * 2;
        int puntX = middelpunt.getX() - radius;
        int puntY = middelpunt.getY() - radius;
        Punt punt= new Punt (puntX, puntY);
        Omhullende a = new Omhullende(punt,diameter,diameter);
        return a;
    }

    @Override
    public void teken(Pane root) {
        Cirkel c = new Cirkel(new Punt(middelpunt.getX(), middelpunt.getY()), radius);
        Circle circle = new Circle(c.getMiddelPunt().getX(), c.getMiddelPunt().getY(), c.getRadius());
        circle.setFill(this.getKleur());
        circle.setStroke(Color.BLACK);
        root.getChildren().add(circle);
    }
}
