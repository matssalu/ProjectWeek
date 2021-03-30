package gui.Tekening;

import gui.Vorm.Vorm;

import java.util.ArrayList;
import java.util.Objects;

public class Tekening {
    private String naam;
    private ArrayList<Vorm> vormen;
    public int MIN_X;
    public int MAX_X;
    public int MIN_Y;
    public int MAX_Y;

    public Tekening(String naam){
        if (naam == null) throw new IllegalArgumentException("de tekening moet een naam hebben");
        if (naam.contains(" "))throw new IllegalArgumentException("in de naam mogen er geen spaties staan");
        if (vormen > 0) throw new IllegalArgumentException("er mogen nog geen vormen gegeven zijn");
        this.vormen = vormen;
        this.naam = naam;

    }
    public boolean isValidNaam(String naam){
        if(naam == null)
        return false;

        return true;
    }

    public String getNaam() {
        return this.naam;
    }

    public void voegToe(Vorm vormen) {

    }

    public Vorm getVorm(int vormen){

    }

    public int getAantalVormen() {
        return vormen;
    }

    public void verwijder(Vorm vormen) {

    }

    public boolean bevat(Vorm vormen) {
        if()
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tekening tekening = (Tekening) o;
        return MIN_X == tekening.MIN_X && MAX_X == tekening.MAX_X && MIN_Y == tekening.MIN_Y && MAX_Y == tekening.MAX_Y && Objects.equals(naam, tekening.naam) && Objects.equals(vormen, tekening.vormen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, vormen, MIN_X, MAX_X, MIN_Y, MAX_Y);
    }

    @Override
    public String toString() {
        return "Tekening{" +
                "naam='" + naam + '\'' +
                ", vormen=" + vormen +
                ", MIN_X=" + MIN_X +
                ", MAX_X=" + MAX_X +
                ", MIN_Y=" + MIN_Y +
                ", MAX_Y=" + MAX_Y +
                '}';
    }
}
