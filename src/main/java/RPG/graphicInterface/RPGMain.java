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

	public void initialisation() {

	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Hero hero = new Hero();
		GameFrame game = new GameFrame(hero);
		
	}
	
	public void play() {

	}
	
	public static void main(String[] args) {
		launch();
		
	}
}
