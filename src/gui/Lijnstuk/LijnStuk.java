package gui.Lijnstuk;
import gui.Punt.Punt;

import java.util.Objects;

public class LijnStuk {

    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        setStartPunt(startPunt);
        setEindpunt(eindPunt);
        setStartEinde(startPunt, eindPunt);
    }

    private void setStartPunt(Punt startPunt) {
        if(startPunt == null) throw new DomainException("startpunt mag niet null zijn!");
        this.startPunt = startPunt;
    }

    private void setEindpunt(Punt eindPunt) {
        if(eindPunt == null) throw new DomainException("eindpunt mag niet null zijn!");
        this.eindPunt = eindPunt;
    }

    private void setStartEinde(Punt startPunt, Punt eindPunt) {
        if(startPunt.equals(eindPunt)) throw new IllegalArgumentException("Punten mogen niet gelijk aan elkaar zijn!");
    }

    public Punt getStartPunt() {
        return this.startPunt;
    }

    public Punt getEindPunt() {
        return this.eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LijnStuk lijnStuk = (LijnStuk) o;
        return Objects.equals(startPunt, lijnStuk.startPunt) && Objects.equals(eindPunt, lijnStuk.eindPunt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPunt, eindPunt);
    }

    public String toString(){
        return "Lijn: (" + startPunt.getX() + ", " + startPunt.getY() + ") - eindpunt: (" + eindPunt.getX() + ", " + eindPunt.getY() + ")";
    }
}
