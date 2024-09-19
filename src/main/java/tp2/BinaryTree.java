package tp2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		return leafCountRecursive(this, 0);
	}
	private int leafCountRecursive(BinaryTree<T> tree, int count) {
		if (!tree.hasRightChild() && !tree.hasLeftChild())
			return count + 1;
		if (tree.hasLeftChild()) {
			count = leafCountRecursive(tree.getLeftChild(), count);
		}
		if (tree.hasRightChild()) {
			count = leafCountRecursive(tree.getRightChild(), count);
		}
		return count;
	}

	public void printLevelTraversal() {
		Queue<BinaryTree<T>> queue = new ConcurrentLinkedQueue<>();
		queue.add(this);
		queue.add(new BinaryTree<>(null));
		while (!queue.isEmpty()) {
			BinaryTree<T> value = queue.poll();
			if (value.getData() != null) {
				System.out.print(value.getData().toString() + " ");
				if (value.hasLeftChild()) queue.add(value.getLeftChild());
				if (value.hasRightChild()) queue.add(value.getRightChild());
			} else {
				System.out.println("");
				if (!queue.isEmpty()) queue.add(new BinaryTree<>(null));
			}
		}
	}

	public void preOrden() {
		preOrdenRecursive(this);
	}

	public void inOrden() {
		inOrdenRecursive(this);
	}

	public void postOrden() {
		postOrdenRecursive(this);
	}

	private void preOrdenRecursive(BinaryTree<T> tree) {
		System.out.println(tree.getData().toString());
		if (tree.hasLeftChild()) preOrdenRecursive(tree.getLeftChild());
		if (tree.hasRightChild()) preOrdenRecursive(tree.getRightChild());
	}

	private void inOrdenRecursive(BinaryTree<T> tree) {
		if (tree.hasLeftChild()) inOrdenRecursive(tree.getLeftChild());
		System.out.println(tree.getData().toString());
		if (tree.hasRightChild()) inOrdenRecursive(tree.getRightChild());
	}

	private void postOrdenRecursive(BinaryTree<T> tree) {

	}
    	 
    public BinaryTree<T> espejo(){
		       		  
 	   return null;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
   }
		
}

