package RPG.characters;

public class Monster extends Character{
    public Monster(Hero hero) {
        super(25+hero.getLevel()*2, 25+hero.getLevel()*2, 12+hero.getLevel()*2, 12+hero.getLevel()*2);
    }

    @Override
    public String whoIam() {
        return "Monster";
    }
}
