package com.caketuzz.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SASTest {

    @Test
    public void testConstructor(){
        SAS soc = new SAS("denom", "SIRET", "siege soc", "ressources");
        assertEquals("denom", soc.getDenomination());
        assertEquals("SIRET", soc.getSIRET());
        assertEquals("siege soc", soc.getAdresseSiegeSocial());
    }

}