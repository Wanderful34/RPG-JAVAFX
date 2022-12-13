package RPG.graphicInterface;

import RPG.characters.Character;
import RPG.characters.Hero;
import RPG.graphic.TamaJPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class GameFrame extends Stage {
    private static GameFrame gameFrame;
    private static final int x = 400;
    private static final int y = 400;
    private Label messageEtat;
    private Label messageJeu;
    private Hero hero;

    private ImageView imageCharacterView;
    private ImageView imageHeroView;

    private Character character;
    private Button boutonLancerDes;
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
        this.hero = Hero.getIntance();
        //PicturePanel heroImagePanel = new PicturePanel(x, y,"/image/tamagoshi.png");
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, x*2, y);

        messageEtat = new Label("MessageEtat");
        messageJeu = new Label("MessageJeux");
        VBox message = new VBox();
        message.setAlignment(Pos.CENTER);
        message.getChildren().addAll(messageEtat,messageJeu);

        HBox boxBouton = new HBox();
        boxBouton.setAlignment(Pos.CENTER);
        boutonLancerDes = new Button("Lancer les dés");
        boutonLancerDes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                //Action du Bouton
                hero.levelUp();
            }
        });
        boutonAction = new Button("Prochaine Rencontre");
        boutonAction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(hero.getSkillPoint()>0){
                    editTextMessage("Impossible tant que tous les points de compétence on était attribué");
                }
                else{
                    editTextMessage("Lancement de la prochaine rencontre");
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
        boxBouton.getChildren().add(boutonLancerDes);
        boxBouton.getChildren().add(boutonInfoCharacter);
        pane.setTop(message);
        pane.setBottom(boxBouton);

        this.editImageHero("barbare");
        this.editImageCharacter("tamagoshi");


        pane.setLeft(imageHeroView);
        pane.setRight(imageCharacterView);
        this.setTitle("RPG");
        this.setScene(scene);
        this.show();
    }

    public void editImageCharacter(String image){
        if(imageCharacterView == null){
            this.imageCharacterView = new ImageView();
        }
        URL input = GameFrame.class.getResource("/image/"+image+".png");
        Image imageCharacter = new Image(input.toExternalForm(),x,y-100,false,true);
        this.imageCharacterView.setImage(imageCharacter);
    }
    public void editImageHero(String image){
        if(imageHeroView == null){
             this.imageHeroView = new ImageView();
        }
        URL input = GameFrame.class.getResource("/image/"+image+".png");
        Image imageCharacter = new Image(input.toExternalForm(),x,y-100,false,true);
        this.imageHeroView.setImage(imageCharacter);
    }

    public void editTextBoutonAction(String text){
        boutonAction.setText(text);
    }

    public void editStateBoutonAction(Boolean state){
        boutonAction.setDisable(!state);
    }

    public void editStateBoutonLancerDes(Boolean state){
        boutonLancerDes.setDisable(!state);
    }

    public void editStateBoutonInfoCharacter(Boolean state){
        boutonInfoCharacter.setDisable(!state);
    }

    public void editTextMessageEtat(String text){
        messageEtat.setText(text);
    }
    public void editTextMessage(String text){
        messageEtat.setText(text);
    }


}
