public class MyLinkedList {

    public class LNode {

	private int value;

	private LNode next;

	public LNode(int value) {
	    this.value = value;
	}
	public int getValue() {
	    return value;
	}
	public LNode getNext() {
	    return next;
	}
	public void setValue(int value) {
	    this.value = value;
	}
	public void setNext(LNode next) {
	    this.next = next;
	}
    }

    LNode start;
    
    public boolean add(int number) {
	if (start == null) {
	    start = new LNode(number);
	} else {
	    LNode current = start;
	    while (current.getNext()!=null) {
		current = current.getNext();
	    }
	    current.setNext(new LNode(number));
	}
	return true;
    }

    public int get(int index) {
	if(index<size()){
	    int current = start;
	    int myindex = 0;
	    while (myindex < index) {
		current = current.getNext();
		myindex++;
	    }
	}
    }

    public int size() {
	if (start == null) {
	    return 0;
	}
	else {
	    LNode current = start;
	    int mysize = 0;
	    while (current.getNext()!=null) {
		mysize++;
		current = current.getNext();
	    } 
	    mysize++;
	    return mysize;
	}
    }
		
		
    public String toString() {
	LNode current = start;
	if(current == null) {
	    return "[ ]" ;
	}
	String s = "[ ";
	while(current.getNext()!=null){ 
	    s += current.getValue() + " ";
	    current = current.getNext();
	}
	s+=current.getValue() + " ]";
	return s;
    }
}
