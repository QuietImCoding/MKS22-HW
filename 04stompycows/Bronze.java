import java.io.*;
import java.util.*;

public class Bronze {
    private static int[][] lake;
    private static int rows, cols, elevation, commands;
    private static Scanner infile;
    private static boolean DEBUG = false;

    public static void debug(Object s) {
	if (DEBUG) {
	    System.out.println(s);
	}
    }
    
    public static void printLake() {
	if (DEBUG) {
	for (int r = 0; r < lake.length; r++) {
	    for (int c = 0; c < lake[0].length;c++) {
		System.out.print("" + lake[r][c] + ' ');
	    }
	    System.out.println();
	}
	}
    }

    public static int findMaxinSquare(int R_s, int C_s) {
	int maxval = 0;
	for ( int row = R_s-1; row < lake.length && row < R_s+2; row++ ) {
	    for ( int col = C_s-1; col < lake[0].length && col < C_s+2; col++) {
		//System.out.println(lake[row][col]);
		if (lake[row][col] > maxval) {
		    maxval = lake[row][col];
		}
	    }
	}
	return maxval;
    }

    public static void stomp(int R_s, int C_s, int depth) {
	int cap = findMaxinSquare(R_s, C_s) - depth;
	for ( int row = R_s-1; row < lake.length && row < R_s+2; row++ ) {
	    for ( int col = C_s-1; col < lake[0].length && col < C_s+2; col++) {
		if (lake[row][col] > cap) {
		    lake[row][col] = cap;
		}
	    }
	}
    }
    
    public static void main(String[]args) {
	// Load file
	try {
	    infile = new Scanner(new File("makelake.in"));
	} catch (FileNotFoundException e) {
	    System.out.println("get out");
	}
	// Read first row and initalize lake
	rows = Integer.parseInt(infile.next());
	cols = Integer.parseInt(infile.next());
	lake = new int[rows][cols];
	elevation = Integer.parseInt(infile.next());
	commands = Integer.parseInt(infile.next());
	// Fill lake array
	for (int r = 0; r < rows; r++) {
	    for (int c = 0; c < cols; c++) {
		lake[r][c] = Integer.parseInt(infile.next());
	    }
	}
	debug("" + rows + " " + cols + " " + elevation + " " + commands);
	printLake();
	for (int i = 0 ; i < commands; i++) {
	    int R_s = Integer.parseInt(infile.next());
	    int C_s = Integer.parseInt(infile.next());
	    int stompDepth = Integer.parseInt(infile.next());
	    debug(R_s + " " + C_s + " " + stompDepth + " ");
	    stomp(R_s, C_s, stompDepth);
	    printLake();
	}
	int aggregatedepth = 0;
	for (int r = 0; r < lake.length; r++) {
	    for (int c = 0; c < lake[0].length; c++) {
		if ( lake[r][c] < elevation ) {
		    aggregatedepth += elevation - lake[r][c];
		}
	    }
	}
	debug(aggregatedepth);
	System.out.println(aggregatedepth * 72 * 72 + ",07,Monteagudo,Daniel");
    }
}
