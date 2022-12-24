package RPG.graphicInterface;

import RPG.characters.Character;
import RPG.characters.Hero;
import RPG.characters.Monster;
import RPG.characters.Personnage;
import RPG.event.Combat;
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
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.Random;

public class CombatFrame extends Stage {

    private static final int x = 400;
    private static final int y = 400;
    private Label messageEtat;
    private Label messageJeu;
    private Label hpHero;
    private Label hpMonster;
    private Hero hero;
    private Monster monster;
    private ImageView imageMonsterView;
    private ImageView imageHeroView;
    private Button boutonLancerDes;
    private Combat combat;
    private EndGameListener endGameListener;
    public interface EndGameListener{
        void onVainqueur(Character caCharacter);
    }


    public CombatFrame(Hero hero, Monster monster, Combat combat, EndGameListener endGameListener) {
        super();
        this.setTitle("Combat contre un Monstre");
        this.hero = hero;
        this.monster = monster;
        this.combat = combat;
        this.endGameListener = endGameListener;
        Random r = new Random();
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, x*2, y);
        hpHero = new Label("");
        hpMonster = new Label("");
        messageEtat = new Label("Lancer votre dés");
        messageJeu = new Label("-");
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
                int lancesDes = r.nextInt(12-1)+1;
                editTextMessage("Votre lancé de dés est " + lancesDes);
                editTextMessageEtat(combat.whoIsAttaquant().whoIam() + " inflige " + combat.dmgCalcul(lancesDes) + " de dégat à " + combat.whoIsDefenseur().whoIam());
                if(combat.nextTurn(lancesDes)){
                    alertEndGame(combat.whoIsDefenseur());
                }
                updateHealtPoint(hpHero, hero.getCurrentHp());
                updateHealtPoint(hpMonster, monster.getCurrentHp());

            }
        });

        boxBouton.getChildren().add(boutonLancerDes);
        pane.setTop(message);
        pane.setBottom(boxBouton);
        updateHealtPoint(hpHero, hero.getCurrentHp());
        updateHealtPoint(hpMonster, monster.getCurrentHp());
        this.imageHeroView = new ImageView();
        this.imageMonsterView = new ImageView();
        this.editImage(hero.getImage(),imageHeroView);
        this.editImage(monster.getImage(), imageMonsterView);

        VBox heroBox = new VBox();
        heroBox.getChildren().addAll(hpHero,imageHeroView);

        VBox monsterBox = new VBox();
        monsterBox.getChildren().addAll(hpMonster,imageMonsterView);

        pane.setLeft(heroBox);
        pane.setRight(monsterBox);

        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setHeaderText("Finir vos action");
                alert.setContentText("Vous devez finir le combat pour quitter le jeux");
                alert.show();
                event.consume();

            }
        });

        this.setScene(scene);
        this.initModality(Modality.APPLICATION_MODAL);
        this.show();
    }

    public void editImage(String image,ImageView view){
        if(view == null){
            view = new ImageView();
            System.out.println("test");
        }
        URL input = GameFrame.class.getResource("/image/"+image+".png");
        Image imageCharacter = new Image(input.toExternalForm(),x,y-100,false,true);
        view.setImage(imageCharacter);
    }

    public void editTextMessageEtat(String text){
        messageEtat.setText(text);
    }
    public void editTextMessage(String text){
        messageEtat.setText(text);
    }

    public void updateHealtPoint(Label p,int hp){
        p.setText("HP : " + hp);
    }

    public void alertEndGame(Character vainqueur){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fin de combat");
        alert.setHeaderText("Le combat est terminé");
        alert.setContentText("Le vainqueur est " + vainqueur.whoIam());
        alert.initStyle(StageStyle.UTILITY);
        alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
            @Override
            public void handle(DialogEvent dialogEvent) {
                endGameListener.onVainqueur(combat.whoIsDefenseur());
            }
        });
        alert.show();
    }
}
