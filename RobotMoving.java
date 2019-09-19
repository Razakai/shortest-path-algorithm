//author Sean Adam Holland R00162740
public class RobotMoving {
	
	
	public void move(int mSize) {
		if(mSize < 1)
			System.out.println("Sorry number must be freater than 0");
		else {
			double totalCost[][] = new double[mSize+1][mSize+1];
			double firstMove[][] = new double[mSize+1][mSize+1];
			double movePrice[] = new double[3];
			movePrice[0] = 1.1; // move right
			movePrice[1] = 1.3; // move down
			movePrice[2] = 100; // move right-down/diagonal

			for(int column = 0; column < totalCost.length; column++) { // column
				for(int row = 0; row < totalCost.length; row++) { // row
					double cheapest = 99999999;
					if(column + row == 0) { // if row and column are 0 the robot is at the starting position and hasn't move yet
						totalCost[row][column] = 0;
						firstMove[row][column] = 0;
						cheapest = 0;				
						}
					if((column-1)>=0) {//make sure the column on the left is 0 or greater
						if(cheapest > movePrice[0] + totalCost[row][column-1]) { // going right
							cheapest = totalCost[row][column-1] + movePrice[0];
							firstMove[row][column] = movePrice[0]; // holds price of movement to that location for working back
							}
					}
					if((row-1)>=0) {//make sure the row on the left is 0 or greater
						if(cheapest > movePrice[1] + totalCost[row-1][column]) { // going down
							cheapest = totalCost[row-1][column] + movePrice[1];
							firstMove[row][column] = movePrice[1]; // holds price of movement to that location for working back
						}
					}
					if((row-1)>=0 & (column-1)>=0) {//make sure the row and column on the left is 0 or greater
						if(cheapest > movePrice[2] + totalCost[row-1][column-1]) { // going right-down/diagonal
							cheapest = totalCost[row-1][column-1] + movePrice[2];
							firstMove[row][column] = movePrice[2]; // holds price of movement to that location for working back
						}
					}
					totalCost[row][column] = cheapest; //saves the cheapest price to that position
					System.out.println("moved: "+cheapest);
				
				}
			}
			int row = mSize;
			int column = mSize;
		
			System.out.println("Cheapest price to get to position ("+row+","+column+") is $"+totalCost[row][column]);
			System.out.println("The path taken by the robot to arrive at position ("+row+","+column+") is:\n");
		
			boolean trace = true;
			String path = "";
			while(trace) { // prints out the path the robot took
				if(row == 0 & column == 0) {
					System.out.println(path);
					trace = false;
				}
				else if(firstMove[row][column] == 1.1) { // right
					//System.out.println("moved right");
					path = "moved right\n" + path; 
					column --;
					//System.out.println(row+"   "+column);
				}
				else if(firstMove[row][column] == 1.3) { // down
					//System.out.println("moved down");
					path = "moved down\n" + path; 
					row --;
					//System.out.println(row+"   "+column);
				}
				else if(firstMove[row][column] == 100) { // diagonal
					//System.out.println("moved right-down/diagonal");
					path = "moved right-down/diagonal\n" + path; 
					row--;
					column--;
					//System.out.println(row+"   "+column);
				}
				
				
			}
		
		
		
		
		

		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotMoving test = new RobotMoving();
		test.move(4);
	}

}
