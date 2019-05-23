package MarmzE_Project.Main;
import java.util.ArrayList;

public class Graphe {
		private static ArrayList<Noeud> listeNoeud;
		private static int nbLigne = 1;
		private static final String EMPLOYEE="employee";
		private static final String FRIEND = "friend";
		
		public static int getNbLigne() {
			return nbLigne;
		}
		public static void setNbLigne(int nbLigne) {
			Graphe.nbLigne = nbLigne;
		}
		public Graphe(){
			listeNoeud = new ArrayList<Noeud>();
		}
		public static ArrayList<Noeud> getListeNoeud() {
			return listeNoeud;
		}

		public void setListeNoeud(ArrayList<Noeud> liste) {
			listeNoeud = liste;
		}
		
		
		public static Noeud rechercheNoeud(String parts) {
			boolean trouve = false;
			Noeud res = null;
			int i=0;
			
			while(!trouve && i<listeNoeud.size()){
				if(listeNoeud.get(i).getNom().equals(parts)){
					trouve=true;
					res = listeNoeud.get(i);
				}
				else{
					i++;
				}
			}
			return res;
			
		}
		
		public static Lien creationLien(String nomLien) {
			Lien lien;
			switch (nomLien){
			case FRIEND:
				lien = new Friend();
				break;
			case EMPLOYEE:
				lien = new Employee();
				break;
			default:
				lien = null;
				break;
			}
			return lien;
			
		}
			
		public static  boolean VerifLienEtProp(String l) {
			boolean res=true;
			String[] separation =l.split("\\(");
			
			String lien = separation[0];	
			if(lien.equals(EMPLOYEE) || lien.equals(FRIEND)){
				//Lien Verifié
				
				String reste = separation[1];
				reste = reste.substring(0, reste.length()-1);
				//since=1989,share=[books;movies;tweets]
				
				String [] separationProp = reste.split(",");
				for(int i=0;i<separationProp.length;i++){
					if(res == true){
						switch (lien){
							case EMPLOYEE :
									Employee e = new Employee();
									res =e.verifProp(separationProp[i].split("=")[0]);
									break;
							case FRIEND :
									Friend f = new Friend();
									res = f.verifProp(separationProp[i].split("=")[0]);
									break;
							default:
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
		
		public static void creationNoeuds(String noeudD,String noeudA) {
			creationNoeud(noeudD);
			creationNoeud(noeudA);
			
		}
		
		public static void creationNoeud(String noeud){
			if(!getListeNoeud().contains(new Noeud(noeud))){
				getListeNoeud().add(new Noeud(noeud));
			}
		}

		public void gestionLigne(String ligne){
			String[] parts = ligne.split("-");
			
			//il y a t-il 3 parties ? (noeud - lien - noeud)
			if(parts.length == 3){
				
				//gestion du lien
				if(VerifLienEtProp(parts[1])){
					//creation si besoin du noeud de depart
					Graphe.creationNoeuds(parts[0],parts[2]);
					
					//separation des elements du lien
					String[] separation =parts[1].split("\\(");
					
					//nom du lien
					String nomLien = separation[0];
					
					//initiation du lien
					Lien lien=null;
					
					
					//creation du lien
					lien = creationLien(nomLien);
					
						
					
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
					Noeud nDepart = rechercheNoeud(parts[0]);
					
					//recherche du noeud d'arrivee
					Noeud nArrivee = rechercheNoeud(parts[2]);
					
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


}
