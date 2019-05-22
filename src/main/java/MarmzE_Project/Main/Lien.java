package MarmzE_Project.Main;
import java.util.HashMap;


public abstract class Lien {
		
		private String nom;
		private HashMap<String,String> listeProps;
		private Noeud destinataire;
		
		public Lien(String nom){
			this.setNom(nom);
			this.setListeProps(new HashMap<String,String>());
			this.destinataire = new Noeud();
			
		}
		
		public Lien(){
			this.setListeProps(new HashMap<String,String>());
		}
		
		public abstract boolean verifProp(String prop);

		public HashMap<String,String> getListeProps() {
			return listeProps;
		}

		public void setListeProps(HashMap<String,String> listeProps) {
			this.listeProps = listeProps;
		}

		public Noeud getDestinataire() {
			return destinataire;
		}

		public void setDestinataire(Noeud destinataire) {
			this.destinataire = destinataire;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}
}
