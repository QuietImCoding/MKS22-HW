public class MyLinkedList {

    private class LNode {

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
	    return true;
	} else {
	    LNode current = start;
	    while (current.getNext()!=null) {
		current = current.getNext();
	    }
	    current.setNext(new LNode(number));
	}
	return true;
    }

    public int indexOf(int number) {
	LNode current = start;
	int myindex = 0;
	if(start!=null) {
	    while(current.getNext()!=null) {
		if(current.getValue() == number) {
		    return myindex;
		}
		myindex++;
		current = current.getNext();
	    }
	}
	return -1;
    }
    
    public boolean add(int number, int index) {
	if(index<size()) {
	    if (index == 0) {
		LNode newHead = new LNode(number);
		newHead.setNext(start);
		start = newHead;
		return true;
	    }
	    LNode current = start;
	    int myindex = 0;
	    while (myindex < index - 1) {
		current = current.getNext();
		myindex++;
	    }
	    LNode rest = current.getNext();
	    current.setNext(new LNode(number));
	    current.getNext().setNext(rest);
	    return true;
	}
	return false;
    }

    public int get(int index) {
	if(index<size()){
	    LNode current = start;
	    int myindex = 0;
	    while (myindex < index) {
		current = current.getNext();
		myindex++;
	    }
	    return current.getValue();
	}
	else {
	    return -1;
	}
    }

    public int set(int index, int value) {
	if(index<size()){
	    LNode current = start;
	    int myindex = 0;
	    while (myindex < index) {
		current = current.getNext();
		myindex++;
	    }
	    int old = current.getValue();
	    current.setValue(value);
	    return old;
	}
	return -1;
    }

    public int remove(int index) {
	if(index<size()) {
	    if(index == 0) {
		int myval = start.getValue();
		start = start.getNext();
		return myval;
	    }
	    LNode current = start;
	    int myindex = 0;
	    while (myindex < index-1) {
		current = current.getNext();
		myindex++;
	    }
	    if(current.getNext()!=null) {
		int myval = current.getNext().getValue();
		current.setNext(current.getNext().getNext());
		return myval;
	    }
	}
	return -1;
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
