package RPG.graphic;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class TamaJPanel extends BorderPane{
	
	private ImageView tamagoshiImageView;
	
	public TamaJPanel(int x,int y) {
		URL input = TamaJPanel.class.getResource("/image/tamagoshi.png");
		
		Image tamagoshiImage = new Image(input.toExternalForm(),x,y-100,false,true);
		ImageView tamagoshiImageView = new ImageView(tamagoshiImage);
		this.getChildren().add(tamagoshiImageView);

	}
	
	
}
