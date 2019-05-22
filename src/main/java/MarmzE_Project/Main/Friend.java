package MarmzE_Project.Main;


public class Friend extends Lien {

	public Friend() {
		super("friend");
	}

	public boolean verifProp(String prop) {
		boolean res;
		if(prop.equals("since") || prop.equals("share")){
			res=true;
		}
		else{
			res=false;
		}
		return res;
	}
}