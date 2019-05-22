package MarmzE_Project.Main;

public class Employee extends Lien {

	public Employee() {
		super("employee");
	}

	public boolean verifProp(String prop) {
		boolean res;
		if(prop.equals("role") || prop.equals("hired")){
			res=true;
		}
		else{
			res=false;
		}
		return res;
	}
}