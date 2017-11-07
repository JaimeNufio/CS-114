//initial condition matters
//7 0  is best?
//

//heuristic 
//Assign "accesibility number"
//	-corners only have two spaces they can go to
//	-number is equal to legal moves
//	-start anywhere
//	-jump to square with lowest accesiblity
 
public class Project2{

	public static void main(String[] arr){
/*
		if (arr.length == 2){
			Tour thing = new Tour(new int[]{Integer.parseInt(arr[1]),Integer.parseInt(arr[0])});
		}else if (arr.length == 4){
			Tour thing = new Tour(new int[]{Integer.parseInt(arr[1]),Integer.parseInt(arr[0])},new int[]{Integer.parseInt(arr[2]),Integer.parseInt(arr[3])});
		}else{
			Tour thing = new Tour(new int[]{7,0});
		}
*/
		Tour thing = new Tour (new int[]{7,0});
	}

}


class Tour{

	int[][] map, disp = {{2,1},{1,2},{-2,1},{1,-2},{-2,-1},{-1,-2},{2,-1},{-1,2}};	
	int calls,size; //recursive calls

	public Tour(int[] mapSize, int[] startPos){
		startPos=new int[]{startPos[0],startPos[1]-1};	
		map = new int[mapSize[0]][mapSize[1]];
		size = map[0].length*map.length;
		move(startPos,0);
	}

	public Tour(int[]  startPos){

		map = new int[8][8];
		size = 64;
		System.out.printf("Initial Position: (%d,%d)",startPos[0],startPos[1]);
		move(startPos,0);
	}

	public boolean move(int[] temp, int cnt){
		
	  	calls++;
		int x = temp[0], y = temp[1];
		if (illegal(temp)){

			return false;
		}else{
			
			cnt++;
			this.map[x][y] = cnt;

			if (cnt == size){
				System.out.printf("Recursive Calls: %d\n", calls);	
				System.out.print(this);
				return true;
			}

			int[] opts = analysis(temp);
			int optNum = opts[8];
			
			for (int i = 0; i < 8; i++){
				if ( opts[i] == optNum && move(sum(temp,disp[i]),cnt)){ 
					return true;
				}
			}
		
			this.map[x][y] = 0;
			return false;
		}
	}

	//Warnsdorf Hueristic
	public int[] analysis(int[] temp){	//determin which future steps are valid (index line up with Displacement)

		int[] opts = new int[9];	 //every knight has 8 option moves. 9th index stores the opt number!	
		int optNum = 9;			//the option number will never exceed 8
			
		for (int i = 0; i < 8; i++){	// for each of these options
				
			if (!illegal(sum(temp,disp[i]))){
			opts[i] = options(sum(temp,disp[i]));	//find the number of options the current option has
			if (opts[i] < optNum){			//identify the lowest option Number and record it
				optNum = opts[i];
			}
			}
		}
		opts[8] = optNum;
		return opts;

	}

	public int options(int[] temp){
		int count = 0;
		for (int i = 0; i < disp.length; i++){
			if (!illegal(sum(temp,disp[i])))
				count++;
		}
		//System.out.printf("(%d,%d) has %d options\n",temp[0],temp[1],count);
		return count;
	}	

	public boolean illegal(int[] temp){ //determine if move is illegal

		int x = temp[0], y = temp[1];

		if (x < 0 || y < 0 || x >= map[0].length || y >= map.length){
			return true;
		}else if (map[x][y] > 0){
			return true;
		}
		return false;
	}

	public int[] sum(int[] a, int[] b){
		return new int[]{a[0]+b[0],a[1]+b[1]};
	}

	public String toString(){

		String temp = "";
		int num;
		for (int i = 0; i<this.map.length; i++){
			temp+=(map[0].length-i)+": ";
			for(int j = 0; j<map[0].length; j++){
				num = this.map[i][j];
				temp+=num >9 ?  " "+num+"  " : "  "+num+"  ";	
			}
			temp+="\n";
		}
		String txt = "  ";
		String bottomRow = "   ";
		for (int i = 0; i< this.map[0].length; i++){
			txt+="-----";
			bottomRow+="  "+(i+1)+"  ";
		}

		return temp+txt+"\n"+bottomRow+"\n";
	}

}
