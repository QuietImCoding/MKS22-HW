import java.util.*;

public class RunningMedian {
    
    private MyHeap<Integer> bigheap, littleheap;
    
    public RunningMedian() {
	bigheap = new MyHeap<Integer>(false);
	littleheap = new MyHeap<Integer>();
    }

    public double getMedian() {
	if(bigheap.getSize()==1&&littleheap.getSize()==1) {
	    throw new NoSuchElementException("Why do you do these things?");
	} else {
	    if(bigheap.getSize() > littleheap.getSize()) {
		return (double)(bigheap.delete());
	    }
	    if(littleheap.getSize() > bigheap.getSize()) {
		return (double)(littleheap.delete());
	    }
	    return ((double)(bigheap.delete()) + (double)(littleheap.delete()) / 2);
	}
    }

    public void add(Integer x) {
	if (x < littleheap.peek()) {
	    littleheap.add(x);
	} else {
	    bigheap.add(x);
	}

	if(littleheap.getSize() > bigheap.getSize()) {
	    bigheap.add(littleheap.delete());
	} else if (bigheap.getSize() > littleheap.getSize()) {
	    littleheap.add(bigheap.delete());
	}
    }

    public static void main(String[]args) {
	RunningMedian med = new RunningMedian();
	med.add(3);
	med.add(4);
	med.add(5);
	System.out.println(med.getMedian());
    }
	    
}
