package app;
import models.Album;
import models.Chanson;
import models.Playlist;
import services.serviceCalculDuree;

public class App {
    public static void main(String[] args) throws Exception {
        Album[] bibliotheque;
        Playlist[] playlists = new Playlist[5];

        //1er album
        String artiste1= "Lady Gaga"; 
        Chanson[] pistes1 = new Chanson[3];
        pistes1[0]= new Chanson(artiste1, "Just Dance", serviceCalculDuree.calculeDureeSecondes(4,2)); 
        pistes1[1]= new Chanson(artiste1, "Poker Face", serviceCalculDuree.calculeDureeSecondes(3,59)); 
        pistes1[2]= new Chanson(artiste1, "Paparazzi", serviceCalculDuree.calculeDureeSecondes(3,28)); 
        Album album1=new Album("The Fame", artiste1, pistes1);


        //2e album
        String artiste2= "PSY";
        Chanson[] pistes2 = new Chanson[1];
        pistes2[0]= new Chanson(artiste2, "Gangnam Style", serviceCalculDuree.calculeDureeSecondes(3,39)); 
        Album album2=new Album("Psy 6", artiste2, pistes2);
    
        //3e Album
        String artiste3= "Nemo";
        Chanson[] pistes3 = new Chanson[1];
        pistes3[0]= new Chanson(artiste3, "The Code", serviceCalculDuree.calculeDureeSecondes(3,30)); 
        Album album3=new Album("The Code", artiste3, pistes3);
    
        //Création de la bibliothèque
        bibliotheque=new Album[]{album1, album2, album3};

        //Création de playlists et ajout de chansons
        playlists[0]=new Playlist("Playlist pour les vacances","fan2Squ33zie");
        playlists[0].ajouterChanson(pistes1[0]);
        playlists[0].ajouterChanson(pistes1[1]);
        playlists[0].ajouterChanson(pistes1[2]);
        playlists[0].ajouterChanson(pistes3[0]);

        playlists[4]=new Playlist("Concentration - Revisions","Fanny Riedo");
        playlists[4].ajouterChanson(pistes2[0]);
        
        //affichage de la bibliothèque et des playlists
        System.out.println("Bibliothèque:");
        for (int i = 0; i < bibliotheque.length; i++) {
            if(bibliotheque[i]!=null){
                System.out.println("****************************");
                System.out.println(bibliotheque[i]);
                Chanson[] chansons=bibliotheque[i].getChansons();
                for (int j = 0; j < chansons.length; j++) {
                    if(chansons[j]!=null){
                        System.out.println(chansons[j]);
                    }
                }
            }
        }     

        
        System.out.println("****************************");
        System.out.println("Playlists:");
        for (int i = 0; i < playlists.length; i++) {
            if(playlists[i]!=null){
                System.out.println("****************************");
                System.out.println(playlists[i]);
                Chanson[] chansons=playlists[i].getChansons();
                for (int j = 0; j < chansons.length; j++) {
                    if(chansons[j]!=null){
                        System.out.println(chansons[j]);
                    }
                }
            }
        }
        System.out.println("****************************");                
    }
}
