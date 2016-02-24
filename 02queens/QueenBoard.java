public class Board {
    int n;
    int[][] board; 

    static boolean DEBUG = false;

    Board(int n) {
	this.n = n;
	board = new int[n][n];
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		board[x][y] = 0;
	    }
	}
    }


    private boolean add(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean remove(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    boolean solve() {
	return solveHelper(0);
    }

    boolean solveHelper(int col) {
	if (DEBUG) {
	System.out.println("=========================");
	printBoard();
	}
	if (col == board.length) {
	    return true;
	}
	for (int row = 0 ; row < board[0].length; row++) {
	    if (add(row, col)) {
		if (solveHelper(col+1)) {
		    return true;
		}
		remove(row, col);
	    }
	}
	return false;
    }

    void printSolution() {
	String s = "";
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] == 1) {
		    s += "Q ";
		}
		if (board[x][y] < 0 && DEBUG) {
		    s += "/ ";
		}
		if (board[x][y] == 0 || board[x][y] < 0) {
		    s += "_ ";
		}
	    }
	    s += "\n";
	} 
	System.out.println(s);
    }
}
