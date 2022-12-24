package RPG.graphicInterface;

import RPG.characters.Hero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class CharacterInfoFrame extends Stage {


    private final Button forceButton;
    private final Button armorButton;
    private final Button hpMaxButton;

    private final Label forceLabel;
    private final Label armorLabel;
    private final Label hpLabel;
    private final Label skillPointLabel;
    private final Label levelLabel;
    private final Hero hero;

    public CharacterInfoFrame(){
        super();
        GameFrame g = GameFrame.getInstance();
        g.editStateBoutonInfoCharacter(false);
        g.editStateBoutonAction(false);
        this.hero=Hero.getIntance();
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

                if(hero.getSkillPoint()>0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Finir vos action");
                    alert.setContentText("Utiliser tout vos point de compétences");
                    alert.initStyle(StageStyle.UTILITY);
                    alert.show();
                    event.consume();
                }
                else{
                    g.editStateBoutonInfoCharacter(true);
                    g.editStateBoutonAction(true);
                    close();
                }
            }
        });
        //PicturePanel heroImagePanel = new PicturePanel(x, y,"/image/tamagoshi.png");
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 400, 150);
        levelLabel = new Label();
        forceLabel = new Label();
        armorLabel = new Label();
        hpLabel = new Label();
        skillPointLabel = new Label();
        this.updateFrame();
        VBox message = new VBox();
        message.setAlignment(Pos.CENTER);
        message.getChildren().addAll(levelLabel,forceLabel,armorLabel, hpLabel,skillPointLabel);

        HBox boxBouton = new HBox();
        boxBouton.setAlignment(Pos.CENTER);
        forceButton = new Button("Ajouter force");
        forceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                hero.addForce();
                addPoint();
            }
        });

        armorButton = new Button("Ajouter Armure");
        armorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                hero.addArmor();
                addPoint();
            }
        });


        hpMaxButton = new Button("Ajouter Point de vie");
        hpMaxButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                hero.addMaxHp();
                addPoint();
            }
        });

        boxBouton.getChildren().add(forceButton);
        boxBouton.getChildren().add(armorButton);
        boxBouton.getChildren().add(hpMaxButton);

        pane.setTop(message);
        pane.setBottom(boxBouton);
        testSkillPoint(hero.getSkillPoint());

        this.setTitle("Information Héro");
        this.initModality(Modality.APPLICATION_MODAL);
        this.setScene(scene);
        this.show();

    }

    private void updateFrame(){
        levelLabel.setText("Niveau : "+hero.getLevel());
        forceLabel.setText("Force : "+hero.getForce());
        armorLabel.setText("Armure : "+hero.getArmor());
        hpLabel.setText("Point de vie : "+hero.getCurrentHp()+"/"+hero.getMaxHp());
        skillPointLabel.setText("Point de compétence disponible : "+hero.getSkillPoint());
    }
    private void testSkillPoint(int skillpoint){
        if(skillpoint>0){
            forceButton.setDisable(false);
            hpMaxButton.setDisable(false);
            armorButton.setDisable(false);
        }
        else{
            forceButton.setDisable(true);
            hpMaxButton.setDisable(true);
            armorButton.setDisable(true);
        }
    }

    private void addPoint(){
        hero.decreaseSkillPoints();
        testSkillPoint(hero.getSkillPoint());
        updateFrame();
    }

}
