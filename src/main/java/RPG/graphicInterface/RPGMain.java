package RPG.graphicInterface;

import RPG.characters.Hero;
import RPG.characters.Monster;
import RPG.event.Combat;
import RPG.tamagoshis.Tamagoshi;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;



public class RPGMain extends Application{



	
	@Override
	public void start(Stage arg0) throws Exception {
		Hero hero = Hero.getIntance();
		//GameFrame game = GameFrame.getInstance();
		//game.editTextMessageEtat("Tour 1");
		Combat c =new Combat(hero,new Monster(hero));
		c.combatStart();


		
	}
	
	public static void main(String[] args) {
		launch();
		
	}
}
