package com.farhad.tictactoeconsole;

import java.util.Scanner;

public class Game {
	
	Board position = new Board();

	public static void main(String[] args) {
    char board[] = {'0','1','2','3','4','5','6','7','8'};
	Board p1 = new Board(board);
	p1.printBoard();
	final Game game = new Game();
	
                       for(int i = 0 ;i < 9;i++){
						System.out.println("Your move!");
						Scanner sc2 = new Scanner(System.in);
						int n = sc2.nextInt();
						    game.move(n);
							board[n] = 'X';
							p1.printBoard();
						
						if(! game.position.gameEnd()){
							int best = game.position.bestMove();
							System.out.println("computer moved: "+best);
							game.move(best);
							board[best] = 'O';
							p1.printBoard();
						}
						if( game.position.gameEnd()){

							if(game.position.win('x')){
								System.out.println("You Won!");
								break;
							}else if(game.position.win('o')){
								System.out.println("Computer Won!");
								break;
							}else{
								System.out.println("It's a Draw");
								break;
							}						
						}						 
                 }             
	}
	
	protected void move(int idx) {
		position = position.move(idx);
	}	  
	  
}
