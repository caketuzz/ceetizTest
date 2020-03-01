package com.caketuzz.model;

public class ExerciceComptable {

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getChiffreDAffaire() {
        return chiffreDAffaire;
    }

    public void setChiffreDAffaire(double chiffreDAffaire) {
        this.chiffreDAffaire = chiffreDAffaire;
    }

    public double getBenefices() {
        return benefices;
    }

    public void setBenefices(double benefices) {
        this.benefices = benefices;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    private int annee;
    private double chiffreDAffaire;
    private double benefices;
    private double charges;

    @Override
    public String toString() {
        return "ExerciceComptable {" +
                "annee=" + annee +
                ", chiffreDAffaire=" + chiffreDAffaire +
                ", benefices=" + benefices +
                ", charges=" + charges +
                '}';
    }
}
