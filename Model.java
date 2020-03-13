
public class Model {

	private final int row=6;//
	private final int column= 7;
	public final int[][] grid=new int[row-1][column-1];
	private int player;
	private int counter;//counts the number of turns
	private int previous= grid[0][0];
	private int column1=5;
	private int column2=5;
	private int column3=5;
	private int column4=5;
	private int column5=5;
	private int column6=5;
	private int column7=5;


public Model(int player, int counter) {
		super();
		this.player = 1;
		this.counter = 0;
	}

public void resetGame() {
	for(int i=0;i<row;i++) {
		for(int j=0;j<column;j++) {
			grid[i][j]=0;//resets the grid to empty
			
		}
	}
	player=1;//resets the player to one
	counter++;
}

/*Using odd turns for player1 and even turns for player 2
 * 
 */

public int turn(int counter) {
	if(counter%2!=0) {
		return 2;
	}
	else
		return 1;
	
	/*switch(player2) {
	case 1: player2=2;
	break;
	case 2: player2=1;
	break;
	}
	return player2;
	*/
}


/**
 * Sets the occupant to the specified value.
 * 
 * @param player
 *            the occupant of the square (0=empty, 1=player1, 2=player2)
 * @throws IllegalArgumentException
 *             if the occupant is not 0, 1, or 2
 */
public void setPlayer(int player) {
	if (player < 0 || player > 2)
		throw new IllegalArgumentException("Invalid occupant: " + player
				+ ", must be 0, 1, or 2");
	this.player = player;
	setToolTipText("Player " + player);
	repaint();
}


/**
 * Gets the current occupant of this square
 * 
 * @return the current occupant of this square (0=empty, 1=player1,
 *         2=player2)
 */
public int getPlayer() {
	return player;
}
public int[][] getGrid(){
	return grid;
}

 
public void dropCoin(int columnNumber) {
	boolean full=false;
	switch(columnNumber){
		case 1: 
			
			grid[1][column1]=player;
			column1-=1;
			counter++;
			player=turn(counter);
			checkWinner(player);
			full=checkFull();
			if(full==true) {
				System.out.println("Tie");
				break;
			}
			break;
		case 2: 
			
			grid[1][column1]=player;
			column1-=1;
			counter++;
			player=turn(counter);
			checkWinner(player);
			full=checkFull();
			if(full==true) {
				System.out.println("Tie");
				break;
			}
			break;
		case 3: 
				
			grid[1][column1]=player;
			column1-=1;
			counter++;
			player=turn(counter);
			checkWinner(player);
			full=checkFull();
			if(full==true) {
				System.out.println("Tie");
				break;
			}
			break;
		case 4: 
					
			grid[1][column1]=player;
			column1-=1;
			counter++;
			player=turn(counter);	
			checkWinner(player);
			full=checkFull();
			if(full==true) {
				System.out.println("Tie");
				break;
			}
			break;
		case 5: 
					
			grid[1][column1]=player;
			column1-=1;
			counter++;
			player=turn(counter);	
			checkWinner(player);
			full=checkFull();
			if(full==true) {
				System.out.println("Tie");
				break;
			}
			break;
		case 6: 
			grid[1][column1]=player;
			column1-=1;
			counter++;
			player=turn(counter);
			checkWinner(player);
			if(full==true) {
				System.out.println("Tie");
				break;
			}
			break;
		case 7: 
			grid[1][column1]=player;
			column1-=1;
			counter++;
			player=turn(counter);
			checkWinner(player);
			full=checkFull();
			if(full==true) {
				System.out.println("Tie");
				break;
			}
			break;
		
		
	}
	
}



public boolean checkHorizontal(int previous) {
	for(int i=0;i<row;i++) {
		for(int j=0;j<column-3;j++) {
			if(grid[row][column]==previous
					&& grid[row][column+1]==previous
					&& grid[row][column+2]==previous
					&& grid[row][column+3]==previous) {
				return true;
			}
		}
	}
	return false;
}


public boolean checkVertical(int previous) {
	for(int i=0;i<row-3;i++) {
		for(int j=0;j<column;j++) {
			if(grid[row][column]==previous
					&& grid[row+1][column]==previous
					&& grid[row+2][column]==previous
					&& grid[row+3][column]==previous) {
				return true;
			}
		}
	}
	return false;
	}

public boolean checkDiagonal( int previous) {
		for(int column=0;column<4;column++) {
			for(int row=0;row<3;row++) {
				if(grid[row][column]==previous&&grid[row+1][column+1]==previous&&grid[row+2][column+2]==previous&&grid[row+3][column+3]==previous) {
					return true;
				}
			}
			for(int row=3;row<6;row++) {
				if(grid[row][column]==previous&&grid[row-1][column+1]==previous&&grid[row-2][column+2]==previous&&grid[row-3][column+3]==previous) {
					return true;
				}
			}
		}
		return false;
	}
	/*
	 * check if the diagonal wins the game in both direction
	 */

	public boolean checkWinner(int winnerChecker) {
		boolean winOrNot1=checkDiagonal(previous);
		boolean winOrNot2=checkHorizontal(previous);
		boolean winOrNot3=checkVertical(previous);
		if(winOrNot1==true||winOrNot2==true||winOrNot3==true) {
			System.out.print("Winner is "+winnerChecker);
			return true;
		}
		else return false;
		
	}
public boolean checkFull() {
		for(int i=0;i<7;i++) {
			if(grid[0][i]==0) {
				return false;
			}
		}
		return true;
	}
/*
	 * check if the board is full
	 * if the first row has a 0, then it means player haven't dropped in that position
	 */
	





}
