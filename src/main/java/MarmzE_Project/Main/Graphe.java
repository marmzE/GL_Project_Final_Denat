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
}
