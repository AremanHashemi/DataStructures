package edu.miracosta.cs113;

public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E>
{
	/**
	 * rotates left from root
	 * root.right must exist
	 * @param root
	 * @return
	 */
	protected Node<E> rotateLeft(Node<E> root)
	{
		Node<E> temp = root.right;
		root.right = temp.left;
		temp.left = root;
		return temp;
	}
	/**
	 * rotates left from root
	 * root.left must exist
	 * @param root
	 * @return
	 */
	protected Node<E> rotateRight(Node<E> root)
	{
		Node<E> temp = root.left;
		root.left = temp.right;
		temp.right = root;
		return temp;
	}
}
