package RPG.event;

import RPG.characters.Character;
import RPG.characters.Hero;
import RPG.characters.Monster;
import RPG.graphicInterface.CombatFrame;
import RPG.graphicInterface.GameFrame;

import java.util.Random;

public class Combat {
    private Hero hero;
    private Monster monster;

    private Character attaquant;
    private Character defenseur;
    private CombatFrame frame;

    public Combat(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public void combatStart(){
        this.frame = new CombatFrame(this.hero,this.monster,this);
        Random r = new Random();
        if(r.nextInt((100 - 1) +1)<=65){
            this.attaquant = this.hero;
            this.defenseur = this.monster;
        }
        else{
            this.attaquant = this.monster;
            this.defenseur = this.hero;
        }
    }

    public void combatEnd(){
        this.frame.close();
    }

    public int dmgCalcul(int lancesDes){
        return(lancesDes + attaquant.getForce() - defenseur.getArmor());
    }

    public boolean nextTurn(int lancesDes){
        boolean mort = defenseur.takeDamage(dmgCalcul(lancesDes));
        this.swapRole();
        return(mort);
    }

    public void swapRole(){
        Character tampon = this.attaquant;
        this.attaquant = this.defenseur;
        this.defenseur = tampon;
    }

    public Character whoIsAttaquant(){
        return this.attaquant;
    }

    public Character whoIsDefenseur(){
        return this.defenseur;
    }




}
