package MarmzE_Project.Main;
import java.util.ArrayList;

public class Noeud {
		private String nom;
		private ArrayList<Lien> listeLien;
		
		
		public Noeud(String nom){
			this.setNom(nom);
			this.setListeLien(new ArrayList<Lien>());
		}
		
		public Noeud(){
			this.setListeLien(new ArrayList<Lien>());
		}


		public ArrayList<Lien> getListeLien() {
			return listeLien;
		}


		public void setListeLien(ArrayList<Lien> listeLien) {
			this.listeLien = listeLien;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Noeud other = (Noeud) obj;
			if (nom == null) {
				if (other.nom != null)
					return false;
			} else if (!nom.equals(other.nom))
				return false;
			return true;
		}

	
		

	}

