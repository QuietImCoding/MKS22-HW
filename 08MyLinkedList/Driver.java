public class Driver {
    public static char pickChar() {
	return (char)((int)((Math.random()*30)+40));
    }
    public static void main(String[]args) {
	MyLinkedList<String> l = new MyLinkedList<String>();
	for(int i = 0; i < (int)(Math.random()*30); i++) {
	    l.add(""+pickChar()+pickChar()+pickChar()+pickChar());
	}
	System.out.println(l);
	System.out.println("Size: " + l.size());
	int testelement = (int)(Math.random()*l.size());
	System.out.println(testelement + "th element: " + l.get(testelement));
	testelement = (int)(Math.random()*l.size());
	l.set(testelement, "MAGIC");
	System.out.println("Replaced: " + testelement + "th element with " + l.get(testelement));
	System.out.println(l);
	l.remove(testelement);
	System.out.println(l);
	int addIndex = (int)(Math.random()*l.size());
	l.add("WITCHCRAFT!", addIndex);
	System.out.println("Added WITCHRAFT! to " + addIndex);
	System.out.println(l);
	System.out.println("Size: " + l.size());
	System.out.println(l.indexOf("WITCHCRAFT!"));
    }
}
