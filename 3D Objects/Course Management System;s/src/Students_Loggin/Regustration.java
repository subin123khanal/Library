package Students_Loggin;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.util.Scanner;

public class Regustration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Add marks");
		try {
			FileReader fr = new FileReader("Modules.txt");
			FileReader fr1 = new FileReader("text.txt");
			Scanner sc = new Scanner(fr);
			Scanner sc1 = new Scanner(fr1);
			ArrayList students = new ArrayList();
			ArrayList modules = new ArrayList();
			
			while(sc.hasNext()) {
				String[] a = sc.nextLine().split("\t\t");
				if(a[1].equals("lvl4")) {
					System.out.println(a[0]);
					
				}
				System.out.println("The subject this student is studing are:");
				while(sc1.hasNext()) {
					String[] b = sc1.nextLine().split("\t\t");
					if(b[1].equals(a[1])) {
						System.out.println(b[0]);
					}
				}
				}
			 
		}
		catch(IOException e) {
	    }
	}

	}
