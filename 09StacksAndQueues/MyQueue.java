import java.util.*;

public class MyQueue<T> {
    
    private MyLinkedList<T> q;
    
    public MyQueue() {
	q = new MyLinkedList<T>();;
    }

    void enqueue(T item) {
	q.add(item);
    }

    T dequeue() {
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
	    s+="\n============";
	}
	return s;
    }
}
