package RPG.characters;

import RPG.event.Combat;
import RPG.graphicInterface.GameFrame;

public class Monster extends Character{

    public Monster(String image) {
        super(image,25+Hero.getIntance().getLevel()*2, 25+Hero.getIntance().getLevel()*2,
                12+Hero.getIntance().getLevel()*2, 12+Hero.getIntance().getLevel()*2);
    }

    @Override
    public void affectHero() {
        GameFrame.getInstance().editTextMessage("Un monstre apparaît");
        Combat combat = new Combat(Hero.getIntance(),this);
        combat.combatStart();
    }

    @Override
    public String whoIam() {
        return "Monster";
    }
}
