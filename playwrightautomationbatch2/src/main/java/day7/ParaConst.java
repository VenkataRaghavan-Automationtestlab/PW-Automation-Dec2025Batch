package day7;

public class ParaConst {
	
	int id;
	String name;
	
	ParaConst(int i, String n){
		id=i;
		name=n;
	}
	
	ParaConst(String name){
		System.out.println(name);
	}

	ParaConst(int i){
		id=i;
	}
	
	ParaConst(){
		name = "hari";
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		ParaConst pc = new ParaConst(101, "Venkat");
		System.out.println(pc.id);
		ParaConst pc1 = new ParaConst("Venkat");
		ParaConst pc2 = new ParaConst();
	}
}
