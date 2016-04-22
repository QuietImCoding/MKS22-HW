public class BSTree <T extends Comparable <T>> {
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
	    return left != null && right != null;
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
		if(thing.compareTo(data)>=1) {
		    right.add(thing);
		}if(thing.compareTo(data)<0) {
		    left.add(thing);
		}
	    } else {
		if(thing.compareTo(data)>=1) {
		    this.right = new Node(thing);
		} 
		if(thing.compareTo(data)<0) {
		    this.left = new Node(thing);
		}
	    }
	}

	public String toString() {
	    if(!hasChildren()) {
		return "" + data + " _ _";
	    } else if (left == null) {
		return "" + data + " _" + right;
	    } else if (right == null) {
		return "" + data + left + " _";
	    }  else {
		return "" + data + " " +  left + " " + right;
	    }
	}
    }

    private Node root;
    
    public String toString() {
	return root.toString();
    }

    public void add(T value) {
	System.out.println("Value: " + value);
	if(root==null) {
	    root = new Node(value);
	} else {
	    root.add(value);
	}
    }

}
