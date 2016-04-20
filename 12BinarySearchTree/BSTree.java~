public class BSTree <T extends <Comparable <T>> {
    private class Node {
	T data;
	Node left;
	Node right;

	public Node(T data, Node left, Node right) {
	    this.data = data;
	    this.left = left;
	    this.right = right;
	}
	
	public boolean hasNext() {
	    return left == null || right == null;
	}

	public void setData(T stuff) {
	    data = stuff;
	}

	public void setLeft(Node newleft) {
	    left = newleft;
	}

	public void setRight(Node newright) {
	    right = newright;
	}

	public T getData() {
	    return data;
	}

	public Node getLeft() {
	    return left;
	}

	public Node getRight() {
	    return right;
	}

	private void add(T thing) {
	    if(hasNext()) {
	    } else {
		left = thing;
	    }
    }

    private Node root;


}
