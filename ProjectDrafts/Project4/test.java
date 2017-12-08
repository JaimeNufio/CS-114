import java.util.Random;
public class test{
	public static void main(String[] args){
		Random r = new Random(1);
		String t = "";
		for (int i = 0; i< 10; i++){
			t+=r.nextInt();
		}
		System.out.print(t);
	}
}
