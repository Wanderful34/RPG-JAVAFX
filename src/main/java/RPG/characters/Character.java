package RPG.characters;

public abstract class Character extends  Personnage{
    private int maxHp;
    private int currentHp;
    private int force;
    private int armor;


    public Character(String image, int maxHp, int currentHp, int force, int armor) {
        super(image);
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.force = force;
        this.armor = armor;
    }
    public void setCurrentHpToMax(){
        currentHp = maxHp;
    }
    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
    public boolean takeDamage(int dmg){
        this.currentHp-=dmg;
        return(this.currentHp<=0);
    }
    public abstract String whoIam();
}
