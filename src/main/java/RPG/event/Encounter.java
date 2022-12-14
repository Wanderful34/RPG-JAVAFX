package RPG.event;

import RPG.characters.Factory;
import RPG.characters.Personnage;

public class Encounter {
    public static void randEncounter(){
        Personnage personnage = Factory.createPersonnage();
        personnage.affectHero();
    }
}
