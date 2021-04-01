package domain.Lijnstuk;
import domain.Omhullende.Omhullende;
import domain.Punt.Punt;
import domain.Vorm.Drawable;
import domain.Speler.Vorm;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import java.util.Objects;
import javafx.scene.paint.Color;

public class LijnStuk extends Vorm implements Drawable {

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
        return "Lijn: startpunt: (" + startPunt.getX() + ", " + startPunt.getY() + ") - eindpunt: (" + eindPunt.getX() + ", " + eindPunt.getY() + ")";
    }

    @Override
    public Punt getMiddelPunt() {
        return null;
    }

    public Omhullende getOmhullende(){
        Punt punt= new Punt(Math.min(startPunt.getX(),eindPunt.getX()), Math.min(startPunt.getY(),eindPunt.getY()));
        Omhullende a = new Omhullende(punt,Math.abs((startPunt.getX()-eindPunt.getX())),Math.abs((startPunt.getY()-eindPunt.getY())));
        return a;
    }



    public void setStartEnEindPunt(Punt punt1, Punt punt2) {
        if (punt1 == punt2 || punt1 == null || punt2 == null)
            throw new DomainException("error");

        this.startPunt = punt1;
        this.eindPunt = punt2;
    }

    @Override
    public void teken(Pane root) {
        LijnStuk l = new LijnStuk(startPunt, eindPunt);
        Line line = new Line(l.getStartPunt().getX(), l.getStartPunt().getY(), l.getEindPunt().getX(), l.getEindPunt().getY());
        line.setFill(Color.BLUE);
        root.getChildren().add(line);
    }
}
