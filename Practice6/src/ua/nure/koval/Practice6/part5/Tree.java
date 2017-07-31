package ua.nure.koval.Practice6.part5;

public class Tree<E extends Comparable<E>> {

	private static final String SPACE = "   ";
	private Node<E> rootNode;


	public boolean add(E e) {
		if (rootNode == null) {
			rootNode = new Node<E>(e, null, null);
			return true;
		}
		return add(rootNode, e);
	}

	public void add(E[] elements) {
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);
		}
	}

	private boolean add(Node<E> node, E e) {
		if (e.compareTo(node.element) > 0) {
			if (node.rNode == null) {
				node.rNode = new Node<E>(e, null, null);
				return true;
			}
			return add(node.rNode, e);
		}
		if (e.compareTo(node.element) < 0) {
			if (node.lNode == null) {
				node.lNode = new Node<E>(e, null, null);
				return true;
			}
			return add(node.lNode, e);
		}
		return false;
	}


	public void print() {
		print(rootNode, new StringBuilder());
	}

	private void print(Node<E> node, StringBuilder sb) {
		if (node != null) {
			sb.append(SPACE);
			print(node.lNode, sb);
			sb.append(SPACE);
			if (node.equals(rootNode)) {
				System.out.println(node.element);
				sb.delete(0, sb.length());
			} else {
				System.out.println(sb.toString() + node.element);
			}
			sb.append(SPACE);
			print(node.rNode, sb);
			sb.delete(0, sb.length());
		}
	}

	public boolean remove(E element) {
		final String lNode = "lNode";
		final String rNode = "rNode";
		Node<E> parent = null;
		Node<E> current = rootNode;
		int previous;
		String lastNode = null;

		while (current != null && (previous = current.element.compareTo(element)) != 0) {
			parent = current;
			if (previous > 0) {
				current = current.lNode;
				lastNode = lNode;
			} else {
				current = current.rNode;
				lastNode = rNode;
			}
		}
		if (current == null) {
			return false;
		}

		if (current.rNode == null) {
			if (lastNode.equals(rNode)) {
				parent.rNode = current.lNode;
			} else if (lastNode.equals(lNode)) {
				parent.lNode = current.lNode;
			} else {
				rootNode = current.lNode;
			}
		}

		if (current.lNode == null) {
			if (lastNode.equals(rNode)) {
				parent.rNode = current.rNode;
			} else if (lastNode.equals(lNode)) {
				parent.lNode = current.rNode;
			} else {
				rootNode = current.rNode;
			}
		}

		Node<E> replacement = current.rNode;
		parent = current;
		while (replacement.lNode != null) {
			parent = replacement;
			replacement = replacement.lNode;
		}
		current.element = replacement.element;
		if (parent.equals(current)) {
			parent.rNode = replacement.rNode;
		} else {
			parent.lNode = replacement.rNode;
		}
		return true;
	}

	private class Node<E> {

		private E element;
		private Node<E> lNode;
		private Node<E> rNode;

		public Node(E element, Node<E> lNode, Node<E> rNode) {
			this.element = element;
			this.lNode = lNode;
			this.rNode = rNode;
		}
	}
}