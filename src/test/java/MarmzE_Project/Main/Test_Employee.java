package MarmzE_Project.Main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test_Employee {
	
private Employee e;
	
	@Before
	public void Avant(){
		this.e = new Employee();
	}
	

	@Test
	public void constructionEmployee(){	
		assertEquals(e.getNom(),"employee");
	}

}
