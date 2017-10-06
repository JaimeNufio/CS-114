public class Hanoi{


	public static void tower(int n, char src, char dst, char use){
		if (n > 0){
			tower(n-1,src, use, dst);
			System.out.println("Move disk" + n + " from "+src+" to "+dst);
		       	tower(n-1,use,dst, src);	
		}
	}
}
