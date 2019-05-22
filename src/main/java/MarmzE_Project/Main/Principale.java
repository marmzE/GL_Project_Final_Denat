package MarmzE_Project.Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Principale {

	private static Graphe g;
	private static int nbLigne;
	
	public static void main(String [] args){
		g = new Graphe();
		nbLigne = 1;
		lireText();
		
	}
	
	
	private static void gestionLigne(String ligne,int nbligne) {
		String[] parts = ligne.split("-");
		if(parts.length == 3){
			
			//gestion du lien
			if(VerifLienEtProp(parts[1])){
				
				//creation si besoin du noeud de depart
				if(!g.getListeNoeud().contains(new Noeud(parts[0]))){
					g.getListeNoeud().add(new Noeud(parts[0]));
				}
				
				if(!g.getListeNoeud().contains(new Noeud(parts[2]))){
					g.getListeNoeud().add(new Noeud(parts[2]));
				}
				
				//separation des elements du lien
				String[] separation =parts[1].split("\\(");
				
				//nom du lien
				String nomLien = separation[0];
				
				//initiation du lien
				Lien lien=new Friend();
				
				
				//creation du lien
				switch (nomLien){
				case "friend" :
						lien = new Friend();
						break;
				case "employee" :
					lien = new Employee();
					break;
				}		
				
				//since=1989,share=[books;movies;tweets]
				String reste = separation[1];
				reste = reste.substring(0, reste.length()-1);
				
				
				//creation de la liste des proprietes
				String [] separationProp = reste.split(",");
				
				//ajout des proprietes au lien
				for(int i=0;i<separationProp.length;i++){
					String [] listProp = separationProp[i].split("=");
					String nomProp = listProp[0];
					String valProp = listProp[1];
					lien.getListeProps().put(nomProp, valProp);
				}
				
			
				//recherche du noeud de depart
				Noeud nDepart = g.rechercheNoeud(parts[0]);
				
				//recherche du noeud d'arrivee
				Noeud nArrivee = g.rechercheNoeud(parts[2]);
				
				//ajout du noeud d arrivee au lien
				lien.setDestinataire(nArrivee);
				
				//ajout du lien au noeud de depart
				nDepart.getListeLien().add(lien);			
			}	
			else{
				System.out.println("ligne "+nbLigne+" incorrect");
			}
		}
		else{
			System.out.println("ligne "+nbLigne+" incorrect");
		}		
		nbLigne++;
		
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


	private static boolean VerifLienEtProp(String l) {
		boolean res=true;
		String[] separation =l.split("\\(");
		
		String lien = separation[0];	
		if(lien.equals("employee") || lien.equals("friend") || lien.equals("likes")){
			//Lien Verifié
			
			String reste = separation[1];
			reste = reste.substring(0, reste.length()-1);
			//since=1989,share=[books;movies;tweets]
			
			String [] separationProp = reste.split(",");
			for(int i=0;i<separationProp.length;i++){
				if(res == true){
					switch (lien){
						case "employee" :
								Employee e = new Employee();
								res =e.verifProp(separationProp[i].split("=")[0]);
								break;
						case "friend" :
								Friend f = new Friend();
								res = f.verifProp(separationProp[i].split("=")[0]);
								break;
					}
				}
			}	
		}
		else{
			res = false;
		}
		
		return res;
	}
	
	
	
}
