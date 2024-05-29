package models;

import services.serviceCalculDuree;

public class Playlist {
    String proprietaire;
    Chanson[] chansons;
    String nom;

    public Playlist(String nom, String proprietaire) {
        this.nom = nom;
        this.proprietaire = proprietaire;
        this.chansons = new Chanson[0];
    }

    public boolean ajouterChanson(Chanson chanson) {
        boolean reussite = false;

        if(!trouverChanson(chanson)){
            Chanson [] nouvellePlaylist = new Chanson[chansons.length+1];
            for (int i = 0; i < chansons.length; i++) {
                nouvellePlaylist[i]=chansons[i];
            }
            nouvellePlaylist[nouvellePlaylist.length-1]=chanson;
            chansons=nouvellePlaylist;
            reussite=true;
        }

        return reussite;
    }

    public boolean retirerChanson(Chanson chanson) {
        boolean reussite = false;
        
        if(trouverChanson(chanson)){
            Chanson [] nouvellePlaylist = new Chanson[chansons.length-1];
            int j=0;
            for (int i = 0; i < chansons.length; i++) {
                if(chansons[i]!=chanson)
                    nouvellePlaylist[j]=chansons[i];
                    j++;
            }
            chansons=nouvellePlaylist;
            reussite=true;
        }


        return reussite;
    }

    public boolean ajouterAlbum(Album album) {
        boolean resultat = false;
        Chanson[] chansonsAAjouter=album.getChansons();

        for (int i = 0; i < chansonsAAjouter.length; i++) {
            this.ajouterChanson(chansonsAAjouter[i]);
        }

        return resultat;
    }

    public boolean trouverChanson(Chanson chanson) {
        boolean resultat = false;
        // vérification que la chanson n'est pas encore dans la playlist
        for (int i = 0; i < chansons.length; i++) {
            if (chansons[i] == chanson) {
                resultat = true;
                break;
            }
        }
        return resultat;
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

    @Override
    public String toString() {
        return "Playlist \"" + nom + "\" crée par " + proprietaire + " : " + chansons.length + " titres, durée "
                + serviceCalculDuree.calculeMinutesEntieres(getDureeTotale()) + " minutes et " + serviceCalculDuree.calculeResteSecondes(getDureeTotale()) +  " secondes.";
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public Chanson[] getChansons() {
        return chansons;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

}
