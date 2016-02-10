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

    void printBoard() {
	String s = "";
	for (int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		s += board[x][y] + " ";
	    }
	    s += "\n";
	}
    }
    
    void display() {
	float cellSize;
	strokeWeight(3);
	for ( int x = 0; x < board.length; x++ ) {
	    for ( int y = 0; y < board[x].length; y++ ) {
		cellSize = (float)width/board.length;
		stroke(0);
		fill(255 * ((x + y + 1) % 2));
		rect(x * cellSize, y * cellSize, cellSize, cellSize);
		if ( board[x][y] < 0 ) {
		    stroke(255, 0, 5 * abs(board[x][y]));
		    line(x * cellSize, y * cellSize, (x + 1) * cellSize, (y + 1) * cellSize);
		}
		if ( board[x][y] == 1) {
		    stroke(255, 0, 0);
		    fill(255, 0, 0);
		    ellipse((x * cellSize)+(cellSize/2), (y * cellSize) + (cellSize/2), cellSize/2, cellSize/2);
		}
	    }
	}
    }
}
