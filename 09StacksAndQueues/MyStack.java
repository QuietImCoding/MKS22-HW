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

    public static void main(String[]args) {
	MyStack<Integer> pancakes = new MyStack<Integer>();
	int size = (int)(Math.random()*100);
	System.out.println("Size: "+size);
	int suma = 0;
	int sumb = 0;
	for(int i = 0; i < size; i++) {
	    int mynum =  (int)(Math.random()*1000);
	    pancakes.push(mynum);
	    System.out.println(mynum);
	    suma += mynum;
	}
	System.out.println("====================");
	for(int i = 0; i < size; i++) {
	    int mynum = pancakes.pop();
	    sumb += mynum;
	    System.out.println(mynum);
	}

	System.out.println("\n\n" + (suma == sumb));
    }
}
