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

	public Node(T data) {
	    this.data = data;
	}
	
	public boolean hasChildren() {
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

	public void add(T thing) {
	    if(hasChildren()) {
		if(thing > data) {
		    right.add(thing);
		}if(thing < data) {
		    left.add(thing);
		}
	    } else {
		if(thing > data) {
		    this.right = new Node(thing);
		} 
		if(thing < data) {
		    this.left = new Node(thing);
		}
	    }
	}

	public String toString() {
	    if(!hasChildren()) {
		return "" + data + "_ _ ";
	    } else {
		return data + toString(left) + toString(right);
	    }
    }

    private Node root;


}
