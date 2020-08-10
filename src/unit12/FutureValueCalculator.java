package unit12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FutureValueCalculator extends Application {
	public void start(Stage primaryStage) {
		Label amountLbl = new Label("Investment Amount ($): ");
		Label yearsLbl = new Label("Time (years): ");
		Label interestLbl = new Label("Annual Interest Rate (%): ");
		Label fvLbl = new Label("Future Value ($): ");
		
		Text message = new Text(); //This will show "Invalid input!" if the user enters invalid input.
		message.setUnderline(true);
		
		TextField amountTf = new TextField();
		TextField yearsTf = new TextField();
		TextField interestTf = new TextField();
		TextField fvTf = new TextField();
		
		fvTf.setEditable(false); //The future value text field is for the output, so the user should not be able to edit it.
		
		amountTf.setPrefColumnCount(15);
		yearsTf.setPrefColumnCount(15);
		interestTf.setPrefColumnCount(15);
		fvTf.setPrefColumnCount(15);
		
		Button calculateBtn = new Button("Calculate");
		calculateBtn.setOnAction((ActionEvent e) -> { //I used a lambda expression here to handle the event.
			try {
				message.setText(""); //Clear the message.
				int amount = Integer.parseInt(amountTf.getText());
				int years = Integer.parseInt(yearsTf.getText());
				double interest = Double.parseDouble(interestTf.getText())/100d; //Divide by 100 because the user entered a percentage
				double fvNotRounded = amount * (Math.pow(1 + interest/12d, 12 * years)); //Use the future value formula
				fvTf.setText(String.format("%.2f", fvNotRounded)); //Round to 2 decimal places
			}
			catch (NumberFormatException ex) { //NumberFormatException may be thrown when parsing from strings.
				message.setText("Invalid input!");
			}
		});
		
		//Add nodes to a GridPane
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		
		gp.add(amountLbl, 0, 0);
		gp.add(yearsLbl, 0, 1);
		gp.add(interestLbl, 0, 2);
		gp.add(fvLbl, 0, 3);
		gp.add(amountTf, 1, 0);
		gp.add(yearsTf, 1, 1);
		gp.add(interestTf, 1, 2);
		gp.add(fvTf, 1, 3);
		gp.add(calculateBtn, 1, 4);
		gp.add(message, 0, 4);
		
		GridPane.setHalignment(calculateBtn, HPos.RIGHT);
		
		gp.setPadding(new Insets(30, 50, 30, 50)); 
		gp.setHgap(10);
		gp.setVgap(5);
		
		Scene scene = new Scene(gp);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Future Value Calculator");
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
