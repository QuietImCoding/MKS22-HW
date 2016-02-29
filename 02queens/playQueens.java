public class playQueens {
    public static void main(String[]args) {
	QueenBoard b = new QueenBoard(4);
	b.solve();
	b.printSolution();
    }
}
