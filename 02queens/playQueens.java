public class playQueens {
    public static void main(String[]args) {
	Board b = new Board(10);
	System.out.println(b.solve());
	b.printBoard();
    }
}
