package models;

import services.serviceCalculDuree;

public class Album {
    String titre;
    String interprete;
    Chanson[] chansons;

    public Album(String titre, String interprete, Chanson[] chansons) {
        this.titre = titre;
        this.interprete = interprete;
        this.chansons = chansons;
    }

    public int getDureeTotale() {
        int dureeTotale = 0;

        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i] != null) {
                dureeTotale += chansons[i].getDuree();
            }
        }
        return dureeTotale;

    }

    public Chanson trouverChansonParTitre(String titre) {
        Chanson resultat = null;
        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i].getTitre() == titre) {
                resultat = chansons[i];
                break;
            }
        }
        return resultat;
    }

    public int getDureeLaPlusLongue() {
        int dureeMax = 0;

        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i] != null && chansons[i].getDuree() > dureeMax) {
                dureeMax = chansons[i].getDuree();
            }
        }
        return dureeMax;

    }

    public Chanson chansonAleatoire() {
        int indexAleatoire = (int) Math.random() * (chansons.length + 1);
        return chansons[indexAleatoire];
    }

    @Override
    public String toString() {
        return titre + " par " + interprete + " : " + chansons.length + " titres, durée "
                + serviceCalculDuree.calculeMinutesEntieres(getDureeTotale()) + " minutes et "
                + serviceCalculDuree.calculeResteSecondes(getDureeTotale()) + " secondes";
    }

    public String getTitre() {
        return titre;
    }

    public String getInterprete() {
        return interprete;
    }

    public Chanson[] getChansons() {
        return chansons;
    }

}
