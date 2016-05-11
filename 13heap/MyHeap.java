import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private int size;
    private T[] data;
    private boolean maxHeap;

    public MyHeap() {
	maxHeap = true;
	data = (T[]) new Comparable[2]; 
	size = 1;
    }

    public MyHeap(T[] array) {
        maxHeap = true;
	data = (T[]) new Comparable[array.length+1];
	size = data.length;
	for(int i = 0 ; i < array.length; i++) {
		    data[i+1] = array[i];
	}
	heapify();
    }

    public MyHeap(boolean isMax) {
	maxHeap = isMax;
	data = (T[]) new Comparable[2];
	size = 1;
    }

    public MyHeap(T[] array, boolean isMax) {
	maxHeap = isMax;
	data = (T[]) new Comparable[array.length+1];
	size = data.length;
	for(int i = 0 ; i < array.length; i++) {
		    data[i+1] = array[i];
	}
	heapify();
    }
    
    private int swap(int pos1, int pos2) {
	T temp = data[pos1];
	data[pos1] = data[pos2];
	data[pos2] = temp;
	return pos2;
    }

    private int compare(T itema, T itemb) {
	if(maxHeap) {
	    return itema.compareTo(itemb);
	} else {
	    return - (itema.compareTo(itemb));
	}
    }
    
    private void pushDown(int k) {
	while(data[k] != null && k*2 < size && k * 2 + 1  < size && (compare(data[k],data[k*2])<0 || compare(data[k], data[k*2+1])<0)) {
	    //System.out.println(this);
	    if( compare(data[k], data[k*2])<0 ) {
		k = swap(k, k*2);
		//k*=2;
	    } else {
		k = swap(k, k*2+1);
	    }
	}	
    }

    private void pushUp(int k) {
	while(data[k] != null && data[k/2]!=null && (compare(data[k], data[k/2])>0)) {
	    //System.out.println(this);
	    if(compare(data[k],data[k/2])>0) {
		k = swap(k, k/2);
	    }
	}
    }

    private void heapify() {
	int position = size/2;
	//doubleSize();
	while(position>1) {
	    //System.out.println(this);
	    if(position * 2 < size && compare(data[position*2], data[position])>0) {
		pushUp(position*2);
	    } 
	    if (position * 2 + 1<size && compare(data[position*2+1], data[position])>0) {
		pushUp(position*2+1);
	    }
	    position--;
	    
	}   
    }

    public T delete() {
	T temp = data[1];
	data[1] = data[size-1];
	pushDown(1);
	size--;
	return temp;
    }

    public void add(T x) {
	//System.out.println(size);
	if(size==0) {
	    data[1]=x;
	    size++;
	} else {
	    if (size>data.length-1) {
		doubleSize();
	    }
	    data[size] = x;
	    pushUp(size);
	    size++;
	}
    }

    private void doubleSize() {
	T[] temp = (T[]) new Comparable[data.length*2+1];
	for(int i = 1; i < data.length; i++) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    public String toString() {
	String s = "[ ";
	for (int i = 0; i < size; i++) {
	    s += data[i] + " ";
	}
	s += "]";
	return s + " size: " + size;
    }

    
    
    //do this last


    public static void main(String[]args) {
	MyHeap<Integer> h = new MyHeap<Integer>();
	h.add(10);
	System.out.println(h);
	h.add(20);
	h.add(3);
	h.add(11);
	System.out.println(h);
	Integer[] data = { 99};
	h = new MyHeap<Integer>(data,false);
	System.out.println(h);
	h.delete();
	System.out.println(h);
    }
    
}
