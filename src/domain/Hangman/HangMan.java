package domain.Hangman;

import domain.HintWoord.HintWoord;
import domain.Speler.Speler;
import domain.Tekening.DomainException;
import domain.Tekening.TekeningHangMan;
import domain.WoordenLijst.WoordenLijst;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekening;
    private WoordenLijst woordenLijst;
    private HintWoord hint;
    private boolean gewonnen;

    public HangMan(Speler speler, WoordenLijst woordenLijst) {
        if (speler == null || woordenLijst == null) { throw new DomainException("foute input"); }
        else if (woordenLijst.getAantalWoorden() == 0) { throw new DomainException("lijst is leeg"); }

        this.gewonnen = false;
        this.speler = speler;
        this.woordenLijst = woordenLijst;
        this.tekening = new TekeningHangMan();
        this.hint = new HintWoord(woordenLijst.getRandomWoord());
    }

    public Speler getSpeler() { return speler; }

    public TekeningHangMan getTekening() { return tekening; }

    public String getHint() { return this.hint.toString(); }

    public boolean raad(char charr) {
        boolean success = this.hint.raad(charr);
        if (!success) {
            try {
                this.tekening.zetVolgendeZichtbaar();
            }
            catch (DomainException exception) {
                exception.printStackTrace();
            }
        }
        this.gewonnen = isGewonnen();
        return success;
    }

    public boolean isGameOver() {
        return this.tekening.getAantalOnzichtbaar() == 0;
    }

    public boolean isGewonnen() { return this.hint.isGeraden(); }
}
