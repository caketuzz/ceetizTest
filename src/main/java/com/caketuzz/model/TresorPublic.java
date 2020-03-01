package com.caketuzz.model;

import java.util.ArrayList;

public class TresorPublic {

    // Pattern Singleton
    private static TresorPublic self;

    private TresorPublic(){}

    public static TresorPublic getInstance() {
        if (self == null)
            self = new TresorPublic();
        return self;
    }

    /* Private Data */
    private ArrayList<Societe> registreSocietes = new ArrayList<>();


    /* PUBLIC METHODS */
    public void addSociete(Societe societe){
        registreSocietes.add(societe);
    }

    public double calculImpots(int annee) {
        double res = 0d;
        double impots = 0d;
        for (Societe s : registreSocietes){
            impots = s.calculImpot(annee);
            System.out.println("l'impot pour l'exercice " + annee + " de la société " + s.getDenomination() +
                    " se monte à " + impots + "€");
            res+=impots;
        }
        return res;
    }


    public String getGreeting() {
        return "Bienvenue au Trésor Public";
    }
}
