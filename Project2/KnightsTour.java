//Jaime Nufio, CS114-05 Kapleau
//Jen25 11/1/17

//This assignment was really fun tbh

//Execution: takes 4 arg, Width of Board, Length of Board, Initial X, initial Y
//Acceptable initial X and Y both exist on [1,8]

import java.util.Stack;

public class KnightsTour{

	public static void main(String[] args){

			int[][] map;
			int initX, initY;
	
			if (args.length == 4){
				map = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
		   		initX = Integer.parseInt(args[2]); initY = Integer.parseInt(args[3]);
			}else{
				map = new int[8][8];
		   		initX = 0; initY = 0;
			}
	
			Tour theBoard = new Tour(map,initX,initY); 
	}
}

class Tour{

	int[][] map;
	private int initX, initY, count, totalSteps;
	
	public Tour(int[][] myMap, int x, int y){
	
		map = myMap;
		initX = x;
		initY = y;
		travel(x,y);
	//	writeSpace(x,y);
		
		Integer[] temp;
		while (!moves.empty()){
			temp = moves.pop();	
			System.out.printf("(%d,%d) to (%d,%d)\n",temp[0],temp[1]);
			map[temp[0]][temp[1]] = count;
		}
	}

	public void writeSpace(int x, int y){
		count++;
		map[x][y]=count;
		System.out.println(this);
	}

	public void travel(int x, int y){
		totalSteps = 0;
		move(x,y); //the "graphing" is backwards, oops
		System.out.printf("\nInitial Position: (%d,%d)\n",x,y);
		System.out.println(this);
	}


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

	int cap;

	private boolean move(int tempX, int tempY){ //the recursive method

		if (count > cap){
			cap = count;
		}
		
		System.out.println("level: "+count+" cap:"+cap);
		int len = map[0].length, wid = map.length;
		
		if (tempX < 0 || tempX >  wid-1  || tempY < 0 || tempY > len-1){
			return false; //we are outside of the map
		} else if (map[tempX][tempY] != 0){	
			return false; //we are stepping on a visited space
		}else if (count == 63){
			System.out.println("Good.");
			return true;
		}else{//no special conditions
			
			int[][] disp = {{2,1},{1,2},{-2,1},{1,-2},{-2,-1},{-1,-2},{2,-1},{-1,2}}; //Displacement from tempX and tempY resepctive
			count++; //update steps
			map[tempX][tempY] = count; //mark as stepped.
		
//			moves.push(new Integer[] {tempX,tempY});
			for (int i = 0; i<disp.length;i++){
				if (move(tempX+disp[i][0],tempY+disp[i][1])){

					return true;
				}
			}			

			count--;
//			moves.pop();	
			map[tempX][tempY] = 0;
			return false; //after checking All possible moves, it turns out there wasn't an answer on this level, back track.

		}
	}	


	public String toString(){
		
		String temp = "";
		for (int i = 0; i<map.length; i++){
			temp+="\n "+i+":";
			for (int j = 0; j<map[0].length; j++){
				//temp += map[i][j] ? " X " : " - ";
				temp += (map[i][j]+"").length() == 1  ? "   "+map[i][j]  : "  "+map[i][j];
				temp+="  ";
			   	//this gets mess when Area of board is greater than 99	
			}
		}
		temp+="\n   ----------------------------------------------\n     0     1     2     3     4     5     6     7 \nTotal Steps = "+totalSteps;
		return temp;
	} 

	Stack<Integer[]> moves = new Stack<Integer[]>();

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
