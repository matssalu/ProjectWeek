package domain.Rechthoek;

import domain.Omhullende.Omhullende;
import domain.Punt.Punt;
import domain.Vorm.Drawable;
import domain.Speler.Vorm;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Rechthoek extends Vorm implements Drawable{
    private int breedte;
    private int hoogte;
    private Punt linkerBovenHoek;

    public Rechthoek(Punt linkerBovenHoek, int breedte, int hoogte){
        if(linkerBovenHoek == null)throw new DomainException("error");
        if(breedte <= 0)throw new DomainException("error");
        if(hoogte <= 0)throw new DomainException("error");
        this.linkerBovenHoek = linkerBovenHoek;
        this.breedte = breedte;
        this.hoogte = hoogte;

    }


    public int getBreedte(){
        return breedte;
    }
    public int getHoogte(){
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenHoek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return breedte == rechthoek.breedte && hoogte == rechthoek.hoogte && Objects.equals(linkerBovenHoek, rechthoek.linkerBovenHoek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedte, hoogte, linkerBovenHoek);
    }

    @Override
    public String toString() {
        return "Rechthoek: linkerbovenhoek: (" + this.linkerBovenHoek.getX() + ", " + this.linkerBovenHoek.getY() +
        ") - breedte: " + this.breedte + " - hoogte: " + this.hoogte;
    }

    @Override
    public Punt getMiddelPunt() {
        return null;
    }

    public Omhullende getOmhullende(){
        Omhullende a = new Omhullende(linkerBovenHoek,breedte,hoogte);
        return a;
    }

    @Override
    public void teken(Pane root) {
        Rechthoek r = new Rechthoek(getLinkerBovenhoek(), getBreedte(), getHoogte());
        Rectangle rectangle = new Rectangle(r.getLinkerBovenhoek().getX(), r.getLinkerBovenhoek().getY(), r.getBreedte(), r.getHoogte());
        rectangle.setFill(this.getKleur());
        rectangle.setStroke(Color.BLACK);
        root.getChildren().add(rectangle);
    }
}