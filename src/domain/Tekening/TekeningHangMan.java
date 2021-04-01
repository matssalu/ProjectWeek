package domain.Tekening;

import domain.Cirkel.Cirkel;
import domain.Lijnstuk.LijnStuk;
import domain.Punt.Punt;
import domain.Rechthoek.Rechthoek;
import domain.Speler.Vorm;

public class TekeningHangMan extends Tekening {

    private int aantalOnzichtbaar;

    public TekeningHangMan() {
        super("HangMan");

        setUpVormen();

        this.aantalOnzichtbaar = this.getAantalVormen() - 4;
    }

    private void setUpVormen() {
        Vorm galgBodem = new Rechthoek(new Punt(10,350), 300,40);
        galgBodem.setZichtbaar(true);
        this.voegToe(galgBodem);
        Vorm galgStaaf = new LijnStuk(new Punt(160,350), new Punt(160, 50));
        galgStaaf.setZichtbaar(true);
        this.voegToe(galgStaaf);
        Vorm hangbar = new LijnStuk(new Punt(160,50), new Punt(280,50));
        hangbar.setZichtbaar(true);
        this.voegToe(hangbar);
        Vorm koord = new LijnStuk(new Punt(280,50), new Punt(280,100));
        koord.setZichtbaar(true);
        this.voegToe(koord);

        // Zichtbaar na 1 fout
        Vorm hoofd = new Cirkel(new Punt(280,125), 25);
        this.voegToe(hoofd);
        // Zichtbaar na 2 fouten
        Vorm oogLinks = new Cirkel(new Punt(270,118), 2);
        this.voegToe(oogLinks);
        // Zichtbaar na ... fouten
        Vorm oogRechts = new Cirkel(new Punt(290,118),2);
        this.voegToe(oogRechts);
        Vorm neus = new Cirkel(new Punt(280,128), 2);
        this.voegToe(neus);
        Vorm mond = new LijnStuk(new Punt(270,138), new Punt(290,138));
        this.voegToe(mond);
        Vorm lijf = new LijnStuk(new Punt(280,150), new Punt(280,250));
        this.voegToe(lijf);
        Vorm beenlinks = new LijnStuk(new Punt(280,250), new Punt(240,310));
        this.voegToe(beenlinks);
        Vorm beenRechts = new LijnStuk(new Punt(280,250), new Punt(320,310));
        this.voegToe(beenRechts);
        Vorm voetLinks = new Cirkel(new Punt(240,310), 5);
        this.voegToe(voetLinks);
        Vorm voetRechts = new Cirkel(new Punt(320,310), 5);
        this.voegToe(voetRechts);
        Vorm armLinks = new LijnStuk(new Punt(280,200), new Punt(230,170));
        this.voegToe(armLinks);
        Vorm armRechts = new LijnStuk(new Punt(280,200), new Punt(330, 170));
        this.voegToe(armRechts);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        this.voegToe(handLinks);
        Vorm handRechts = new Cirkel(new Punt(330,170), 5);
        this.voegToe(handRechts);



    }

    public int getAantalOnzichtbaar() {
        return this.aantalOnzichtbaar;
    }

    private int index = 4;
    public void zetVolgendeZichtbaar() throws DomainException {
        if (index <= this.getAantalVormen() -1) {
            this.getVorm(index++).setZichtbaar(true);
            this.aantalOnzichtbaar--;
        }
        else {
            throw new DomainException("Geen tekeningen meer");
        }
    }

    public void voegToe(Vorm vorm) {
        super.voegToe(vorm);
    }

    public void verwijder(Vorm vorm) { }


}