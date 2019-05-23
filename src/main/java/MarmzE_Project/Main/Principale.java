package MarmzE_Project.Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Principale {

	private static Graphe g;
	
	public static void main(String [] args) throws IOException{
		g = new Graphe();
		lireText();
		}

	public static void lireText() throws IOException{
			InputStream flux=new FileInputStream("test.txt"); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				if(ligne.equals("")){
					System.out.println("ligne "+Graphe.getNbLigne()+" vide");
					Graphe.setNbLigne(Graphe.getNbLigne()+1);
				}
				g.gestionLigne(ligne);
			}
			buff.close(); 		
	}
	
	
	
}
