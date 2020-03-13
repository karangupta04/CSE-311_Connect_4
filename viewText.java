import java.util.Arrays;
import java.util.Scanner;

public class viewText {
	private int player = 0;
	private int counter = 0;
	Scanner in = new Scanner(System.in);
	Model model = new Model(player,counter);

	
	public void startConnect4() {
		while(counter<42) {
			player=model.turn(counter);//change player
			System.out.println("Now is Player"+player+" turns");
			System.out.println("Enter the column you want to drop: ");
			int column=in.nextInt();//get the column from player
			model.dropCoin(column);//drop the coin
			boolean winOrNot = model.checkWinner(player);//check if player wins
			if(winOrNot==true) {
				System.out.println("Player "+player+" Wins the Game!");
				break;
			}
			if(model.checkFull()==true) {
				System.out.println("Tie!");//check tie
				break;
			}
			
			System.out.println(Arrays.deepToString(model.getGrid()));//print out the board
			System.out.println("Next turn!");
			counter++;
			
			
		}
	}
	

}
