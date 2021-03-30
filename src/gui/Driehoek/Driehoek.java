package gui.Driehoek;

import gui.Punt.Punt;
import gui.Vorm.Vorm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Driehoek extends Vorm {

    private Punt punt1;
    private Punt punt2;
    private Punt punt3;

    public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
        if(punt1 == null || punt2 == null || punt3 == null) throw new DomainException("punten mogen niet null zijn!");
        this.punt1 = punt1;
        this.punt2 = punt2;
        this.punt3 = punt3;
    }

    public Punt getHoekPunt1() {
        return this.punt1;
    }

    public Punt getHoekPunt2() {
        return this.punt2;
    }

    public Punt getHoekPunt3() {
        return this.punt3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driehoek driehoek = (Driehoek) o;
        return Objects.equals(punt1, driehoek.punt1) && Objects.equals(punt2, driehoek.punt2) && Objects.equals(punt3, driehoek.punt3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(punt1, punt2, punt3);
    }

    public String toString(){
        return "Driehoek: hoekpunt1: (" + punt1.getY() + ", " + punt1.getY() + ") hoekpunt2: (" + punt2.getY() + ", " + punt2.getY() + ")" +
                " hoekpunt3: (" + punt3.getY() + ", " + punt3.getY() + ")";
    }


    public boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3){
        int links = (punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY());
        int rechts = (punt3.getX() - punt1.getX()) * (punt2.getY() - punt1.getY());

        if(links == rechts) return true;
        return false;
    }

    public String sorteerHoekPunten(){
        ArrayList<Punt> punten = new ArrayList<>();
        punten.add(punt1);
        punten.add(punt2);
        punten.add(punt3);
        Collections.sort(punten);
        this.punt1 = punten.get(0);
        this.punt2 = punten.get(1);
        this.punt3 = punten.get(2);
        return punt1.getX() + ", " + punt1.getY() + "\n" + punt2.getX() + ", " + punt2.getY() + "\n" + punt3.getX() + ", " + punt3.getY();
    }
}
