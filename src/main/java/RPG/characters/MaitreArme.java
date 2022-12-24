package RPG.characters;

import RPG.Utils.GameConstants;
import RPG.graphicInterface.GameFrame;

public class MaitreArme extends Personnage{

    public MaitreArme(String image) {
        super(image);
    }

    @Override
    public void affectHero() {
        GameFrame.getInstance().editTextMessage("Le maitre d'arme vous permet de progresser de 1 niveau");
        Hero.getIntance().levelUp();
    }

    @Override
    public String whoIam() {
        return "MaitreArme";
    }

}
