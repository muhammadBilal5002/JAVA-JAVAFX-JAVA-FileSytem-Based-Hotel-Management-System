package hms;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TextField tf1 = new TextField("User Name");
		Label l1 = new Label ("LOGIN SCREEN");
		PasswordField pf1 = new PasswordField();
		pf1.setPromptText("Password");
		
		Button b = new Button("Log In");
		b.setOnAction(e->{
			check(tf1.getText(),pf1.getText(),primaryStage);

		});
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                                      CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        l1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        l1.setAlignment(Pos.CENTER);
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(15);
		gp.addRow(1, l1);
		gp.addRow(5, tf1);
		gp.addRow(6, pf1);
		gp.addRow(8, b);
		gp.setBackground(background);
		
		Scene s = new Scene(gp,250,300);
		
		primaryStage.setScene(s);
		primaryStage.setTitle("Login Screen");
		primaryStage.show();
		
	}
	public static void check(String a,String b,Stage c) {
		if(a.equalsIgnoreCase("admin") && b.equals("12345")) {
			c.close();
			Stage window = new Stage();
			Label l = new Label("\nWELCOME TO ADMIN PANEL!");
			Button RP = new Button("Reception Panel");
			Button AP = new Button("Admin Panel");
			AP.setOnAction(e->{
				window.close();
				Admin.adminpanel();
			});
			RP.setOnAction(e->{

				window.close();
				Reception.recpanel();
			});
	        l.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16 )); 
			BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                    CornerRadii.EMPTY, Insets.EMPTY);
			Background background = new Background(background_fill);
			VBox vb = new VBox(l,AP,RP);
			vb.setSpacing(30);
			vb.setBackground(background);
			vb.setAlignment(Pos.TOP_CENTER);
			Scene s = new Scene(vb,300,200);
			window.setScene(s);
			window.show();	
			
		}
		else if(a.equalsIgnoreCase("rec") && b.equals("12345"))
		{	c.close();
			Stage window = new Stage();
			Label l = new Label("\nWELCOME TO RECEPTION PANEL!");
			Button RP = new Button("Reception Panel");
			RP.setOnAction(e->{
				Reception.recpanel();
				window.close();
			});
	        l.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16 )); 
			BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                    CornerRadii.EMPTY, Insets.EMPTY);
			Background background = new Background(background_fill);
			VBox vb = new VBox(l,RP);
			vb.setBackground(background);
			vb.setSpacing(60);
			vb.setAlignment(Pos.TOP_CENTER);
			Scene s = new Scene(vb,300,200);
			window.setScene(s);
			window.setTitle("Reception Panel");
			window.show();	
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Not Found");
		}
		
	}

}
