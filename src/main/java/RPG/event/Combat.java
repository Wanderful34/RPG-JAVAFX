package RPG.event;

import RPG.characters.Character;
import RPG.characters.Hero;
import RPG.characters.Monster;
import RPG.characters.Personnage;
import RPG.graphicInterface.CombatFrame;
import RPG.graphicInterface.GameFrame;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.stage.StageStyle;

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
        this.frame = new CombatFrame(this.hero, this.monster, this, new CombatFrame.EndGameListener() {
            @Override
            public void onVainqueur(Character character) {
                frame.close();
                if (character instanceof Monster && hero.getCurrentHp()<=0){
                    GameFrame.getInstance().closeAndFinishTheGame(character);
                }else if (character instanceof Hero && GameFrame.getInstance().getTours()==6){
                    GameFrame.getInstance().closeAndFinishTheGame(character);
                }else combatEnd();
            }
        });
        GameFrame.getInstance().hide();
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
        GameFrame.getInstance().editStateBoutonAction(true);
        GameFrame.getInstance().show();
    }

    public int dmgCalcul(int lancesDes){
        int dmg = lancesDes + attaquant.getForce() - defenseur.getArmor();
        if(dmg<0){
            return 0;
        }
        else{
            return dmg;
        }
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
