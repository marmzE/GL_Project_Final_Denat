package MarmzE_Project.Main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Test_Friend {

private Friend f;
	
	@Before
	public void avant(){
		this.f = new Friend();
	}
	
	
	
	
	@Test
	public void constructionFriend(){	
		assertEquals(f.getNom(),"friend");
	}
	
}
