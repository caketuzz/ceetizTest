package com.caketuzz.model;

public class AutoEntreprise extends Societe {

    public AutoEntreprise(String denomination, String SIRET, String adresseSiegeSocial, String dataResource) {
        super(denomination, SIRET, adresseSiegeSocial, dataResource);
    }

    @Override
    public double calculImpot(int annee) {
        ExerciceComptable exerciceComptable = getExerciceComptableByAnnee(annee);
        return exerciceComptable.getChiffreDAffaire() * 0.25d;
    }

    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(denomination).append(" / ").
                append("autoentrepreneur").append(" / ").
                append(SIRET).append(" \n");
        b.append(exercicesComptables.toString()+"\n");
        return b.toString();
    }

}
