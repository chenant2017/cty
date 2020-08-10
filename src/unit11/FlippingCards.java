package unit11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FlippingCards extends Application {
	public void start(Stage primaryStage) {
		GridPane gp = new GridPane();
		
		gp.setHgap(5);
		gp.setVgap(5);
		gp.setAlignment(Pos.CENTER);
		gp.setPadding(new Insets(40, 70, 40, 70));
		
		try {
			Card c1 = new Card(new Image("file:///Users/anthony/java/cty/images/c1.gif"));
			Card c2 = new Card(new Image("file:///Users/anthony/java/cty/images/c2.gif"));
			Card c3 = new Card(new Image("file:///Users/anthony/java/cty/images/c3.gif"));
			
			gp.add(c1.showing, 0, 0);
			gp.add(c2.showing, 1, 0);
			gp.add(c3.showing, 2, 0);
			
			Button c1Btn = new Button("Flip");
			Button c2Btn = new Button("Flip");
			Button c3Btn = new Button("Flip");
			
			gp.add(c1Btn, 0, 1);
			gp.add(c2Btn, 1, 1);
			gp.add(c3Btn, 2, 1);
			
			//Orient the buttons so that they are centralized under the cards
			GridPane.setHalignment(c1Btn, HPos.CENTER);
			GridPane.setHalignment(c2Btn, HPos.CENTER);
			GridPane.setHalignment(c3Btn, HPos.CENTER);
			
			//Event handlers for each button
			CardHandler c1Handler = new CardHandler(c1);
			CardHandler c2Handler = new CardHandler(c2);
			CardHandler c3Handler = new CardHandler(c3);
			
			//Register the handlers with their respective buttons
			//c1Btn.setOnAction(c1Handler); 
			//c2Btn.setOnAction(c2Handler);
			//c3Btn.setOnAction(c3Handler);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Scene scene = new Scene(gp); 
		primaryStage.setTitle("Flipping Cards");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	class Card {
		private Image faceUp; 
		private final Image FACE_DOWN = new Image("file:///Users/anthony/java/cty/images/b1fv.gif");
		private ImageView showing = new ImageView(); //Shows the image of the card in the current state
		
		public Card(Image faceUp) {
			this.faceUp = faceUp;
			showing.setImage(faceUp); //When a Card object is created, it initially shows the face-up image
		}
		
		public void flip() { //Changes the image of the card to the other state
			if (showing.getImage() == faceUp) {
				showing.setImage(FACE_DOWN);
			}
			else {
				showing.setImage(faceUp);
			}
		}
	}
	
	class CardHandler implements EventHandler<ActionEvent> { //EventHandler class that can be used for all 3 buttons
		private Card card;
		
		public CardHandler(Card card) { //The program uses this constructor so that it knows which Card object's flip method to invoke
			this.card = card;
		}
		
		public void handle(ActionEvent e) {
			card.flip();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
