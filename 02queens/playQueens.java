public class playQueens {
    public static void main(String[]args) {
	Board b = new Board(4);
	//b.add(2,2);
	System.out.println(b.solve());
	b.printBoard();
    }
}
