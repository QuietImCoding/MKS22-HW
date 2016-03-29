import java.util.*;

public class MyStack<T> {
    
    private MyLinkedList<T> q;
    
    public MyStack() {
	q = new MyLinkedList<T>();;
    }

    void push(T item) {
	q.add(0,item);
    }

    T pop() {
	if(q.size()>0){
	    return q.remove(0);
	} else {
	    throw new NoSuchElementException();
	}
    }
    
    T peek() {
	if(q.size()>0) {
	    return q.get(0);
	} else {
	    throw new NoSuchElementException();
	}
    }

    int size() {
	return q.size();
    }

    boolean isEmpty() {
	return size() == 0;
    }

    public String toString() {
	String s = "";
	for(int i = 0; i < size(); i++) {
	    s+=q.get(i);
	    if(i<size()-1) s+="\n============\n";
	}
	return s;
    }
}
