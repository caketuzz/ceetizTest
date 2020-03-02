package com.caketuzz.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public abstract class Societe {


    /* PRIVATE DATA */
    protected String denomination;
    protected String SIRET;
    protected String adresseSiegeSocial;

    public String getDenomination() {
        return denomination;
    }

    public String getSIRET() {
        return SIRET;
    }

    public String getAdresseSiegeSocial() {
        return adresseSiegeSocial;
    }

    /* PROTECTED DATA */
    protected ArrayList<ExerciceComptable> exercicesComptables;

    protected ExerciceComptable getExerciceComptableByAnnee(int annee){
        for (ExerciceComptable ex : exercicesComptables){
            if (ex.getAnnee() == annee)
                return ex;
        }
        return null;
    }

    /* PUBLIC METHODS */
    public Societe(String denomination, String SIRET, String adresseSiegeSocial, String dataResource){

        this.denomination = denomination;
        this.SIRET = SIRET;
        this.adresseSiegeSocial = adresseSiegeSocial;
    }

    public static Societe[] loadData(String resource) {
        Societe[] res = null;
        try {
            URL url = ClassLoader.getSystemClassLoader().getResource(resource);
            if (url == null)
                return null;
            String filename = url.getFile();
            File file = new File(filename);
            java.lang.reflect.Type collectionType = new TypeToken<ArrayList<Societe>>() {
            }.getType();

            RuntimeTypeAdapterFactory<Societe> typeAdapterFactory = RuntimeTypeAdapterFactory
                    .of(Societe.class, "type")
                    .registerSubtype(AutoEntreprise.class, "autoentreprise")
                    .registerSubtype(SAS.class, "sas")
                    ;

            Gson gson = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory)
                    .create();

            ArrayList<Societe> societes = gson.fromJson(new FileReader(file), collectionType);

            for (Societe s : societes){
                System.out.println(s.toString());
            }
            res = new Societe[societes.size()];
            res = societes.toArray(res);
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }

        return res;
    }

    /* PUBLIC ABSTRACT METHODS */
    public abstract double calculImpot(int annee);



}
