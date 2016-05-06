import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private int size;
    private T[] data;

    public MyHeap() {
	data = new (T[])Comparable[1];
	size = 0;
    }

    public MyHeap(T[] array) {
	data = array;
	heapify();
    }
    
    private void pushDown(int k) {
    }

    private void pushUp(int k) {
    }

    private void heapify() {
    }

    public T delete() {
	return null;
    }

    public void add(T x) {
	
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
	for (int i = 0; i < data.length; i++) {
	    s += data[i] + " ";
	}
	s += "]";
    }
    
    //do this last
    //public MyHeap(boolean isMax)
    //public MyHeap(T[] array, boolean isMax)
    
}
