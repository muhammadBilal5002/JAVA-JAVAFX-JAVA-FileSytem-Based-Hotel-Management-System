package hms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Room {

	int roomno;
	final static double rent = 2000;	
	
	public static void compare() {
		String id = null;
		String room = null ;
		String name = null;
		String Phone = null;
		String nic = null;
		String stray = null;
		String av =null;
		File f1 = new File("guest.txt");
		try {
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
			checkroom(id,room);
		}
		s.close();
		} catch(Exception e) {
			
		}
	}
	
	
	public static void checkroom(String a, String b) {
		String id2 = null;
		String room2 = null ;
		String av2 = null;
		File f = new File("room.txt");
		File f2 = new File("temp.txt");
		try {
			Boolean che = true; 
			Scanner s = new Scanner(f);
			s.useDelimiter("[,\n]");
			FileWriter fw = new FileWriter("temp.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			while(s.hasNext()&&che) {
				id2 = s.next();
				room2 = s.next();
				av2=s.next();
				
				if(room2.equals(b)) {
					pw.println(a+ "," + b +"," + "0");			
					}
				else {
					pw.println(id2+ "," + room2 +"," + "0");
				}
			}
			s.close();
			pw.flush();
			pw.close();
			f.delete();
			File dum = new File("room.txt");
			f2.renameTo(dum);
			} catch(Exception e) {
			
		}
	}
	public static String giveid() {
		String id2 = null;
		String room2 = null ;
		String av2 = null;
		File f = new File("room.txt");
		try {
		Boolean che = true; 
		Scanner s = new Scanner(f);
		s.useDelimiter("[,\n]");
		while(s.hasNext()&&che) {
			id2 = s.next();
			room2 = s.next();
			av2=s.next();
			if (id2.equals("0"))
			{
				che = false;

			}
		}
		s.close();
	}
		catch(Exception e)
		{
		}
		return room2;
		}
	public static void delete(String a) {
		String id2 = null;
		String room2 = null ;
		String av2 = null;
		File f = new File("room.txt");
		File f2 = new File("temp3.txt");
		try {
			Boolean che = true; 
			Scanner s = new Scanner(f);
			s.useDelimiter("[,\n]");
			FileWriter fw = new FileWriter(f2,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			while(s.hasNext()&&che) {
				id2 = s.next();
				room2 = s.next();
				av2=s.next();
				
				if(!id2.equals(a)) {
					pw.println(id2+ "," + room2 +"," + "0");			
				}
				else {
					pw.println("0"+ "," + room2 +"," + "0");	
				}
			}
			s.close();
			pw.flush();
			pw.close();
			f.delete();
			File dum = new File("room.txt");
			f2.renameTo(dum);
			} catch(Exception e) {
			
		}
	}
	
}
