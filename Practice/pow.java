public class pow{

	public static void main(String[] args){
		System.out.println(power(4,3));
	}

	public static int power(int x, int n){
		if (n==0)
			return 1;
		return x*power(x,n-1);
	}
}
