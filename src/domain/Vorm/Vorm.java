package domain.Vorm;
import domain.Omhullende.Omhullende;
import domain.Punt.Punt;
import javafx.scene.paint.Color;

public abstract class Vorm  implements Drawable {
    private Color kleur;
    private boolean isZichtbaar;


    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public boolean isZichtbaar(){
        return isZichtbaar;
    }

    public abstract Omhullende getOmhullende();

    public void setZichtbaar(boolean zichtbaar){
        this.isZichtbaar = zichtbaar;
    }

    @Override
    public String toString() {
        return "Vorm{" +
                "kleur=" + kleur +
                '}';
    }

    public abstract Punt getMiddelPunt();
}
