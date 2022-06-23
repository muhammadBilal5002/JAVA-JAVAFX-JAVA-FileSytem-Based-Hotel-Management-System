package hms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Guest {
	String id;
	String room;
	String name;
	String phone;
	String nic;
	String bill;
	String stray;
	
	public static void add() {
		
		Button addguest = new Button("ADD");
		GridPane gp = new GridPane();
		Stage window = new Stage();
		Label t1 = new Label(giveid());
		Label t2 = new Label(Room.giveid());
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();
		TextField t6 = new TextField();
		Label l1 = new Label("ID");
		Label l2 = new Label("Room");
		Label l3 = new Label("Name");
		Label l4 = new Label("Phone");
		Label l5 = new Label("CNIC");
		Label l6 = new Label("No. of days for Room");
		addguest.setOnAction(e->{
			if ( t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || t6.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please Fill All Field");
			}
			else if (checkstray(t6.getText())) {
				JOptionPane.showMessageDialog(null, "Please Enter Integer In Last Field ");
			}
			else {
			window.close();
			addguest(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText());
			Room.compare();
			generatebill(t6.getText());
			}
		});
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);

		gp.addRow(0,l1,t1);
		gp.addRow(1,l2,t2);
		gp.addRow(2,l3,t3);
		gp.addRow(3,l4,t4);
		gp.addRow(4,l5,t5);
		gp.addRow(5,l6,t6);
		gp.add(addguest, 1, 6);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		gp.setHgap(10);
		gp.setBackground(background);
		Scene s = new Scene(gp,300,400);
		window.setScene(s);
		window.show();
		
	}
	
	public static void addguest(String a, String b, String c, String d, String e, String f) {
		try {
		FileWriter fw = new FileWriter("guest.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter p = new PrintWriter(bw);
		p.println(a+","+b+","+c+","+d+","+e+","+f+",0");
		p.flush();
		p.close();
		
		} catch (Exception e2) {
			
		}
	}
	
	public static void generatebill(String nor) {
		int x = Integer.parseInt(nor);
		double y = Room.rent * x;
		Label l = new Label();
		GridPane gp = new GridPane();
		Stage window = new Stage();
		Button ok = new Button("Ok");
		Button bill = new Button("Generate Bill");
		bill.setOnAction(e->{
			l.setText(String.valueOf(y));
			gp.addRow(2,l);
			gp.addRow(3,ok);
		});
		ok.setOnAction(e->{
			window.close();
		});
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.addRow(0, bill);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		gp.setHgap(10);
		Scene s = new Scene(gp,300,200);
		window.setScene(s);
		window.show();
	}
	
	public static String giveid() {
		File file = new File("guest.txt");
		
		int Conid=0;
		String id = null;
		String room = null ;
		String name = null;
		String Phone = null;
		String nic = null;
		String stray = null;
		String av =null;
		try {
		Scanner	s = new Scanner(file);
			s.useDelimiter("[,\n]");
			while(s.hasNext())
			{
				id = s.next();
				room = s.next();
				name = s.next();
				Phone = s.next();
				nic = s.next();
				stray = s.next();
				av=s.next();
			}
			s.close();
		} catch (Exception e2) {
			System.out.println("Problem" + e2);
		};
		if (id == null)
		{
			Conid = 1;
		}
		else
		{
		Conid = Integer.parseInt(id);
		Conid++;
		}
		String cc = String.valueOf(Conid);
	
		return cc;
	
	}
	public static void searchguest() {
		Stage window = new Stage();
		Label l2 = new Label();
		GridPane gp = new GridPane();
		Label l = new Label("Enter Id of the Guest");
		Button ok = new Button("OK");
		TextField t = new TextField();
		Button sear = new Button("Search");
		sear.setOnAction(e->{
			if(t.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Enter Id of the Guest");
			} else {
				if (search(t.getText()).equals("0"))
				{
					JOptionPane.showMessageDialog(null, "ID Not Found");
				}
				else {
					l2.setText(search(t.getText()));
					gp.add(l2,1,1);
					gp.add(ok,2,2);
					ok.setOnAction(e2->{
						window.close();
					});
				}

				
			}	
			});
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.addRow(0, l,t,sear);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(15);
		gp.setHgap(10);
		Scene s = new Scene(gp,350,300);
		window.setScene(s);
		window.show();
	}
	
	public static String search(String a) {
		String ret = "0";
		String id = null;
		String room = null ;
		String name = null;
		String Phone = null;
		String nic = null;
		String stray = null;
		String av =null;
		boolean che = true;
		File f = new File("guest.txt");
		try {
			Scanner s = new Scanner(f);
			s.useDelimiter("[,\n]");
			while(s.hasNext() && che) {
				id = s.next();
				room = s.next();
				name = s.next();
				Phone = s.next();
				nic = s.next();
				stray = s.next();
				av=s.next();
				if (id.equals(a)) {
					ret = "ID: "+ id + "\nRoom: "+room+"\nName:"+name+"\nPhone"+Phone+"\nCNIC: "+ nic +"\nStray: "+stray;
					che = false;

				}

			}
			s.close();
			
		} catch (Exception e) {
			
		}
		return ret;

	}
	
	
	public static void deleteguest() {
		Stage window = new Stage();
		GridPane gp = new GridPane();
		Label l = new Label("Enter Id of the Guest");
		TextField t = new TextField();
		Button del = new Button("Delete");
		del.setOnAction(e->{
			if(t.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Enter Id of the Guest");
			} else {
				window.close();
				delete(t.getText());
			}	
			});
        BackgroundFill background_fill = new BackgroundFill(Color.ALICEBLUE,  
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gp.setBackground(background);
		gp.addRow(0, l,t,del);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		gp.setHgap(10);
		Scene s = new Scene(gp,400,200);
		window.setScene(s);
		window.show();
	}
	
	public static void delete(String a) {
		int count = 1;
		String id = null;
		String room = null ;
		String name = null;
		String Phone = null;
		String nic = null;
		String stray = null;
		String av =null;
		File f1 = new File("guest.txt");
		File f2 = new File("temp2.txt");
		try {
		FileWriter fw = new FileWriter(f2,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter p = new PrintWriter(bw);
		Scanner s = new Scanner(f1);
		s.useDelimiter("[,\n]");
		while(s.hasNext()) {
			id = s.next();
			room = s.next();
			name = s.next();
			Phone = s.next();
			nic = s.next();
			stray = s.next();
			av=s.next();
			if(!id.equals(a)) {

				p.println(id+","+room+","+name+","+Phone+","+nic+","+stray+",0");		
			}
			else if (id.equals(a))
			{
				count = 2;
			}
		}
		if (count == 1)
		{
			JOptionPane.showMessageDialog(null, "Guest Not Found");	
		}
		else {
			JOptionPane.showMessageDialog(null, "Record Has Been Deleted");	
			Room.delete(a);
		}
		s.close();
		p.flush();
		p.close();
		f1.delete();
		File dum = new File("guest.txt");
		f2.renameTo(dum);
		} 
		catch (Exception e) {
			
		}
	}
	public static Boolean checkstray(String a) {
		Boolean c1 = false;
		try {
			 int c = Integer.parseInt(a);
			 
		}
		catch(Exception e) {
			c1 = true;
		}
		return c1;
	}
}
