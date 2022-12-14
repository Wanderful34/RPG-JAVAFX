package RPG.characters;

import java.util.Random;

public class Factory {

    public static Personnage createPersonnage(){
        int percent = new Random().nextInt(100);
        if(percent <= 50){
            return new Monster("monster");
        } else if (percent <= 75) {
            return new Merlin("marlin");
        } else {
            return new MaitreArme("maitrearme");
        }
    }
}
