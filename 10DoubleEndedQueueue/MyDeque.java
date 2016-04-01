public class MyDeque<T> {

    private Object[] data;
    private int start, end, size;
  
    private MyDeque() {
	data = new Object[8];
	start = data.length/2;
	end = data.length/2;
	size = 0;
    }

    public void addFirst(T value) {
	if(start>0) {
	    start--;
	} else {
	    start = data.length-1;
	}
	data[start] = value;
    }

    public void addLast(T value) {
	if(end<(data.length-1)){
	    end++;
	} else {
	    end = 0;
	}
	data[end] = value;
    }

    public T removeFirst() {
	T first = data[start]
    }

    public T removeLast() {

    }

    public T getFirst() {
	
    }

    public T getLast() {

    }

    public String toString() {
	String s = "[ ";
	for(int i = 0;i < data.length;i++) {
	    if(data[i]==null){ 
		s+= "X";
	    } else {
		s+= data[i];
	    }
	}
	s+=" ]";
	return s;
    }

    public static void main(String[]args) {
	MyDeque dq = new MyDeque();
	for (int i = 0; i < 8; i++) {
	    dq.add(10);
	    System.out.println(dq);
	}
    }
}
