public class reverseString{

	public static void main(String[] s){
		String thing = s[0];
		System.out.print(reverse(thing));
	}

	public static String reverse(String w){
		if(w.length() <= 1){
			return w;
		}
		
		return reverse(w.substring(1))+w.charAt(0);
	}

}
