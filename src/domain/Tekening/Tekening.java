package domain.Tekening;

import domain.Omhullende.Omhullende;
import domain.Vorm.Drawable;
import domain.Vorm.Vorm;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tekening implements Drawable {
    private final String naam;
    private List<Vorm> vormen;

    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;

    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;

    public Tekening(String naam) {
        if (!isValidNaam(naam)) throw new IllegalArgumentException();
        this.naam = naam;

        this.vormen = new ArrayList<>();
    }

    public static boolean isValidNaam(String naam) {
        return naam != null && !naam.trim().isEmpty();
    }

    public void voegToe(Vorm vorm) {
        if(vorm == null) return;
        Omhullende temp = vorm.getOmhullende();

        if (vorm.getOmhullende().getMinimumX() < MIN_X
                || vorm.getOmhullende().getMinimumY() < MIN_Y
                || vorm.getOmhullende().getMaximumX() > MAX_X
                || vorm.getOmhullende().getMaximumY() > MAX_Y) {
            throw new DomainException("Vorm valt buiten tekening");
        } vormen.add(vorm);
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalVormen() {
        return this.vormen.size();
    }

    public void verwijder(Vorm vorm) {
        this.vormen.remove(vorm);
    }

    public Vorm getVorm(int index) {
        return this.vormen.get(index);
    }

    public boolean bevat(Vorm vorm) {
        return this.vormen.stream().anyMatch(vorm1 -> vorm1 == vorm);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tekening)) return false;
        Tekening tekening = (Tekening) o;
        return this.getAantalVormen() == tekening.getAantalVormen() && this.checkVormPerVorm(tekening);
    }

    private boolean checkVormPerVorm(Tekening tekening) {
        for (Vorm vorm : vormen) {
            if (!tekening.bevat(vorm)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tekening{" +
                "naam='" + naam + '\'' +
                ", vormen=" + vormen +
                '}';
    }

    @Override
    public void teken(Pane root) {
        vormen.forEach(x -> x.teken(root));
    }
}