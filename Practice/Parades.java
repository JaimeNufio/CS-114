public class Parades{

	public static void main(String[] args){
		System.out.println(parades(40));
	}

	public static int parades(int n){
		if (n == 1){
			return 2;
		}else if(n ==2){
			return 3;
		}

		return parades(n-1)+parades(n-2);

	}
}	
