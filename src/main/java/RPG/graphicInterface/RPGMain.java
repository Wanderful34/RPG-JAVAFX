package RPG.graphicInterface;

import RPG.characters.Hero;
import RPG.tamagoshis.Tamagoshi;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;



public class RPGMain extends Application{

	private final static int NBTROUR = 20;
	public void initialisation() {

	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Hero hero = Hero.getIntance();
		GameFrame game = GameFrame.getInstance();
		game.editTextMessageEtat("Tour 1");

		//for(int i=0;i<NBTROUR;i++){}

		
	}
	
	public void play() {
		Hero hero = Hero.getIntance();
		GameFrame game = GameFrame.getInstance();

	}
	
	public static void main(String[] args) {
		launch();
		
	}
}
