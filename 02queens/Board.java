public class Board {
    int n;
    int[][] board; 

    Board(int n) {
	this.n = n;
	board = new int[n][n];
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		board[x][y] = 0;
	    }
	}
    }

    void add(int xcor, int ycor, int change) {
	for ( int x = 0; x < board.length; x++ ) {
	    board[x][ycor] -= change;
	}
	for ( int y = 0; y < board[xcor].length; y++ ) {
	    board[xcor][y] -= change;
	}
	int d = 1;
	for ( d = 0; xcor + d < board.length && ycor + d < board[xcor].length; d++ ) {
	    board[xcor + d][ycor + d] -= change;
	}
	for ( d = 0; xcor - d >= 0 && ycor - d >= 0; d++) {
	    board[xcor-d][ycor-d] -= change;
	}
	for ( d = 0; xcor - d >= 0 && ycor + d < board[xcor].length; d++ ) {
	    board[xcor - d][ycor + d] -= change;
	}
	for ( d = 0; xcor + d < board.length && ycor - d >= 0; d++ ) {
	    board[xcor + d][ycor - d] -= change;
	}
	if (change == 1) {
	    board[xcor][ycor] = 1;
	} 
	if (change <= -1 ){
	    board[xcor][ycor] = 0;
	}
    }

    void add(int xcor, int ycor) {
	add(xcor, ycor, 1);
    }

    void remove(int xcor, int ycor) {
	add(xcor, ycor, -1);
    }

    boolean solve() {
	return solveHelper(0);
    }

    boolean solveHelper(int x) {
	if (x == board.length-1) {
	    return true;
	}
	for (int y = 0; y  < board[0].length; y++) {
	    if (board[x][y] == 0) {
		add(x,y);
		return solveHelper(x+1);
	    }
	    if (board[x][y] < 0) {
		remove(x,y);
		return false;
	    }
	}
	return false;
    }

    void printBoard() {
	String s = "";
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] == 1) {
		    s += "Q ";
		}
		if (board[x][y] < 0) {
		    s += "/ ";
		}
		if (board[x][y] == 0) {
		    s += "_ ";
		}
	    }
	    s += "\n";
	} 
	System.out.println(s);
    }
}
