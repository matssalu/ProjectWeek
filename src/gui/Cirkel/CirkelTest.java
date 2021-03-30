package gui.Cirkel;

import gui.Punt.Punt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CirkelTest {
    private Punt geldigeMiddelpunt;
    private int geldigeStraal;
    private Punt nullMiddelpunt;
    private int negatieveStraal;
    private int nulstraal;
    private Punt zelfdeMiddelpunt;
    private Punt andereMiddelpunt;
    private int andereStraal;
    private int zelfdeStraal;


    @Before
    public void setUp() {
        this.geldigeMiddelpunt = new Punt(5, 10);
        this.geldigeStraal = 5;
        this.nullMiddelpunt = null;
        this.negatieveStraal = -5;
        this.nulstraal = 0;
        this.zelfdeMiddelpunt = new Punt(5, 10);
        this.andereMiddelpunt = new Punt(6, 11);
        this.zelfdeStraal = 5;
        this.andereStraal = 8;
    }

    @Test(expected = IllegalArgumentException.class)
    public void cirkel_aanmaken_met_middelpunt_null_Gooit_IllegalargumentException() {
        new Cirkel(null, geldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cirkel_aanmaken_met_straal_negatief_Gooit_IllegalargumentException() {
        new Cirkel(geldigeMiddelpunt, negatieveStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cirkel_aanmaken_met_straal_nul_Gooit_IllegalargumentException() {
        new Cirkel(geldigeMiddelpunt, nulstraal);
    }



    @Test
    public void test_Cirkel_geldigeMiddelpunt_geldigeStraal_object() {
        Cirkel cirkel = new Cirkel(geldigeMiddelpunt, geldigeStraal);
        Assert.assertEquals(geldigeMiddelpunt, cirkel.getMiddelpunt());
        assertEquals(geldigeStraal,cirkel.getRadius(),0.01);
    }

    @Test
    public void zeflde_midden_en_straal_is_anders_object() {
        Cirkel cirkel1 = new Cirkel(geldigeMiddelpunt, geldigeStraal);
        Cirkel cirkel2 = new Cirkel(andereMiddelpunt, andereStraal);
        assertFalse(cirkel1.equals(cirkel2));
    }

    @Test
    public void andermiddenstraal_is_anders_object() {
        Cirkel cirkel1 = new Cirkel(geldigeMiddelpunt, geldigeStraal);
        Cirkel cirkel2 = null;
        assertFalse(cirkel1.equals(cirkel2));
    }

    @Test
    public void anderemiddelpunt_is_anders_object() {
        Cirkel cirkel1 = new Cirkel(geldigeMiddelpunt, geldigeStraal);
        Cirkel cirkel2 = new Cirkel(andereMiddelpunt, geldigeStraal);
        assertFalse(cirkel1.equals(cirkel2));
    }

    @Test
    public void anderestraal_is_anders_object() {
        Cirkel cirkel1 = new Cirkel(geldigeMiddelpunt, geldigeStraal);
        Cirkel cirkel2 = new Cirkel(geldigeMiddelpunt, andereStraal);
        assertFalse(cirkel1.equals(cirkel2));
    }

}
