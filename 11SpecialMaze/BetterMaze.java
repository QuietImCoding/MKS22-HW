import java.util.*;
import java.io.*;

public class BetterMaze {
    
    private class Node {
	private int x, y;
	private Node prev;
	Node(int x, int y, Node prev){
	    this.x = x;
	    this.y = y;
	    this.prev = prev;
	}
	public int getX() {
	    return x;
	}
	public int getY() {
	    return y;
	}
	public Node getPrev() {
	    return prev;
	}
	public String toString() {
	    return "( " + x + ", " + y + " )";
	}
    }

    private char[][] maze;
    private ArrayList<Integer>    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/

    public static void main(String[]args) {
	BetterMaze b = new BetterMaze("data.dat");
	b.setAnimate(true);
	System.out.println(b.solveBFS());
	System.out.print("[ ");
	for ( int i : b.solutionCoordinates() ) {
	    System.out.print(i + " ");
	}
	System.out.println("]");
	System.out.println(b);
    }
	    
    public int[] solutionCoordinates(){
        int[] solArray = new int[solution.size()];
	for (int i = 0; i < solution.size(); i++) {
	    solArray[i] = solution.get(i);
	}
	return solArray;
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();
	return solve();
    }    

    public ArrayList<Node> getFriends(Node sad) {
	ArrayList<Node> friends = new ArrayList<Node>();
	int myX = sad.getX();
	int myY = sad.getY();
	if(maze[myX-1][myY]!='.' && maze[myX-1][myY]!='#') {
	    friends.add(new Node(myX-1, myY, sad));
	}
	if(maze[myX+1][myY]!='.' && maze[myX+1][myY]!='#') {
	    friends.add(new Node(myX+1, myY, sad));
	}
	if(maze[myX][myY-1]!='.' && maze[myX][myY-1]!='#') {
	    friends.add(new Node(myX, myY-1, sad));
	}
	if(maze[myX][myY+1]!='.' && maze[myX][myY+1]!='#') {
	    friends.add(new Node(myX, myY+1, sad));
	}
	return friends;
    }
	
   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
        Node current = new Node(startRow, startCol, null);
	placesToGo.add(current);
	maze[current.getX()][current.getY()] = '.';
	while(placesToGo.hasNext()) {
	    if(getFriends(current).size()>0) {
		for (Node friend : getFriends(current)) {
		    if(maze[friend.getX()][friend.getY()]=='E') current = friend;
		    else {
			maze[friend.getX()][friend.getY()] = '.';
			placesToGo.add(friend);
			System.out.println(friend);
		    }
		    System.out.println(this);
		}
		if(maze[current.getX()][current.getY()]=='E') {
		    while(current.getPrev()!=null) {
			maze[current.getX()][current.getY()] = '*';
			solution.add(0,current.getY());
			solution.add(0, current.getX());
			current = current.getPrev();
		    }
		    return true;
		}
	    } 
	    current = placesToGo.next();
	}

	return false;
    }    
    
    /*
      if(maze[myX-1][myY]!='.' && maze[myX-1][myY]!='#') {
      placesToGo.add(new Node(myX-1, myY, current));
      maze[myX-1][myY] = '.';
      }
      if(maze[myX+1][myY]!='.' && maze[myX+1][myY]!='#') {
      placesToGo.add(new Node(myX+1, myY, current));
      maze[myX][myY] = '.';
      }
      if(maze[current.getX()][current.getY()-1]!='.' && maze[current.getX()][current.getY()-1]!='#') {
      placesToGo.add(new Node(current.getX(), current.getY()-1, current));
      maze[current.getX()][current.getY()-1] = '.';
      }
      if(maze[current.getX()][current.getY()+1]!='.' && maze[current.getX()][current.getY()+1]!='#') {
      placesToGo.add(new Node(current.getX(), current.getY()+1, current));
      maze[current.getX()][current.getY()+1] = '.';
      }
    */

   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){ animate = b; }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	solution = new ArrayList<Integer>();
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    


       
    
    

}
