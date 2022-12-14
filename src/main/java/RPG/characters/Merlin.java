package RPG.characters;

import RPG.Utils.GameConstants;

public class Merlin extends Personnage {


    public Merlin(String image) {
        super(image);
    }

    @Override
    public void affectHero() {
        Hero.getIntance().setCurrentHpToMax();
    }


}
