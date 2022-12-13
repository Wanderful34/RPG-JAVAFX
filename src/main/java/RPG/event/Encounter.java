package RPG.event;

import java.util.Random;

public class Encounter {
    public static void randEncounter(){
        Random r = new Random();
        int rand = r.nextInt(100);
        if(rand <= 50){
            //Rencontre Hostile
        } else if (rand <= 75) {
            //Rencontre Merlin
        } else {
            // Rencontre Maitre d'arme
        }

    }
}
