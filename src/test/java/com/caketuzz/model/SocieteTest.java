package com.caketuzz.model;

import com.caketuzz.model.Societe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SocieteTest {

    Societe[] societes;

    @Before
    public void setUp() throws Exception {
        societes = Societe.loadData("societes_test.json");
    }

    @Test
    public void calculImpot() {
        assertEquals(
                504.875, societes[0].calculImpot(2019), 0.001);
        assertEquals(
                330000, societes[1].calculImpot(2019), 0.001);
    }

    @Test
    public void loadData() {
        societes = Societe.loadData("societesssss_test.json");
        assertNull("Les sociétés ne devraient pas exister dans ce fichier", societes);

        societes = Societe.loadData("societes_test.json");
        assertNotNull("Les sociétés existent dans ce fichier", societes);
    }

    @Test
    public void getExerciceComptableByAnnee() {
        assertNotNull("la société existait en 2019", societes[0].getExerciceComptableByAnnee(2019));
        assertNull("la société n'existait pas en 2017", societes[0].getExerciceComptableByAnnee(2017));
    }

    @Test
    public void getDenomination() {
        assertEquals("Denomination correspond", "Emmanuel TestNitz Consulting", societes[0].getDenomination());
    }

    @Test
    public void getSIRET() {
        assertEquals("SIRET correspond", "123456788901234", societes[0].getSIRET());
    }

    @Test
    public void getAdresseSiegeSocial() {
        assertNull("Adresse n'existe pas", societes[0].getAdresseSiegeSocial());
        assertNotNull("Adresse existe", societes[1].getAdresseSiegeSocial());
    }
}