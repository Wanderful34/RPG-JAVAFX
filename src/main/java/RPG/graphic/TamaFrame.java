package RPG.graphic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import RPG.tamagoshis.Tamagoshi;

public class TamaFrame extends Stage{
	
	private Label messageEtat;
	private Label messageJeu;
	private Tamagoshi tamagoshiObjet;
	private Button boutonNourrir;
	private Button boutonJouer;
	
	
	
	public void changerEtatNourrir(boolean b){
		boutonNourrir.setDisable(b);
	}
	
	public void changerEtatJouer(boolean b){
		boutonJouer.setDisable(b);
	}



	public TamaFrame(Tamagoshi tamagoshiObjet) {
		super();

		int x = 400;
		int y = 400;
		this.tamagoshiObjet = tamagoshiObjet;
		TamaJPanel tamagoshi = new TamaJPanel(x, y);
		Scene scene = new Scene(tamagoshi, x, y);
		
		messageEtat = new Label(tamagoshiObjet.info());
		messageJeu = new Label();
		VBox message = new VBox();
		message.setAlignment(Pos.CENTER);
		message.getChildren().addAll(messageEtat,messageJeu);
		HBox boxBouton = new HBox();
		boxBouton.setAlignment(Pos.CENTER);
		boutonNourrir = new Button("Nourrir");
		boutonNourrir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(tamagoshiObjet.mange()) {
					messageJeu.setText("Miam je me régale");
				}
				else {
					messageJeu.setText("Je n'ai pas envie de manger");
				}
				updateMessage();
				
			}
		});
		boutonJouer = new Button("Jouer");
		boutonJouer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(tamagoshiObjet.joue()) {
					messageJeu.setText("je m'amuse comme un fou");
				}
				else {
					messageJeu.setText("Je ne veux pas jouer");
				}
				updateMessage();
			}
		});
		boxBouton.getChildren().add(boutonJouer);
		boxBouton.getChildren().add(boutonNourrir);
		tamagoshi.setTop(message);
		tamagoshi.setBottom(boxBouton);
		this.setTitle(tamagoshiObjet.getName());
		this.setScene(scene);
		this.show();
	}
	
	public void updateMessage() {
		messageEtat.setText(tamagoshiObjet.info());
	}
	
}
