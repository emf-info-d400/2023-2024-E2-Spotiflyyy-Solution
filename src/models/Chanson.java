package models;

import java.text.DecimalFormat;
import services.serviceCalculDuree;

public class Chanson {
    String interprete;
    String titre;
    int duree;

    public Chanson(String interprete, String titre, int duree) {
        this.interprete = interprete;
        this.titre = titre;
        this.duree = duree;
    }

    @Override
    public String toString() {
        DecimalFormat formateur = new DecimalFormat("00");
        return interprete + " - " + titre + ", " + serviceCalculDuree.calculeMinutesEntieres(duree) + ":"
                + formateur.format(serviceCalculDuree.calculeResteSecondes(duree));
    }

    public String getInterprete() {
        return interprete;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }

}
