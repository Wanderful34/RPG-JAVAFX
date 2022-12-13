package RPG.event;

public class GameTurn {
    private static int nbTour = 0;
    private Encounter encounter;

    public static int addturn(){
        nbTour++;
        return(nbTour);
    }

    public static boolean isWin(){
        return false;
    }
}
