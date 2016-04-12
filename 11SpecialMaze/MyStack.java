import java.util.*;

public class MyStack<T> {
    
    private MyLinkedList<T> q;
    
    public MyStack() {
	q = new MyLinkedList<T>();;
    }

    public void push(T item) {
	q.add(0,item);
    }

    public T pop() {
	if(q.size()>0){
	    return q.remove(0);
	} else {
	    throw new NoSuchElementException();
	}
    }
    
    public T peek() {
	if(q.size()>0) {
	    return q.get(0);
	} else {
	    throw new NoSuchElementException();
	}
    }

    public int size() {
	return q.size();
    }

    public boolean isEmpty() {
	return size() == 0;
    }

}
