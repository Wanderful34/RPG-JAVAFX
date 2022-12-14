package RPG.characters;

import RPG.graphicInterface.CharacterInfoFrame;

public class Hero extends Character{



    private int level;
    private int skillPoint;

    private static Hero hero;

    public Hero(String image, int maxHp, int currentHp, int force, int armor) {
        super(image, maxHp, currentHp, force, armor);
    }
    private Hero(String image){
        super(image,30,30,15,15);
        skillPoint = 12;
        level = 1;
    }

    @Override
    public void affectHero() {

    }

    public static Hero getIntance(){
        if(hero == null){
            hero = new Hero("barbare");
        }
        return hero;
    }


    public int getLevel() {
        return level;
    }
    public void levelUp(){
        this.skillPoint = skillPoint+3;
        this.level++;
        CharacterInfoFrame c = new CharacterInfoFrame();
        int hp = getCurrentHp();
        int hpMax = getMaxHp();
        hp = hp+(hp/10);
        if(hp>hpMax){
            hp = hpMax;
        }
        this.setCurrentHp(hp);
    }

    public void decreaseSkillPoints(){
        this.skillPoint--;
    }


    public void increasePoints(){
        this.skillPoint++;
    }

    public void addForce(){
        setForce(this.getForce()+1);
    }

    public void addArmor(){
        setArmor(this.getArmor()+1);
    }

    public void addMaxHp(){
        setMaxHp(this.getMaxHp()+1);
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    @Override
    public String whoIam() {
        return "Hero";
    }
}
