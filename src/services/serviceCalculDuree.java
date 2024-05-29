package services;

public class serviceCalculDuree {
    public static int calculeDureeSecondes(int minutes, int secondes){
        return 60*minutes + secondes;
    }

    public static int calculeMinutesEntieres(int totalSecondes){
        return totalSecondes/60;
    }

    public static int calculeResteSecondes(int totalSecondes){
        return totalSecondes%60;
    }
    
}
