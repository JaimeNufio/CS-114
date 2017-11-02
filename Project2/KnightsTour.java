//Jaime Nufio, CS114-05 Kapleau
//Jen25 11/1/17

//This assignment was really fun tbh

//Execution: takes 4 arg, Width of Board, Length of Board, Initial X, initial Y
//Acceptable initial X and Y both exist on [1,8]


public class KnightsTour{

	public static void main(String[] args){

			boolean[][] map;
			int initX, initY;
	
			if (args.length == 4){
				map = new boolean[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
		   		initX = Integer.parseInt(args[2]); initY = Integer.parseInt(args[3]);
			}else{
				map = new boolean[8][8];
		   		initX = 7; initY = 7;
			}
	
			Tour theBoard = new Tour(map,initX,initY); 
	}
}

class Tour{

	boolean[][] map;
	int[][] orderedMap;
	private int initX, initY, count, totalSteps;
	
	public Tour(boolean[][] myMap, int x, int y){
	
		map = myMap;
		orderedMap = new int[map[0].length][map.length];
		initX = x;
		initY = y;
		travel(x,y);
	}

	public void travel(int x, int y){
		totalSteps = 0;
		move(x-1,y-1); //the "graphing" is backwards, oops
		System.out.printf("\nInitial Position: (%d,%d)\n",x,y);
		System.out.println(this);
	}

	private boolean check(int x, int y){ // Check if the next move is valid
	
		int len = map[0].length, wid = map.length;

		//8 possibilities, check in order of 
		//3X1Y, 1X3Y
		//-3X1Y, -1X3Y
		//-3X-1Y, -1X-3Y
		//3X-1Y, -1Y3X
	
		//conditions for a failure
		//	-outside of map
		//	-the space has been visited already

		//Condition for sucesss (Base)
		//	-Count of steps is equal to 64 

		if (x < 0 || x >= wid  || y < 0 || y >= len){
			return false; //we are outside of the map
		} else if (map[x][y]){	//have we visited this space before?
			return false; //we are stepping on a visited space
		}else if (count == len*wid){ //I think I can do away with this line, but lets keep it for now
			return true;
		}
		return true; //there wasn't anything wrong with the spot we chose.

	}

	private boolean move(int tempX, int tempY){ //the recursive method

		totalSteps++;

		if (check(tempX,tempY)){
			count++; //update steps
			map[tempX][tempY] = true; //mark as stepped.
			orderedMap[tempX][tempY] = count;
		
	//		if (count % 8 == 0){
	//			System.out.println(this);
	//		}

			return count == map[0].length*map.length ? true : move(tempX,tempY);

		}else{
			
			int[][] disp = {{2,1},{1,2},{-2,1},{1,-2},{-2,-1},{-1,-2},{2,-1},{-1,2}}; //Displacement from tempX and tempY resepctive

				for (int i = 0; i<disp.length;i++){
					if (check(tempX+disp[i][0],tempY+disp[i][1])){
						//NOTE: here we acknowledge that the step is valid, but do not mark it as so, at least not until the next step in recurision
						System.out.printf("Move %d: Knight from (%d,%d) to (%d,%d)\n",count,tempX,tempY,tempX+disp[i][0],tempY+disp[i][1]);
				//		System.out.print(magnitude(tempX,tempY,tempX+disp[i][0],tempY+disp[i][1]));
						move(tempX+disp[i][0],tempY+disp[i][1]);
					}
				}			
				//System.out.println("No valid movements. Backtrack.");
				
				return false; //after checking All possible moves, it turns out there wasn't an answer on this level, back track.
		}
	}	

	public double magnitude(int x, int y, int xa, int ya){
		return Math.sqrt(Math.pow(x-xa,2) +Math.pow(y-ya,2));
	}

	public String toString(){
		
		String temp = "";
		for (int i = 0; i<orderedMap.length; i++){
			temp+="\n "+i+":";
			for (int j = 0; j<orderedMap[0].length; j++){
				//temp += map[i][j] ? " X " : " - ";
				temp += (orderedMap[i][j]+"").length() == 1  ? "   "+orderedMap[i][j]  : "  "+orderedMap[i][j];
				temp+="  ";
			   	//this gets mess when Area of board is greater than 99	
			}
		}
		temp+="\n   ----------------------------------------------\n     0     1     2     3     4     5     6     8 \nTotal Steps = "+totalSteps;
		return temp;
	}
}

/*In Pseudo
 *
 * boolean move(x,y){
 * if check(x,y) is a valid pos
 *		mark that spot as used, update count
 *		
 *		if count is 64 return true, if not move again
 *
 *else
 	FOR LOOP: list of all possible displacemnts (there are 8) 
		check each one individually until one is valid
		state the move
	if for loop fails, return false (Back track)
 */
