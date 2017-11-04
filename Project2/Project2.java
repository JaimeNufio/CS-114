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
		Tour thing = new Tour(new int[]{8,8},new int[]{7,0});
	}

}


class Tour{

	int[][] map, disp = {{2,1},{1,2},{-2,1},{1,-2},{-2,-1},{-1,-2},{2,-1},{-1,2}};	
	
	public Tour(int[] mapSize, int[] startPos){
		
		map = new int[mapSize[0]][mapSize[1]];
		move(startPos);
	}

	public Tour(int[]  startPos){
		map = new int[8][8];
		move(startPos);
	}

	int cnt;

	public boolean move(int[] temp){
			
		System.out.printf("Current Info: (%d,%d) Count: %d\n", temp[0],temp[1],cnt);	
		int x = temp[0], y = temp[1];
		if (cnt >= 64){
			System.out.print(this);
			return true;	
		}else if (illegal(temp)){
			return false;
		}else{

			//Good postion

			cnt++;
			map[x][y] = cnt;

			int[] opts = new int[8];	
			int optNum = 9;
			for (int i = 0; i < 8; i++){
				
				opts[i] = options(sum(temp,disp[i]));	
				if (illegal(sum(temp,disp[i]))){
					opts[i] = 0;
				}else if (opts[i] < optNum){
					optNum = opts[i];
				}
			}
			for (int i = 0; i < 8; i++){
				if (opts[i] != 0 && opts[i] == optNum && move(sum(temp,disp[i]))){
					System.out.print(this);
					return true;
				}
			}

			//	for (int i = 0; i < 8; i++){
			//	if ( move(new int[]{x+disp[i][0],y+disp[i][1]})){
			//	if (move(sum(temp,disp[0])) || move(sum(temp,disp[1])) || move(sum(temp,disp[2])) || move(sum(temp,disp[3])) 
			//			|| move(sum(temp,disp[4])) || move(sum(temp,disp[5])) || move(sum(temp,disp[6])) || move(sum(temp,disp[7]))){		
			//		return true;				
			//	}

			cnt--;
			map[x][y] = 0;
		//	System.out.println("Backtrack");
			return false;
		}
	}

	public int options(int[] temp){
		int count = 0;
		for (int i = 0; i < disp.length; i++){
			if (!illegal(sum(temp,disp[i])))
				count++;
		}
		return count;
	}	

	public boolean illegal(int[] temp){ //determine if move is illegal

		int x = temp[0], y = temp[1];

		if (x < 0 || y < 0 || x >= map[0].length || y >= map.length){
			return true;
		}else if (map[x][y] != 0){
			return true;
		}
		return false;
	}

	public int[] sum(int[] a, int[] b){
		return new int[]{a[0]+b[0],a[1]+b[1]};
	}

	public String toString(){

		String temp = "";

		for (int i = 0; i<map.length; i++){
			for(int j = 0; j<map[0].length; j++){
				temp+=" "+map[i][j]+" ";	
			}
			temp+="\n";
		}

		return temp+"\n";
	}

}
