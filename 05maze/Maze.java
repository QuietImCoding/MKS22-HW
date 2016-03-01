import java.util.*;
import java.io.*;

public class Maze{

    Scanner infile;
    private char[][]maze;
    private int startx,starty;
    private boolean animate;
    private static boolean DEBUG = false;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
        //COMPLETE CONSTRUCTOR
	String letters = "";
	int rows = 0;
	int cols = 0;
	animate = ani;
	try {
	    infile = new Scanner(new File(filename));
	} catch (FileNotFoundException e) {
	    System.out.println("You goofed. Pick a valid file");
	}
	while (infile.hasNextLine()) {
	    rows++;
	    letters += infile.nextLine();
	}
	cols = letters.length()/rows;
	maze = new char[rows][cols];
        //System.out.println("ROWS: " + rows + " COLS: " + cols);
	for (int row = 0; row < rows; row++) {
	    for (int col = 0; col < cols; col++) {
		if (letters.charAt((row*cols)+col)=='S') {
		    startx = col;
		    starty = row;
		}
		maze[row][col] = letters.charAt((row * cols) + col);
	    }
	}
    }


    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(20);
        }
	if(maze[y][x]=='#'){
	    return false;
	}
	if(maze[y][x]=='@') {
	    return false;// maze[y][x]='.';
	}
	if(maze[y][x]=='.') {
	    return false;
	}
	if(maze[y][x]=='E') {
	    return true;
	}
	maze[y][x] = '@';
	if(solve(x+1, y)||
	   solve(x-1, y)||
	   solve(x, y-1)||
	   solve(x, y+1)) {
	    return true;
	} else {
	     maze[y][x] = '.';
	}
        return false; //so it compiles
    }



    //FREE STUFF!!! *you should be aware of this*


    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }


    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
	if (!DEBUG) {
	    if(animate){

		ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";

	    }
	    for(int i = 0; i < maxx * maxy; i++){
		if(i % maxx == 0 && i != 0){
		    ans += "\n";
		}
		char c =  maze[i % maxx][i / maxx];
		if(c == '#'){
		    ans += color(38,47)+c;
		}else{
		    ans += color(33,40)+c;
		}
	    }
	    return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
	}
	else {
	    for (int row = 0; row < maze.length; row++) {
		for (int col = 0; col < maze[row].length; col++) {
		    ans+=maze[row][col];
		}
		ans+="\n";
	    }
	    return/* HIDE_CURSOR + go(0,0) +*/ ans/* + "\n" + SHOW_CURSOR*/;
	}
    }


    //MORE FREE STUFF!!! *you can ignore all of this*

    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    

    //END FREE STUFF



}
