public class Driver {
    public static void main(String[]args) {
	BSTree<Integer> twee = new BSTree<Integer>();
	for(int i = 0; i < 10; i++) {
	    twee.add((int)(Math.random()*10));
	    System.out.println(twee);
	}
    }
}
