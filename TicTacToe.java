import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static char currentPlayer = 'X';
    
    public static void main(String[] args) {
     
        while (true) {
            printBoard();
            playerMove();
            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            switchPlayer();
        }
    }

    // Print the current state of the board
    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n---------");
        }
    }

    // Handle the player's move
    public static void playerMove() {
        Scanner sc = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
            row = sc.nextInt() - 1; 
            col = sc.nextInt() - 1; 
            
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    public static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;

        return false;
    }

    
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
