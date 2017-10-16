public class Combination{

	public static void main(String[] args){
		System.out.println(combo(5,2));
	}

	public static int combo(int objects, int chosen){
		if (objects == chosen){
			return 1;
		}
		if(chosen == 0){
			return 1;
		}
		if(chosen >= objects){
			return 0;
		}
		return(combo(objects-1,chosen-1)+combo(objects-1,chosen));
	}
}
