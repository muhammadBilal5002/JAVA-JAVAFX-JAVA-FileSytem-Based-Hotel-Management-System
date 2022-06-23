package hms;

import javax.swing.JOptionPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Reception {
	public static void recpanel() {
		Stage window = new Stage();
		Image image;
		try {		image = new Image("2.jpg");}
		catch(Exception e){
			image = new Image("file:2.jpg");
		}

		ImageView iv = new ImageView(image);
		Button b1 = new Button("Add Guest");
		b1.setOnAction(e->{
			Guest.add();
		});
		Button b2 = new Button("Search Guest");
		b2.setOnAction(e->{
			Guest.searchguest();
			
		});
		Button b3 = new Button("Delete Guest");
		b3.setOnAction(e->{
			Guest.deleteguest();
			
		});
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
        									CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
		iv.setFitHeight(500);
		iv.setFitWidth(500);
		VBox vb1 = new VBox(b1,b2,b3);
		vb1.setSpacing(110);
		vb1.setAlignment(Pos.CENTER_LEFT);	
		VBox vb2 = new VBox(iv);
		HBox hb = new HBox(vb1,vb2);
		hb.setSpacing(50);
		hb.setAlignment(Pos.CENTER_RIGHT);
		hb.setBackground(background);
		Scene s = new Scene(hb,650,490);
		window.setScene(s);
		window.show();	
	}
	
}


