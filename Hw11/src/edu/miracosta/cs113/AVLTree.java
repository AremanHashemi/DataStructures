package edu.miracosta.cs113;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E>
{
	private boolean levelAdded;
	/**
	 * adds item if not in tree and returns true
	 * returns false if item was already in tree(Uniqueness) 
	 */
	@Override
	public boolean add(E item)
	{
		levelAdded = false;
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}
	/**
	 * Recursive helper for add
	 * returns tree with item added
	 * @param localRoot
	 * @param item
	 * @return
	 */
	private AVLNode<E> add(AVLNode<E> localRoot, E item)
	{
		//Base Case item not in tree
		if (localRoot == null)
		{
			addReturn = true;
			levelAdded = true;
			return new AVLNode<E>(item);
		}
		//Base Case item is already in tree do nothing
		if (item.compareTo(localRoot.data) == 0)
		{
			levelAdded = false;
			addReturn = false;
			return localRoot;
		}
		//Traverse left tree for search of item position
		else if (item.compareTo(localRoot.data) < 0)
		{
			localRoot.left = add((AVLNode<E>) localRoot.left, item);
			//If item created a new node
			if(levelAdded)
			{
				//recalculate balance with new node
				decrementBalance(localRoot);
				//Rebalance if necessary
				if (localRoot.balance < AVLNode.LEFT_HEAVY)
				{			
					levelAdded = false;
					return rebalanceLeft(localRoot);
				}
			}
		}
		//Traverse right tree for search of item position
		else 
		{
			localRoot.right = add((AVLNode<E>) localRoot.right, item);
			//If item node was added
			if(levelAdded)
			{
				//recalculate balance with new node on right side
				incrementBalance(localRoot);
				//rebalance if needed
				if (localRoot.balance > AVLNode.RIGHT_HEAVY)
				{			
					levelAdded = false;
					return rebalanceRight(localRoot);
				}
			}
		}
		return localRoot;
	}
	/**
	 * used if new node was added on the right subtree
	 * increments balance of node
	 * if balance is recalculated to 0 treat as if no new level was added
	 * @param node
	 */
	private void incrementBalance(AVLNode<E> node)
	{
		node.balance++;
		if(node.balance == AVLNode.BALANCED)
		{
			levelAdded = false;
		}
	}
	/**
	 * used if new node was added on the left subtree
	 * decrements balance of node
	 * if balance is recalculated to 0 treat as if no new level was added
	 * @param node
	 */
	private void decrementBalance(AVLNode<E> node)
	{
		node.balance--;
		if(node.balance == AVLNode.BALANCED)
		{
			levelAdded = false;
		}
	}
//	public delete(E itemToDelete)
//	{
//		
//	}
	/**
	 * Recalculates balance and re balances tree
	 * @param localRoot
	 * @return
	 */
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
    {
        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
        if (rightChild.balance < AVLNode.BALANCED)
        {
            AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
            if (rightLeftChild.balance < AVLNode.BALANCED)
            {
                rightChild.balance = AVLNode.LEFT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else if (rightLeftChild.balance > AVLNode.BALANCED)
            {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } 
            else
            {
                rightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            localRoot.right = rotateRight(rightChild);
        }
        else
        {
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        return (AVLNode<E>) rotateLeft(localRoot);
    }
	/**
	 * Recalculates balance
	 * rotates based on
	 * (Left-Right)
	 * (Left-Right-Left)
	 * (Left-Right-Right)
	 * (Left-Left)
	 * @param localRoot
	 * @return
	 */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot)
    {
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        if (leftChild.balance > AVLNode.BALANCED)
        {
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            if (leftRightChild.balance < AVLNode.BALANCED)
            {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else if (leftRightChild.balance > AVLNode.BALANCED)
            {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } 
            else
            {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            localRoot.left = rotateLeft(leftChild);
        }
        else
        { 
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        return (AVLNode<E>) rotateRight(localRoot);
    }
	private static class AVLNode<E> extends Node<E>
	{
		public static final int LEFT_HEAVY = -1;
		public static final int RIGHT_HEAVY = 1;
		public static final int BALANCED = 0;
		
		private int balance;
		
		public AVLNode(E item)
		{
			super(item);
			balance = 0;
		}
		public String toString()
		{
			return "Balance : " + balance + ", Value :" + super.toString();
		}
	}
	
}
