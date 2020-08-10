package unit10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ThreeCards extends Application {
	public void start(Stage primaryStage) {
		HBox hb = new HBox(5); //Creates HBox with spacing of 5 pixels between children
		
		try {
			//Adds images to HBox
			hb.getChildren().addAll(
				new ImageView("file:///Users/anthony/java/cty/src/unit10/c1.gif"),
				new ImageView("file:///Users/anthony/java/cty/src/unit10/c2.gif"),
				new ImageView("file:///Users/anthony/java/cty/src/unit10/c3.gif")
			);
		}
		catch (Exception ex) {
			System.out.println("Cannot find image");
		}
		
		StackPane sp = new StackPane(hb); //Creates StackPane that contains the HBox so that initial margins can be set around the HBox
		hb.setAlignment(Pos.BOTTOM_RIGHT); //Keeps the HBox centered 
		StackPane.setMargin(hb, new Insets(30, 100, 30, 100)); //Margins are initially 30 pixels on the top and bottom and 100 pixels on the left and right
		
		Scene scene = new Scene(sp); //Creates scene that contains the StackPane
		
		primaryStage.setTitle("3 Cards");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
