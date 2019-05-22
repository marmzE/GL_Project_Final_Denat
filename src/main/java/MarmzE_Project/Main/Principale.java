package MarmzE_Project.Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Principale {

	public static void main(String [] args){
		//a faire
		
	}
	
	
	public static void lireText(){
		try{
			InputStream flux=new FileInputStream("test.txt"); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			int nbLigne =1;
			while ((ligne=buff.readLine())!=null){
				gestionLigne(ligne,nbLigne);
			}
			buff.close(); 
			}		
			catch (Exception e){
			System.out.println(e.toString());
			}
	}


	private static void gestionLigne(String ligne, int nbLigne) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
