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
	data = (T[]) new Object[8];
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
	data[end] = value;
	size++;
    }

    public T removeFirst() {
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
	return (T)data[start];
    }

    public T getLast() {
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
	for (int i = 0; i < 8; i++) {
	    dq.addLast((int)(Math.random()*i));
	    System.out.println(dq);
	}
	dq.grow();
	dq.debug();
	for (int i = 0; i < 8; i++) {
	    System.out.println(dq.getLast());
	    System.out.println(dq.removeLast());
	    System.out.println(dq);
	}
    }
}
