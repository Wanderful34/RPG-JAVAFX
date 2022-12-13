package RPG.event;

import RPG.characters.Character;
import RPG.characters.Hero;
import RPG.characters.Monster;
import RPG.graphicInterface.GameFrame;

public class Combat {
    private Character attaquant;
    private Character defenseur;
    private GameFrame gameFrame;

    public Combat(Character attaquant, Character defenseur, GameFrame gameFrame) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;
        this.gameFrame = gameFrame;
    }


    public void combatStart(){

    }


}
