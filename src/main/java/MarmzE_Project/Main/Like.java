package MarmzE_Project.Main;


public class Like extends Lien {

	public Like() {
		super("like");
	}

	public boolean verifProp(String prop) {
		boolean res;
		if(prop.equals("date")){
			res=true;
		}
		else{
			res=false;
		}
		return res;
	}

	
}