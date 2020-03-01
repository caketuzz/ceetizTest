package com.caketuzz.model;

import com.caketuzz.model.Societe;
import com.caketuzz.model.TresorPublic;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TresorPublicTest {

    TresorPublic tresorPublic;
    @Before
    public void setUp() throws Exception {
        tresorPublic = TresorPublic.getInstance();
    }

    @Test
    public void getInstance() {
        assertNotNull("Le Tresor Public doit exister !");
        assertEquals("Le Trésor Public est toujours le même", tresorPublic, TresorPublic.getInstance());
    }

    @Test
    public void addSociete() {
        Societe[] societes = Societe.loadData("societes_test.json");

        tresorPublic.addSociete(societes[0]);
        assertEquals(504.875, tresorPublic.calculImpots(2019), 0.001d);
    }



    @Test
    public void getGreeting() {
        assertNotNull("le Trésor Public dit bonjour", tresorPublic.getGreeting());
    }
}