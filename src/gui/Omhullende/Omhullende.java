package gui.Omhullende;

import gui.Punt.Punt;
import gui.Rechthoek.DomainException;

public class Omhullende {

    private Punt positieLinksBoven;
    private int breedte, hoogte;
    private Omhullende omhullende;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
        if(positieLinksBoven == null)throw new gui.Rechthoek.DomainException("error");
        if(breedte <= 0)throw new gui.Rechthoek.DomainException("error");
        if(hoogte <= 0)throw new DomainException("error");
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

}
