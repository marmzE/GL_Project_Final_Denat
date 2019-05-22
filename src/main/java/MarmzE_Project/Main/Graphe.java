package MarmzE_Project.Main;
import java.util.ArrayList;

public class Graphe {
		private ArrayList<Noeud> listeNoeud;

		public Graphe(){
			this.listeNoeud = new ArrayList<Noeud>();
		}
		public ArrayList<Noeud> getListeNoeud() {
			return listeNoeud;
		}

		public void setListeNoeud(ArrayList<Noeud> listeNoeud) {
			this.listeNoeud = listeNoeud;
		}
		
		
		public Noeud rechercheNoeud(String parts) {
			boolean trouve = false;
			int i=0;
			
			while(!trouve && i<this.listeNoeud.size()){
				if(this.listeNoeud.get(i).getNom().equals(parts)){
					System.out.println("trouvee");
					trouve=true;
				}
				else{
					i++;
				}
			}
			return this.listeNoeud.get(i);
			
		}
}
