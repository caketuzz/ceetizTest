package com.caketuzz.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AutoEntrepriseTest {

    @Test
    public void testConstructor(){
        AutoEntreprise soc = new AutoEntreprise("denom", "SIRET", "siege soc", "ressources");
        assertEquals("denom", soc.getDenomination());
        assertEquals("SIRET", soc.getSIRET());
        assertEquals("siege soc", soc.getAdresseSiegeSocial());
    }

    @Test
    public void calculImpot() {
    }

    @Test
    public void testToString() {
    }
}