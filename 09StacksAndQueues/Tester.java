public class Tester {
    public static void main(String[]args) {
	MyQueue<Integer> q = new MyQueue<Integer>();
	MyStack<Integer> s = new MyStack<Integer>();
	s.push(10);
	System.out.println(s);
	s.push(20);
	System.out.println("\n" + s);
	s.pop();
	System.out.println("\n" + s);
    }
}
