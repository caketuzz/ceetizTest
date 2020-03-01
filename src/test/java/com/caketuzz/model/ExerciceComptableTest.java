package com.caketuzz.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciceComptableTest {

    @Test
    public void testMe(){
        ExerciceComptable ex = new ExerciceComptable();
        ex.setAnnee(2020);
        ex.setBenefices(1000);
        ex.setCharges(200);
        ex.setChiffreDAffaire(1200);
        assertEquals("Exercice comptable annee", 2020, ex.getAnnee());
        assertEquals( 1000, ex.getBenefices(), 0.001d);
        assertEquals(200, ex.getCharges(), 0.001d);
        assertEquals(1200, ex.getChiffreDAffaire(), 0.001d);

        assertNotNull(ex.toString());

    }

}