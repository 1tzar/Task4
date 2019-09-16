package ua.nure.shamrai.task4;


public class Tree<E extends Comparable<E>> {
	private Node root;

	public boolean add(E element) {
		Node<E> currentNode = root;
		if (currentNode == null) {
			root = new Node<>(element);
			return true;
		} else {
			return addTo(element, root);
		}
	}

	public Node<E> search(E element) {
		Node<E> currentRoot = root;
		while (currentRoot != null) {
			if (element.compareTo(currentRoot.value) > 0) {
				currentRoot = currentRoot.right;
			} else if (element.compareTo(currentRoot.value) < 0) {
				currentRoot = currentRoot.left;
			} else {
				break;
			}
		}
		return currentRoot;
	}

	public boolean addTo(E element, Node<E> currentNode) {
		if (element.compareTo(currentNode.value) < 0) {
			if (currentNode.left == null) {
				currentNode.left = new Node<>(element);
				return true;
			} else {
				return addTo(element, currentNode.left);
			}
		} else if (element.compareTo(currentNode.value) > 0) {
			if (currentNode.right == null) {
				currentNode.right = new Node<>(element);
				return true;
			} else {
				return addTo(element, currentNode.right);
			}
		} else {
			return false;
		}

	}

	public boolean remove(E element) {
		Node<E> target = search(element);
		if (target != null) {
			removeFrom(root, element);
			return true;
		}
		return false;
	}

	private Node<E> minimalNode(Node<E> node) {
		return node.left == null ? node : minimalNode(node.left);
	}

	public Node<E> removeFrom(Node<E> currentNode, E element) {
		if (currentNode == null) {
			return null;
		}
		if (element.compareTo(currentNode.value) > 0) {
			currentNode.right = removeFrom(currentNode.right, element);
		} else if (element.compareTo(currentNode.value) < 0) {
			currentNode.left = removeFrom(currentNode.left, element);
		} else if (currentNode.left != null && currentNode.right != null) {
			Node<E> minNode = minimalNode(currentNode.right);
			currentNode.value = minNode.value;
			currentNode.right = removeFrom(currentNode.right, currentNode.value);

		} else {
			currentNode = currentNode.left == null ? currentNode.right : currentNode.left;
		}
		return currentNode;
	}

	public void add(E[] elements) {
		for (E element : elements) {
			add(element);
		}
	}

	public void print() {
		printNode(root, 0);
	}

	private void printNode(Node<E> node, int h) {
		if (node != null) {
			printNode(node.left, h + 1);
			for (int i = 0; i < h; i++) {
				System.out.print("  ");
			}
			System.out.printf("%s%n",node.value);
			printNode(node.right, h + 1);
		}
	}

	public static class Node<E> {
		private Node<E> left;
		private Node<E> right;
		private E value;

		public Node(E value) {
			this.value = value;
		}

	}
}