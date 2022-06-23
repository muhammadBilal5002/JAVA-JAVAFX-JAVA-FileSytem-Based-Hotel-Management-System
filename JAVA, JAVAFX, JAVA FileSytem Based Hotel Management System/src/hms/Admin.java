package hms;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

import com.sun.java.swing.plaf.windows.resources.windows;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
public class Admin {
	private  static File f = new File("Members.txt");
	private  static Scanner s;	
	public static void adminpanel() {
		Stage window = new Stage();
		Button b1 = new Button("Add Members");
		Image image;
		try {		image = new Image("1.jpg");}
		catch(Exception e){
			image = new Image("file:1.jpg");
		}

		ImageView iv = new ImageView(image);
		b1.setOnAction(e->{
			add();
		});
		Button b2 = new Button("Search Members");
		b2.setOnAction(e->{
			searchmembers();
		});
		Button b3 = new Button("Delete Members");
		b3.setOnAction(e->{
			deletemembers();
		});
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
				CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
		iv.setFitHeight(500);
		iv.setFitWidth(485);
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
	public static void add() {
		Stage window2 = new Stage();
		ComboBox c = new ComboBox();
		c.getItems().addAll("Manager","Reception","Cook","Waiter","Security Guard");
		c.setPromptText("Add Member");
		Button b = new Button("ADD");
		
		b.setOnAction(e->{
		if (c.getValue().equals("Security Guard")||c.getValue().equals("Waiter")||c.getValue().equals("Cook")||c.getValue().equals("Manager")||c.getValue().equals("Reception"))
		{	window2.close();
			String n = (String) c.getValue();
			Members m = new Members();
			Stage window = new Stage();
			Label t1 = new Label(m.giveid());
			TextField t2 = new TextField();
			TextField t3 = new TextField();
			TextField t4 = new TextField();
			TextField t5 = new TextField();
			Button add = new Button("ADD");
			Label l1 = new Label("ID");
			Label l2 = new Label("Name");
			Label l3 = new Label("Adress");
			Label l4 = new Label("Phone No");
			Label l5 = new Label("Salary");
			GridPane gp = new GridPane();
	        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
	                CornerRadii.EMPTY, Insets.EMPTY);
	        Background background = new Background(background_fill);
	        gp.setBackground(background);
			gp.addRow(0,l1,t1);
			gp.addRow(1,l2,t2);
			gp.addRow(2,l3,t3);
			gp.addRow(3,l4,t4);
			gp.addRow(4,l5,t5);
			gp.add(add, 1, 6);
			gp.setAlignment(Pos.CENTER);
			gp.setVgap(15);
			gp.setHgap(10);

			add.setOnAction(e3->{
				window.close();
				if ( t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Fill All Field");
				}
				else {
					m.addmember(t1.getText(), t2.getText(), t3.getText(),  t4.getText(), t5.getText(),  n);	
				}
				
			});
			
			Scene s = new Scene(gp,300,250);
			window.setScene(s);
			window.show();
	
		}
		else
		{
			System.out.println("Workink....");
		}
		});
		GridPane gp = new GridPane();
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		gp.addRow(0, c);
		gp.addRow(2, b);
		Scene s = new Scene(gp,200,200);
		window2.setScene(s);
		window2.showAndWait();
	}
	public static void deletemembers(){
		Members m2 = new Members();
		Stage window = new Stage();
		Label l = new Label("POST: ");
		ComboBox c = new ComboBox();
		c.getItems().addAll("Manager","Reception","Cook","Waiter","Security Guard");
		c.setPromptText("Select Member");
		GridPane gp = new GridPane();
		Button b = new Button("Search");
		b.setOnAction(e->{
			String che = (String) c.getValue();
			String id = null;
			String Name = null ;
			String Address = null;
			String PhoneNumber = null;
			String Salary = null;
			String ocup = null;
			String av = null;
			int count = 1;
		 	try {
		 		 	
		 			Scanner s = new Scanner(f);
					s.useDelimiter("[,\n]");
					while(s.hasNext())
					{		
						id = s.next();
						Name = s.next();
						Address = s.next();
						PhoneNumber = s.next();
						Salary = s.next();
						ocup = s.next();
						av= s.next();
						if (ocup.contentEquals(che))
						{
							Label l3 = new Label("ID: " + id + "\nNAME: " + Name + "\nADDRESS: " + Address + "\nPHONE #: " + PhoneNumber +"\nSALARY: " + Salary +"\nPost: " +ocup);
							gp.add(l3, 1, count);
							count = count + 1;
								
						}
					}
		 	s.close();
		 	}
			 catch (Exception e2) {

			e2.printStackTrace();
		}
		 			TextField t = new TextField();
					t.setPromptText("Enter ID to Delete");
					Button d = new Button("Delete");
					gp.add(t, 1, count);
					gp.add(d, 2, count);
					d.setOnAction(e2->{
					m2.delete(t.getText());
					window.close();
					});
					
		});


		HBox hb = new HBox();
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.addRow(0,l,c,b);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(15);
		gp.setHgap(15);
		Scene s2 = new Scene(gp,400,600);
		window.setScene(s2);
		window.show();
		
	}
	public static void searchmembers(){
		Members m3 = new Members();
		Stage window = new Stage();
		Button b1 = new Button("Search by Id");
		b1.setOnAction(e->{
			window.close();
			searchbyid();
		});
		Button b2 = new Button("Search by Post");
		
		b2.setOnAction(e->{
			window.close();
			serchbypost("Members.txt");
			
		});
		GridPane gp = new GridPane();
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.addRow(0, b1);
		gp.addRow(1, b2);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		Scene s = new Scene(gp,300,200);
		window.setScene(s);
		window.show();	
		
	};
	public static void serchbypost(String a)
	{
		Label l = new Label("POST: ");
		ComboBox c = new ComboBox();
		c.getItems().addAll("Manager","Reception","Cook","Waiter","Security Guard");
		c.setPromptText("Select Member");
		Stage window = new Stage();
		GridPane gp = new GridPane();
		Button b = new Button("Search");
		Button ok = new Button("OK");
		b.setOnAction(e->{
			String che = (String) c.getValue();
			String id = null;
			String Name = null ;
			String Address = null;
			String PhoneNumber = null;
			String Salary = null;
			String ocup = null;
			String av = null;
		 	try {	
					Scanner s = new Scanner(f);
					s.useDelimiter("[,\n]");
					int count = 1;
					while(s.hasNext())
					{		
						id = s.next();
						Name = s.next();
						Address = s.next();
						PhoneNumber = s.next();
						Salary = s.next();
						ocup = s.next();
						av= s.next();
						if (ocup.contentEquals(che))
						{
							Label l3 = new Label("ID: " + id + "\nNAME: " + Name + "\nADDRESS: " + Address + "\nPHONE #: " + PhoneNumber +"\nSALARY: " + Salary +"\nPost: " +ocup);
							gp.add(l3, 1, count);
							count = count + 1;
								
						}
						
					}
					s.close();
					gp.add(ok,2, count);
					ok.setOnAction(e8->{
						window.close();
					});

					} catch (Exception e2) {

					e2.printStackTrace();
				}; 

		
		});
		HBox hb = new HBox();
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.addRow(0,l,c,b);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(15);
		gp.setHgap(15);
		Scene s = new Scene(gp,400,600);
		window.setScene(s);
		window.show();
	}
	public static void searchbyid() {
		Stage window = new Stage();
		Label l = new Label("ID: ");
		TextField t = new TextField();
		GridPane gp = new GridPane();
		Button b = new Button("Search");
		Button ok = new Button("OK");
		b.setOnAction(e->{
			String id = null;
			String Name = null ;
			String Address = null;
			String PhoneNumber = null;
			String Salary = null;
			String ocup = null;
			String av2=null;
			if (t.getText().isEmpty())
		 {
			 JOptionPane.showMessageDialog(null, "Please Enter Some Value");
		 }
		 else
		 {
			try {
					Scanner s = new Scanner(f);
					s.useDelimiter("[,\n]");
					Boolean che = true;
					while(s.hasNext() && che)
					{
						id = s.next();
						Name = s.next();
						Address = s.next();
						PhoneNumber = s.next();
						Salary = s.next();
						ocup = s.next();
						av2=s.next();
						if (id.contentEquals(t.getText()))
						{
							che = false;
						}
					}
					s.close();
					if(id.equals(t.getText()))
					{
					Label l3 = new Label("ID: " + id + "\nNAME: " + Name + "\nADDRESS: " + Address + "\nPHONE #: " + PhoneNumber +"\nSALARY: " + Salary +"\nPost: " +ocup);
					gp.add(l3, 1, 1);
					gp.add(ok, 2, 3);
					ok.setOnAction(e5->{
						window.close();
					});
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The Given Id Not Found");
					}
				} catch (Exception e2) {

					e2.printStackTrace();
				}; 

		}
		});
		HBox hb = new HBox();
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.addRow(0,l,t,b);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(15);
		gp.setHgap(15);
		Scene s = new Scene(gp,400,300);
		window.setScene(s);
		window.show();
	}

}

