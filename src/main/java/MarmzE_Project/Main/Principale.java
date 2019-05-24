package MarmzE_Project.Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;





public class Principale {

	private static Graphe g;
	
	public static void main(String [] args) throws IOException{
		g = new Graphe();
		lireText();
		gestionConsole();
		}

	private static void gestionConsole() {
		boolean choisi=false;
		System.out.println("\n\n Voulez-vous afficher le graphe (taper 1)\n Ou faire une recherche (taper 2)");
		Scanner sc = new Scanner(System.in);
		while(!choisi){
			String strg = sc.nextLine();
			if(strg.equals("1")){
				choisi=true;
				afficherGraphe();
			}
			if(strg.equals("2")){
				gestionRechercheSimple();
				choisi=true;
			}
			if(!choisi){
				System.out.println("erreur !! il faut taper 1 ou 2");
			}
		}
		
		
		
		
		
		
		sc.close();
		
	}

	private static void gestionRechercheSimple() {
		boolean choisi = false;
	
		System.out.println("Choisissez le noeud souhaité :");
		Scanner sc = new Scanner(System.in);
		while(!choisi){
			String res = sc.nextLine();
			if(res.equals("q")){
				choisi=true;
			}
			else{
				boolean trouve = g.rechercheNoeudBoolean(res);
				if(!trouve){
					System.out.println("noeud non présent dans le graphe, veuillez réessayer ou taper q pour quitter");
				}
				else{
					String noeudDuLien = res;
					boolean choisi2=false;
					System.out.println("quel lien voulez vous connaitre ? (like,friend,employee)");
					String res2="";
					while(!choisi2){
						res2 = sc.nextLine();
						if(res2.equals("like") || res2.equals("employee") || res2.equals("friend")){
							choisi2=true;
						}
						else{
							System.out.println("desole, ce nom de lien n'existe pas les trois seuls possibilités sont (friend,employee,like) ");
						}
					}
					String nomduLien = res2;
					
					
					System.out.println("Les noeuds :");
					for(int i=0;i<g.getListeNoeud().size();i++){
						for(int j=0;j<g.getListeNoeud().get(i).getListeLien().size();j++){
							
							ArrayList<Lien> listLien = g.getListeNoeud().get(i).getListeLien();
							
							if(listLien.get(j).getNom().equals(nomduLien) && listLien.get(j).getDestinataire().getNom().equals(noeudDuLien)){
								System.out.println(g.getListeNoeud().get(i).getNom());
							}
					
						}
				
					}
					System.out.println("ont un lien de type "+nomduLien+" avec "+noeudDuLien);
					
				}
			}
		}
		sc.close();
		
	}

	private static void afficherGraphe() {
		for(int i=0;i<g.getListeNoeud().size();i++){
			//Affiche le nom
			System.out.println(g.getListeNoeud().get(i).getNom());
			
			ArrayList<Lien> listLien = g.getListeNoeud().get(i).getListeLien();
			if(listLien.isEmpty()){
				System.out.println("\t Pas de Lien");
			}
			else{
				for(int j=0;j<listLien.size();j++){
						System.out.print("\t"+listLien.get(j).getNom()+"\t");
						
						HashMap<String, String> listProps =listLien.get(j).getListeProps();
						
						Set<String> cles = listProps.keySet();
						Iterator it = cles.iterator();
						String cle = (String) it.next(); // tu peux typer plus finement ici
						String valeur = listProps.get(cle); // tu peux typer plus finement ici
						System.out.println("\t"+cle+" -> "+valeur+"\t"+listLien.get(j).getDestinataire().getNom());
						
						while (it.hasNext()){
						   cle = (String) it.next(); // tu peux typer plus finement ici
						   valeur = listProps.get(cle); // tu peux typer plus finement ici
						   System.out.println("\t\t\t\t"+cle+" -> "+valeur+"\t"+listLien.get(j).getDestinataire().getNom());
						}
					}
				
				}
			}
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
