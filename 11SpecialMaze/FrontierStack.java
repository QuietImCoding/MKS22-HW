public class FrontierStack<T> implements Frontier<T> {
    MyStack<T> stack = new MyStack<T>();
    public void add(T element) {
	stack.push(element);
    }
    public T next() {
	return stack.pop();
    }
    public boolean hasNext() {
	return stack.size()>0;
    }
}
