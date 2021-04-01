package domain.Omhullende;

import domain.Punt.Punt;

import java.util.Objects;

public class Omhullende {

    private Punt positieLinksBoven;
    private int breedte, hoogte;
    private Omhullende omhullende;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
        if(positieLinksBoven == null)throw new DomainException("error");
        if(breedte < 0)throw new DomainException("error");
        if(hoogte < 0)throw new DomainException("hoogte mag niet negatief zijn");
        this.positieLinksBoven = positieLinksBoven;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return this.positieLinksBoven;
    }

    public int getHoogte() {
        return this.hoogte;
    }

    public int getBreedte() {
        return this.breedte;
    }

    public int getMinimumX(){
        return positieLinksBoven.getX();
    }

    public int getMaximumX(){
        return positieLinksBoven.getX() + breedte;
    }

    public int getMinimumY(){
        return positieLinksBoven.getY();
    }

    public int getMaximumY(){
        return positieLinksBoven.getY() + hoogte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Omhullende that = (Omhullende) o;
        return breedte == that.breedte && hoogte == that.hoogte && Objects.equals(positieLinksBoven, that.positieLinksBoven) && Objects.equals(omhullende, that.omhullende);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positieLinksBoven, breedte, hoogte, omhullende);
    }

    public String toString(){
        return "Omhullende: " + getLinkerBovenhoek().toString() + " - " + getBreedte() + " - " + getHoogte();
    }
}
