package RPG.characters;

public class Monster extends Character{

    public Monster(String image) {
        super(image,25+Hero.getIntance().getLevel()*2, 25+Hero.getIntance().getLevel()*2,
                12+Hero.getIntance().getLevel()*2, 12+Hero.getIntance().getLevel()*2);
    }

    @Override
    public void affectHero() {

    }

    @Override
    public String whoIam() {
        return "Monster";
    }
}
