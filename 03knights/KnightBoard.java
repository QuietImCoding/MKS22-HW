public class KnightBoard {
    int[][] board; 
    static boolean DEBUG = false;

    KnightBoard(int rows, int cols) {
	board = new int[rows][cols];
	for (int row = 0; row < board.length; row++) {
	    for (int col = 0; col < board[row].length; col++) {
		board[row][col] = 0;
	    }
	}
    }

    public void debug(String s) {
	if (DEBUG) {
	    System.out.println(s);
	}
    }

    boolean solve() {
	return solveHelper(0,0,1);
    }

    boolean solveHelper(int row, int col, int number) {
	//printBoard();
	debug("====================");
       	if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
	    return false;
	}
	if (board[row][col] != 0) {
	    return false;
	}
	board[row][col] = number;
	debug("Row: " + row + ", Col: " + col + ", Number: " + number);
	if (number == board.length * board[0].length) {
	    return true;
	} 
	if (solveHelper(row+2, col+1, number+1) ||
	    solveHelper(row+2, col-1, number+1) ||
	    solveHelper(row+1, col+2, number+1) ||
	    solveHelper(row+1, col-2, number+1) ||
	    solveHelper(row-1, col+2, number+1) ||
	    solveHelper(row-1, col-2, number+1) ||
	    solveHelper(row-2, col+1, number+1) ||
	    solveHelper(row-2, col-1, number+1) ){
	    return true;
	} else {
	    board[row][col] = 0;
	}
	return false;
    }

    void printBoard() {
	String s = "";
	for (int row = 0; row < board.length; row++) {
	    for (int col = 0; col < board[row].length; col++) {
		if(board[row][col] < 10) {
		    s+=" " + board[row][col] + " ";
		}
		else {
		    s+=board[row][col] + " ";
		}
	    }
	    s += "\n";
	} 
	System.out.println(s);
    }
}
