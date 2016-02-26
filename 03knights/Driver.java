public class Driver {
    public static void main(String[]args) {
	KnightBoard k = new KnightBoard(7,7);
	System.out.println(k.solve());
	k.printBoard();
    }
}
