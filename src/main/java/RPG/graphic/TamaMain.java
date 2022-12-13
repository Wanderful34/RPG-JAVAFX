package RPG.graphic;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import RPG.tamagoshis.Tamagoshi;



public class TamaMain extends Application{
	
	
	private static boolean nourrir = true;
	private static boolean jouer = true;
	ArrayList<Tamagoshi> listeDepart;
	ArrayList<Tamagoshi>  listeJeu;
	ArrayList<TamaFrame>  listeInter;
	
	
	
	public static void setNourrir(boolean nourrir) {
		TamaMain.nourrir = nourrir;
	}

	public static void setJouer(boolean jouer) {
		TamaMain.jouer = jouer;
	}

	public void initialisation(int n) {
		String name;
		listeDepart = new ArrayList<>();
		listeJeu = new ArrayList<>();
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Nom des tamagoshis");
		dialog.setContentText("Nom du Tamagoshi : ");
		for(int i=0;i<n;i++) {
			dialog.setHeaderText("Nom du tamagoshi numero " +(i+1));
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				name = result.get();
			}
			else {
				name = "" +(i+1);
			}
			listeDepart.add(new Tamagoshi(name));
		}
		listeJeu = new ArrayList<>(listeDepart);
		dialog.close();
		listeInter = new ArrayList<>();
		for (Tamagoshi tamagoshi : listeDepart) {
			TamaFrame t = new TamaFrame(tamagoshi);
			listeInter.add(t);
			
		}
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erreur");
		alert.setHeaderText("Chiffre invalide");
		alert.setContentText("Placer un chiffre valide mx=8");

		
	
		TextInputDialog dialog = new TextInputDialog("3");
		dialog.setTitle("Lancement de la partie");
		dialog.setHeaderText("Choisir le nombre de Tamagoshi max = 8");
		dialog.setContentText("Nombre : ");
		int nbTama = 0;
		while(nbTama<=0 || nbTama>8) {
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
			    try {
					nbTama = Integer.parseInt(result.get());
				} catch (NumberFormatException e) {
					alert.showAndWait();
				}
			}
		}
		dialog.close();
		alert.close();
		initialisation(nbTama);
		//play();
		
		
		
		/*
		Tamagoshi tamagoshi = new Tamagoshi("Gerard");
		TamaFrame t = new TamaFrame(tamagoshi);
		Tamagoshi tamagoshi2 = new Tamagoshi("Shun");
		TamaFrame t2 = new TamaFrame(tamagoshi2);*/
		
	}
	
	public void play() {
		int tour = 1;
		while(listeJeu.get(0).getAge()<Tamagoshi.getLifeTime() && !listeJeu.isEmpty()) {
			System.out.println("------------ Tour " + tour + " -------------");
			for (TamaFrame tamagoshi : listeInter) {
				tamagoshi.updateMessage();
			}
			int nombre = -1;
			
			nombre = -1;
			while(nourrir || jouer) {
					for (TamaFrame tamagoshi : listeInter) {
						tamagoshi.changerEtatNourrir(!nourrir);
						tamagoshi.changerEtatJouer(!jouer);
					}
			}
			for (Tamagoshi tamagoshi2 : listeDepart) {
				if(listeJeu.contains(tamagoshi2)) {
					tamagoshi2.consommeEnergie();
					if(tamagoshi2.getEnergy()<=0) {
						listeJeu.remove(tamagoshi2);
					}
					tamagoshi2.vieillir();
				}
			}
			tour++;
		}
		System.out.println("------------Fin du Jeu-------------");

	}
	
	public static void main(String[] args) {
		launch();
		
	}
}
