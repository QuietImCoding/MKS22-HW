import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private int size;
    private T[] data;

    public MyHeap() {
	data = (T[]) new Comparable[1]; 
	size = 0;
    }

    public MyHeap(T[] array) {
	data = array;
	heapify();
    }

    private int swap(int pos1, int pos2) {
	T temp = data[pos1];
	data[pos1] = data[pos2];
	data[pos2] = temp;
	return pos2;
    }

    private int compare() {
	if(
    private void pushDown(int k) {
	while(data[k] != null && (compare(data[k],data[k*2])<0 || compare(data[k], data[k*2+1])<0)) {
	    if(compare(data[k], data[k*2])<0) {
		k = swap(k, k*2);
		//k*=2;
	    } else {
		k = swap(k, k*2+1);
	    }
	}	
    }

    private void pushUp(int k) {
	while(data[k] != null && (data[k].compare(data[k/2])>0)) {
	    if(data[k].compare(data[k/2])>0) {
		k = swap(k, k*2);
	    }
	}
    }

    private void heapify() {
    }

    public T delete() {
	return null;
    }

    public void add(T x) {
	if(data[size+1]==null) {
	    data[size+1]=x;
	}
    }

    private void doubleSize() {
	T[] temp = new T[data.length*2];
	for(int i = 0; i < temp.length; i++) {
	    temp[i] = data[i];
	}
	data = temp;
    }

    public String toString() {
	String s = "[ ";
	for (int i = 1; i < data.length; i++) {
	    s += data[i] + " ";
	}
	s += "]";
    }
    
    //do this last
    //public MyHeap(boolean isMax)
    //public MyHeap(T[] array, boolean isMax)
    
}
