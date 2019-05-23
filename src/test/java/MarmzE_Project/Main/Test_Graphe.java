package MarmzE_Project.Main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test_Graphe {
	
	
	private Graphe g;
	private String ligne1;
	private String ligne2;
	private String ligne3;
	private String ligne4;
	private String ligne5;

	@Before
	public void avant(){ 
		this.g = new Graphe();
		this.ligne1="martin-friend(since=1987)-paul";
		this.ligne2="martin-friend(since=1987)";
		this.ligne3="martin-frend(since=1987)";
		this.ligne4="martin-friend(sincez=1987)-paul";
		this.ligne5="martin-friend(since=1987,share=blabla)-paul";
	}
	
	@Test
	public void test1RechercheNoeud(){
		Graphe.getListeNoeud().add(new Noeud("martin"));
		assertEquals(Graphe.rechercheNoeud("martin"),Graphe.getListeNoeud().get(0));
	}
	
	@Test
	public void test2RechercheNoeud(){
		Graphe.getListeNoeud().add(new Noeud("martin"));
		assertEquals(Graphe.rechercheNoeud("martine"),null);
	}
	
	

	
	
	@Test
	public void test1gestionLigne(){
		g.gestionLigne(this.ligne1);
		assertEquals(Graphe.getListeNoeud().get(0).getNom(),"martin");
	}
	
	@Test
	public void test2gestionLigne(){
		g.gestionLigne(this.ligne1);
		assertEquals(Graphe.getListeNoeud().get(1).getNom(),"paul");
	}
	
	@Test
	public void test3gestionLigne(){
		g.gestionLigne(this.ligne1);
		assertEquals(Graphe.getListeNoeud().get(0).getListeLien().get(0).getDestinataire().getNom(),"paul");
	}
	
	@Test
	public void test4gestionLigne(){
		g.gestionLigne(this.ligne1);
		assertEquals(Graphe.getListeNoeud().get(0).getListeLien().get(0).getNom(),"friend");
	}
	
	@Test
	public void test5gestionLigne(){
		g.gestionLigne(this.ligne1);
		assertEquals(Graphe.getListeNoeud().get(0).getListeLien().get(0).getListeProps().containsKey("since"),true);
	}
	
	@Test
	public void test6gestionLigne(){
		g.gestionLigne(this.ligne1);
		assertEquals(Graphe.getListeNoeud().get(0).getListeLien().get(0).getListeProps().containsValue("1987"),true);
	}
	
	@Test
	public void test7gestionLigne(){
		g.gestionLigne(this.ligne1);
		assertEquals(Graphe.getListeNoeud().get(0).getListeLien().get(0).getListeProps().size(),1);
	}
	
	@Test
	public void test8gestionLigne(){
		g.gestionLigne(this.ligne2);
		assertEquals(Graphe.getListeNoeud().isEmpty(),true);
	}
	
	@Test
	public void test9gestionLigne(){
		g.gestionLigne(this.ligne3);
		assertEquals(Graphe.getListeNoeud().isEmpty(),true);
	}
	
	@Test
	public void test10gestionLigne(){
		g.gestionLigne(this.ligne4);
		assertEquals(Graphe.getListeNoeud().isEmpty(),true);
	}
	
	@Test
	public void test11gestionLigne(){
		g.gestionLigne(this.ligne5);
		assertEquals(Graphe.getListeNoeud().isEmpty(),false);
	}
	
	
	
	
	
	
}
