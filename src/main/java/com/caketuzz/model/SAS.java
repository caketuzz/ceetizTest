package com.caketuzz.model;

public class SAS extends Societe {

    public SAS(String denomination, String SIRET, String adresseSiegeSocial, String dataResource) {
        super(denomination, SIRET, adresseSiegeSocial, dataResource);
    }

    @Override
    public double calculImpot(int annee) {
        ExerciceComptable exerciceComptable = getExerciceComptableByAnnee(annee);
        return exerciceComptable.getChiffreDAffaire() * 0.33d;
    }


    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(denomination).append(" / ").
                append("SAS").append(" / ").
                append(SIRET).append(" / ").
                append(adresseSiegeSocial).append("\n");
        b.append(exercicesComptables.toString() + "\n");
        return b.toString();
    }
}
