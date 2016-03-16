public class Driver {
    public static void main(String[]args) {
	MyLinkedList l = new MyLinkedList();
	System.out.println(l.size());
	for(int i = 0; i < (int)(Math.random()*30); i++) {
	    l.add((int)(Math.random()*1000));
	}
	System.out.println(l);
	System.out.println("Size: " + l.size());
	int testelement = (int)(Math.random()*l.size());
	System.out.println(testelement + "th element: " + l.get(testelement));
	int addIndex = (int)(Math.random()*l.size());
	l.add(12345, addIndex);
	System.out.println("Added 12345 to " + addIndex);
	System.out.println(l);
    }
}