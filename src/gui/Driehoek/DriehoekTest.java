package gui.Driehoek;

import static org.junit.Assert.*;

import gui.Driehoek.DomainException;
import gui.Punt.Punt;

import org.junit.Test;

public class DriehoekTest {
    private Punt punt1 = new Punt(10, 20);
    private Punt zelfdeAlsPunt1 = new Punt(10, 20);
    private Punt verschillendVanPunt1 = new Punt(15, 20);
    private Punt punt2 = new Punt(20, 40);
    private Punt zelfdeAlsPunt2 = new Punt(20, 40);
    private Punt verschillendVanPunt2 = new Punt(40, 20);
    private Punt punt3 = new Punt(190, 30);
    private Punt zelfdeAlsPunt3 = new Punt(190, 30);
    private Punt verschillendVanPunt3 = new Punt(120, 100);

    private Punt puntA = new Punt(10, 20);
    private Punt puntB = new Punt(10, 30);
    private Punt puntC = new Punt(10, 40);

    private Punt puntF = new Punt(1, 5);
    private Punt puntE = new Punt(6, 11);
    private Punt puntD = new Punt(12, 20);
    private boolean temp2;

    @Test
    public void Driehoek_moet_DrieHoek_aanmaken_met_gegeven_hoekpunten() {
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);

        assertEquals(punt1, drieHoek.getHoekPunt1());
        assertEquals(punt2, drieHoek.getHoekPunt2());
        assertEquals(punt3, drieHoek.getHoekPunt3());
    }

    @Test (expected = DomainException.class)
    public void Driehoek_Moet_exception_gooien_als_hoekpunt1_null()  {
        new Driehoek(null, punt2, punt3);
    }

    @Test (expected = DomainException.class)
    public void Driehoek_Moet_exception_gooien_als_hoekpunt2_null()  {
        new Driehoek(punt1, null, punt3);
    }

    @Test (expected = DomainException.class)
    public void DrieHoek_Moet_exception_gooien_als_hoekpunt3_null()  {
        new Driehoek(punt1, punt2, null);
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoekPunt1_verschillend(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        Driehoek andereDriehoek = new Driehoek(verschillendVanPunt1, zelfdeAlsPunt2, zelfdeAlsPunt3);
        assertFalse(drieHoek.equals(andereDriehoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoekPunt2_verschillend(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, verschillendVanPunt2, zelfdeAlsPunt3);
        assertFalse(drieHoek.equals(andereDriehoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoekPunt3_verschillend(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, zelfdeAlsPunt2, verschillendVanPunt3);
        assertFalse(drieHoek.equals(andereDriehoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        assertFalse(drieHoek.equals(null));
    }

    @Test
    public void drie_punten_liggen_op_1_lijn_geeft_true(){
        Driehoek drieHoek = new Driehoek(puntA, puntB, puntC);
        assertTrue(drieHoek.liggenOp1Lijn(puntA,puntB,puntC));
    }

    @Test
    public void drie_punten_liggen_niet_op_1_lijn_geeft_false(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        assertFalse(drieHoek.liggenOp1Lijn(punt1,punt2,punt3));
    }

    @Test
    public void orderen_drie_punten_test_false(){
        Driehoek drieHoek = new Driehoek(puntD, puntE, puntF);
        String temp = puntF.getX() + ", " + puntF.getY() + "\n" + puntE.getX() + ", " + puntE.getY() + "\n" + puntD.getX() + ", " + puntD.getY();
        temp2 = false;
        if(drieHoek.sorteerHoekPunten() == temp) temp2 = true;
        assertFalse(temp2);
    }
}