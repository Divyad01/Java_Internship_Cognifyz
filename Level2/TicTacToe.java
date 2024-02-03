import java.util.Scanner;

public class TicTacToe{
	private char[][] board;
	private char currentPlayer;
	
	public TicTacToe(){
		board =new char[3][3];
		currentPlayer ='X';
		initializeBoard();
	
	}
	
	
	private void initializeBoard(){
		for (int i = 0; i <3; i++){
			for (int j =0 ; j<3 ;j++){
				board[i][j] = '-';
			}
		}
	}
	
	
	private void printBoard(){
		for(int i =0 ;i <3 ; i++){
			for (int j =0;j<3;j++){
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	
	private boolean isBoardFull(){
		for(int i =0 ;i<3 ;i++){
			for(int j =0;j<3 ;j++){
				if (board[i][j] == '-'){
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean checkWin(){
		//checking the rows
		
		for(int i =0;i<3;i++){
			if(board[i][0] == currentPlayer &&
			board[i][1] ==currentPlayer &&
			board[i][2] == currentPlayer){
				return true;
			}
		}
		
		//checking for the columns
		for(int j=0 ; j<3;j++){
			if(board[0][j] == currentPlayer &&
			board[1][j] ==currentPlayer &&
			board[2][j] == currentPlayer){
				return true;
			}
		}
		
		//checking diagonals
		if (board[0][0] == currentPlayer &&
		board[1][1] == currentPlayer &&
		board[2][2] == currentPlayer){
			return true;
		}
		
		if(board[0][2]== currentPlayer &&
		board[1][1] ==currentPlayer && 
		board[2][0] == currentPlayer){
			return true;
		}
		return false;
	}
	
	private void changePlayer(){
		currentPlayer =(currentPlayer == 'X') ? 'O': 'X';
		
	}
	
	public void play(){
		Scanner scanner=new Scanner(System.in);
		boolean gameOver =false;
		
		
		while (!gameOver){
			System.out.println("Player" + currentPlayer+" 's turn");
			printBoard();
			System.out.println("Enter row (0-2) :");
			int row = scanner.nextInt();
			System.out.println("Enter column (0-2) :");
			int col=scanner.nextInt();
			
			
			if(row<0 || row >2 || col <0 || col>2 || board[row][col] != '-'){
				System.out.println("Invalid move.Try again.");
				continue;
			}
			
			board[row][col] =currentPlayer;
			
			if (checkWin()){
				System.out.println("Player" +currentPlayer + "wins!");
				gameOver =true;
			}
			else if(isBoardFull()){
				System.out.println("It's a draw!");
				gameOver =true;
			}
			else{
				changePlayer();
			}
		}
		scanner.close();
	}
	
	public static void main(String[] args){
		TicTacToe game=new TicTacToe();
		game.play();
	}

}