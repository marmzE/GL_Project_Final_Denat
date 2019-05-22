package MarmzE_Project.Main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Test_Friend {

private Friend f;
	
	@Before
	public void Avant(){
		this.f = new Friend();
	}
	
	
	
	
	@Test
	public void ConstructionFriend(){	
		assertEquals(f.getNom(),"friend");
	}
}
