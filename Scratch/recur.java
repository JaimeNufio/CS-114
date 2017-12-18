import java.util.*;
public class recur{

	public static void main (String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {5,3,7,1,8,4,0,5,9,2};
		//System.out.println(binary(a,Integer.parseInt(args[0])));
		//System.out.print(pow(2,4));
		//b = selectionSort(b);
		b = is(b);
		printA(b);
	}

	public static boolean binary(int[] a, int target){
		return binaryr(a,target);
	}

	public static void printA(int[] array){
		String s = "";
		for (int i = 0; i<array.length; i++){
			s = s+array[i];
		}
		System.out.println(s);
	}
	
	private static boolean binaryr(int[] a, int target){
		int middle = (int)(a.length/2);
		
		if (a[middle] == target){
			return true;
		}
		if (a.length <= 1){ //we need a fail condition, here we check the array size
			return false;
		}
		if (target <= a[middle]){ 
			return (binaryr(sub(0,middle,a),target));
		}else{
			return (binaryr(sub(middle+1,a.length,a),target));
		}
	}

	private static int[] is(int[] array){
		int curr; //some data
		int j; // I don't think I need this?

		for (int i = 1; i<array.length; i++){
			curr = array[i];
			for (j = i; j>0; j--){
				if (array[j-1]>curr){
						array[j]=array[j-1];
				}else{
					break;
			}

			if (j<i){
				array[j] = curr;
			}
			printA(array);
			}
		}
		return array;
	}

	private static int[] bb(int[] array){
			while(true){
				boolean swap = false;
				for(int i = 0; i<array.length-1; i++){
					if (array[i] > array[i+1]){
						swap = true;
						int temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
					}
				}
				if (!swap){
					break;
				}
			}
			return array;
	}

	private static int[] selectionSort(int[] array){
		int temp;
		int j;
		for (int i = 0; i< array.length;i++){
			temp = array[i];
			for (j = i-1; j>-1; j--){
				if (array[j] > temp){
					array[j+1] = array[j];
				}else{
					break; //redudent parts?
				}
			}
			if (j+1<i){
				array[j+1] = temp;
			}
		}
		return array;
	}

	private static int[] sub(int n1, int n2, int[] a){
		//return Arrays.copyOfRange(a,n1,n2); //create sub arrays
		int[] temp = new int[n2-n1];
		for (int i = n1; i<n2; i++){
			temp [i] = a[i];
		}
		return temp;
	}
}
