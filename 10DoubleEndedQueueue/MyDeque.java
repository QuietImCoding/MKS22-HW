import java.util.*;

public class MyDeque<T> {

    private Object[] data;
    private int start, end, size;

    public void debug() {
	System.out.println(this);
	System.out.println("START: " + start);
	System.out.println("END: " + end);
    }
    
    @SuppressWarnings("unchecked")
    private MyDeque() {
	data = (T[]) new Object[4];
	start = data.length/2;
	end = data.length/2;
	size = 0;
    }

    public void grow() {
	Object[] blub = (T[]) new Object[data.length*2];
	for(int i = 0; i <= start; i++){
	    blub[i] = data[i];
	}
	for(int j = 0; j < data.length - start - 1; j++) {
	    blub[blub.length-1-j] = data[data.length-1-j];
	    end = blub.length-1-j;
	}
	data = blub;
    }
    
    public void addFirst(T value) {
	if(start>0) {
	    start--;
	} else {
	    start = data.length-1;
	}
	if(data[start]!=null) {
	    grow();
	    start = end-1;
	}
	data[start] = value;
	size++;
    }

    public void addLast(T value) {
	if(end<(data.length-1)){
	    end++;
	} else {
	    end = 0;
	}
	if(data[end]!=null) {
	    grow();
	}
	data[end] = value;
	size++;
    }

    public T removeFirst() {
	if (size==0) throw new NoSuchElementException();
	if(start>0){
	    start--;
	}else{
	    start=data.length-1;
	}
	T first = (T)data[start];
	data[start]=null;
	size--;
	return first;
    }

    public T removeLast() {
	if (size==0) throw new NoSuchElementException();
	T last = (T)data[end];
	data[end]=null;
	if(end<data.length-1){
	    end++;
	}else{
	    end = 0;
	}
	size--;
	return last;
    }

    public T getFirst() {
	if((T)data[start]==null) throw new NoSuchElementException();
	return (T)data[start];
    }

    public T getLast() {
	if((T)data[start]==null) throw new NoSuchElementException();
	return (T)data[end];
    }

    public String toString() {
	String s = "[ ";
	for(int i = 0;i < data.length;i++) {
	    if(data[i]==null){ 
		s+= "X";
	    } else {
		s+= data[i];
	    }
	    s+=" ";
	}
	s+=" ]";
	return s;
    }

    public static void main(String[]args) {
	MyDeque<Integer> dq = new MyDeque<Integer>();
	for (int i = 0; i < 10; i++) {
	    dq.addFirst((int)(Math.random()*1000));
	    System.out.println(dq);
	}
	for (int j = 0; j < 10; j++) {
	    dq.removeFirst();
	    System.out.println(dq);
	}
	//dq.grow();
	//dq.debug();
    }
}
