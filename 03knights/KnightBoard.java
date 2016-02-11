public class KnightBoard {
    int n, move
    int[][] board; 

    Board(int n) {
	this.n = n;
	board = new int[n][n];
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		board[x][y] = 0;
	    }
	}
	move = 1;
    }

    void move(int type) {
	try {
	    if (type == 1) {
		x+=1;
		y-=2;
	    } if (type == -1) {
		x-=1;
		y+=-2;
	    } if (type == 2) {
		x+=2;
		y+=1;
	    } if (type == -2) {
		x-=2;
		y-=1;
	    } if (type == 3) {
		x-=1;
		y+=2;
	    } if (type == -3) {
		x+=1;
		y-=2;
	    }

    boolean solve() {
	return solveHelper(0);
    }

    boolean solveHelper(int x, int y) {
	System.out.println("=========================");
	printBoard();
	if (board[x][y] == 0 && x == board.length-1) {
	    return true;
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
