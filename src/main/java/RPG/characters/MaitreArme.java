package RPG.characters;

import RPG.Utils.GameConstants;

public class MaitreArme extends Personnage{

    public MaitreArme(String image) {
        super(image);
    }

    @Override
    public void affectHero() {
        Hero.getIntance().levelUp();
    }

}
