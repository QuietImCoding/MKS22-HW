public class MyLinkedList<T> {

    private class LNode {

	private T value;

	private LNode next;

	public LNode(T value) {
	    this.value = value;
	}
	public T getValue() {
	    return value;
	}
	public LNode getNext() {
	    return next;
	}
	public void setValue(T value) {
	    this.value = value;
	}
	public void setNext(LNode next) {
	    this.next = next;
	}
    }
   
    int size = 0;
    LNode start;
    LNode end;
    
    public boolean add(T number) {
	size++;
	if (start == null) {
	    start = new LNode(number);
	    end = start;
	    return true;
	} else {
	    end.setNext(new LNode(number));
	    end = end.getNext();
	}
	return true;
    }

    public int indexOf(T number) {
	LNode current = start;
	int myindex = 0;
	if(start!=null) {
	    while(current.getNext()!=null) {
		if(current.getValue().equals(number)) {
		    return myindex;
		}
		myindex++;
		current = current.getNext();
	    }
	}
	return -1;
	//throw new YouDunGoofedException();
    }
    
    public boolean add(T number, int index) {
	if(index<size()) {
	    size++;
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

    public T get(int index) {
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
	    //System.out.println("mistakes");
	    return null;
	    //throw new YouDunGoofedException();
	}
    }

    public T set(int index, T value) {
	if(index<size()){
	    LNode current = start;
	    int myindex = 0;
	    while (myindex < index) {
		current = current.getNext();
		myindex++;
	    }
	    T old = current.getValue();
	    current.setValue(value);
	    return old;
	}
	//System.out.println("mistakes");
	return null;
        //throw new YouDunGoofedException();
    }

    public T remove(int index) {
	if(index<size()) {
	    size--;
	    if(index == 0) {
		T myval = start.getValue();
		start = start.getNext();
		return myval;
	    }
	    LNode current = start;
	    int myindex = 0;
	    while (myindex < index-1) {
		current = current.getNext();
		myindex++;
	    }
	    if(current.getNext()!= null) {
		T myval = current.getNext().getValue();
		current.setNext(current.getNext().getNext());
		return myval;
	    }
	}
	//System.out.println("mistakes");
	return null;
	//throw new YouDunGoofedException();
    }
	    
    
    public int size() {
	/*
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
	    }*/
	return size;
    }
		
		
    public String toString() {
	LNode current = start;
	if(current == null) {
	    return "[ ]" ;
	}
	String s = "[ ";
	while(current.getNext()!=null){ 
	    s += current.getValue() + ", ";
	    current = current.getNext();
	}
	s+=current.getValue() + " ]";
	return s;
    }
}
