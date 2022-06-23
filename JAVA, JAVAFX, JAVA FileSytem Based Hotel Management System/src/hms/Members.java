package hms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.scene.control.Label;

public class Members {
	private static File file = new File("Members.txt");
	private Scanner s;
	public void addmember(String a,String b,String c,String d,String e,String f) {
		try { 

			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(a+","+b+","+c+","+d+","+e+","+f+","+"0");
			pw.flush();
			fw.close();
			bw.close();
			pw.close();
			JOptionPane.showMessageDialog(null, "Record Has Been Saved");
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public String giveid() {
		int Conid=0;
		String id = null;
		String Name = null ;
		String Address = null;
		String PhoneNumber = null;
		String Salary = null;
		String ocup = null;
		String av =null;
		try {
			s = new Scanner(file);
			s.useDelimiter("[,\n]");
			while(s.hasNext())
			{
				id = s.next();
				Name = s.next();
				Address = s.next();
				PhoneNumber = s.next();
				Salary = s.next();
				ocup = s.next();
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
	public void delete(String a) {
	File file2 = new File("Temp.txt");
	try {
		
		String id = null;
		String Name = null ;
		String Address = null;
		String PhoneNumber = null;
		String Salary = null;
		String ocup = null;
		String av =null;
		s = new Scanner(file);
		FileWriter fw = new FileWriter(file2,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		s.useDelimiter("[,\n]");
		while(s.hasNext()) {
			id = s.next();
			Name = s.next();
			Address = s.next();
			PhoneNumber = s.next();
			Salary = s.next();
			ocup = s.next();
			av=s.next();
			if (!id.equals(a))
			{
				pw.println(id+","+Name+","+Address+","+PhoneNumber+","+Salary+","+ocup+","+"0");
			}
		}
		s.close();
		pw.flush();
		fw.close();
		bw.close();
		pw.close();
		file.delete();
		File dum = new File("Members.txt");
		file2.renameTo(dum);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	public void serchmemberbyid() {
		
	}
	public void serchmemberbyPost() {
		
	}

}
