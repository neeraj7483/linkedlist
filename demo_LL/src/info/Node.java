package info;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	private T data;
	private Node<T> next;

	protected Node() {

	}
	protected Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	protected T getData() {
		return data;
	}

	protected void setData(T data) {
		this.data = data;
	}

	protected Node<T> getNext() {
		return next;
	}

	protected void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<T> other = (Node<T>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public int compareTo(Node<T> o) {
		return (this.getData().compareTo(o.getData()));
	}
	

}
