import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    public static void main(String[] args) {

        Scanner in = new Scanner ( System.in );
        do {
            String player1 = "X";
            clearBoard ();

            while (true)
            {
                System.out.println ( "Player " + player1 );
                int rowMove = SafeInput.getRangedInt ( in, "Enter row: ", 1, 3 );
                int colMove = SafeInput.getRangedInt ( in, "Enter col: ", 1, 3 );
                rowMove--;
                colMove--;
                board[rowMove][colMove] = player1;
                display ();
                if (isWin ( player1 )) {
                    System.out.println ( "Player " + player1 + " wins!" );
                    break;
                } else if (isTie ()) {
                    System.out.println ( "it's a tie!" );
                    break;
                } else if (player1 == "X")
                    player1 = "O";
                else {
                    player1 = "X";
                    System.out.println ("Invalid move! TRY again");
                }
            }
        } while (SafeInput.getYNConfirm ( in, "\nDo you want to continue playing Tic Tac Toe? " ));
    
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()
    {
        System.out.println ("_________");
        for (int row = 0; row < ROW; row++) {
        for (int col = 0; col < COL; col++)
        {
            System.out.println (" | "+ board[row][col] +" ");
        }

            System.out.println ("_________");
    }
    }

    private static boolean isValidMove(int row, int col) {
        boolean valMove = false;
        if (board[row][col].equals ( " " )) {
            valMove = true;
        } else {
            System.out.println ( " Illegal move !" );
        }
        return valMove;
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals ( player ) && board[1][col].equals ( player ) && (board[2][col].equals ( player )))
                return true;
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals ( player ) && board[row][1].equals ( player ) && (board[row][2].equals ( player )))
                return true;
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board[1][1].equals ( player ) && ((board[0][0].equals ( board[1][1] ) && board[1][1].equals ( board[2][2] )) ||
                (board[0][2].equals ( board[1][1] ) && board[1][1].equals ( board[2][0] ))))
            return true;
        return false;
    }

    private static boolean isWin(String player) {
        if (isColWin ( player ) || isRowWin ( player ) || isDiagonalWin ( player )) {
            return true;
        }
        return false;
    }

    private static boolean isTie() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col].equals ( " " ))
                    return false;
            }
        }
        return true;
    }
}

