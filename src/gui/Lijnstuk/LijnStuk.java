package gui.Lijnstuk;
import gui.Punt.Punt;

public class LijnStuk {

    private Punt startPunt;
    private Punt eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        setStartEinde(startPunt, eindPunt);
        setStartPunt(startPunt);
        setEindpunt(eindPunt);
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
        if(startPunt == null || eindPunt == null || startPunt.toString() == eindPunt.toString()) throw new IllegalArgumentException("Punten mogen niet gelijk aan elkaar zijn!");
    }

    public Punt getStartPunt() {
        return this.startPunt;
    }

    public Punt getEindPunt() {
        return this.eindPunt;
    }

    public boolean equals(LijnStuk andere){
        if(this == andere) return true;
        return false;
    }

    public String toString(){
        return "Lijn: (" + startPunt.getX() + ", " + startPunt.getY() + ") - eindpunt: (" + eindPunt.getX() + ", " + eindPunt.getY() + ")";
    }
}
