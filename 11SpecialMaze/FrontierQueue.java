public class FrontierQueue<T> implements Frontier<T> {
    MyQueue<T> queue = new MyQueue<T>();
    public void add(T element) {
	queue.enqueue(element);
    }
    public T next() {
	return queue.dequeue();
    }
    public boolean hasNext() {
	return queue.size()>1;
    }
}
