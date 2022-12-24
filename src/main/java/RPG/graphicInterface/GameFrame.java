package RPG.graphicInterface;

import RPG.characters.*;
import RPG.characters.Character;
import RPG.event.Combat;
import RPG.graphic.TamaJPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class GameFrame extends Stage {
    private static GameFrame gameFrame;
    private static final int x = 400;
    private static final int y = 400;
    private Label messageEtat;
    private Label messageJeu;
    private Hero hero;
    private int tours;
    private ImageView imageCharacterView;
    private ImageView imageHeroView;

    private Character character;
    private Button boutonAction;

    private Button boutonInfoCharacter;

    public static GameFrame getInstance(){
        if(gameFrame == null){
            gameFrame = new GameFrame();
        }
        return gameFrame;
    }
    private GameFrame() {
        super();
        this.tours = 1;
        this.hero = Hero.getIntance();
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, x, y);

        messageEtat = new Label("-");
        messageJeu = new Label("-");
        VBox message = new VBox();
        message.setAlignment(Pos.CENTER);
        message.getChildren().addAll(messageEtat,messageJeu);

        HBox boxBouton = new HBox();
        boxBouton.setAlignment(Pos.CENTER);

        boutonAction = new Button("Prochaine Rencontre");
        boutonAction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(hero.getSkillPoint()>0){
                    editTextMessage("Impossible tant que tous les points de compétence on était attribué");
                }
                else{
                    printNextTurn();
                    editTextMessage("Lancement de la prochaine rencontre");
                    Personnage personnage = Factory.createPersonnage();
                    if ((personnage instanceof MaitreArme || personnage instanceof Merlin)&& tours==6){
                        closeAndFinishTheGame(hero);
                        return;
                    }
                    personnage.affectHero();

                }
            }
        });

        boutonInfoCharacter = new Button("Fiche Personnage");
        boutonInfoCharacter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                //Action Bouton d'action
                CharacterInfoFrame c = new CharacterInfoFrame();
            }
        });

        boxBouton.getChildren().add(boutonAction);
        boxBouton.getChildren().add(boutonInfoCharacter);
        pane.setTop(message);
        pane.setBottom(boxBouton);

        this.editImageHero(hero.getImage());


        pane.setCenter(imageHeroView);

        this.setTitle("RPG");
        this.initModality(Modality.APPLICATION_MODAL);
        this.setScene(scene);
        this.show();
    }

    public int getTours() {
        return tours;
    }
    public void closeAndFinishTheGame(Personnage character){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de partie");
        alert.setHeaderText(null);
        alert.setContentText("La partie est términé, le vaiqueur est le " + character.whoIam());
        alert.initStyle(StageStyle.UTILITY);
        alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
            @Override
            public void handle(DialogEvent dialogEvent) {
                restartGame();
            }
        });
        alert.show();
    }
    public void editImageHero(String image){
        if(imageHeroView == null){
             this.imageHeroView = new ImageView();
        }
        URL input = GameFrame.class.getResource("/image/"+image+".png");
        Image imageCharacter = new Image(input.toExternalForm(),x,y-100,false,true);
        this.imageHeroView.setImage(imageCharacter);
    }
    public void editStateBoutonAction(Boolean state){
        boutonAction.setDisable(!state);
    }

    public void editStateBoutonInfoCharacter(Boolean state){
        boutonInfoCharacter.setDisable(!state);
    }

    public void editTextMessageEtat(String text){
        messageEtat.setText(text);
    }
    public void editTextMessage(String text){
        messageJeu.setText(text);
    }

    public void printNextTurn(){
        this.tours++;
        editTextMessageEtat("Tours : " + this.tours);
    }
    public void restartGame(){
        gameFrame.close();
        gameFrame = null;
        hero.resetCharacteristics();
        GameFrame.getInstance();
    }

}
