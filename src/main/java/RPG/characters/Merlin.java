package RPG.characters;

import RPG.Utils.GameConstants;
import RPG.graphicInterface.CombatFrame;
import RPG.graphicInterface.GameFrame;

public class Merlin extends Personnage {


    public Merlin(String image) {
        super(image);
    }

    @Override
    public void affectHero() {
        GameFrame.getInstance().editTextMessage("Merlin soigne votre héro");
        Hero.getIntance().setCurrentHpToMax();
    }


}
