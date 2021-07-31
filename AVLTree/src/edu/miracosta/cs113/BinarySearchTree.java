package edu.miracosta.cs113;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>
{
	protected boolean addReturn;
	protected boolean deleteReturn;
	
	/**
	 * inserts item where it belongs in the tree. returns true if item is inserted
	 * false if it isn't
	 * @param item
	 * @return
	 */
	public boolean add(E item) 
	{
		root = add(root, item);
		return addReturn;
	}
	private Node<E> add(Node<E> localRoot, E item)
	{
		if (localRoot == null)
		{
			addReturn = true;
			return new Node<E>(item);
		}
		else if (item.compareTo(localRoot.data) == 0)
		{
			addReturn = false;
			return localRoot;
		} 
		else if (item.compareTo(localRoot.data) < 0)
		{
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} 
		else
		{
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
		}
	/**
	 * removes target(if found) returns it, else return null
	 */
//	public delete()
//	{
//		
//	}
	/**
	 * removes target(if found) and returns true else return false
	 * @return
	 */
	public boolean remove(E data)
	{
		root = removeRec(root, data);
		return deleteReturn;
	}
	private Node<E> removeRec(Node<E> localRoot, E data)
	{
		if(localRoot==null)
		{
			return localRoot;
		}
		int compare = data.compareTo(localRoot.data);
		if(compare < 0)
		{
			localRoot.left = removeRec(localRoot.left, data);
		}
		else if(compare > 0)
		{
			localRoot.right = removeRec(localRoot.right, data);
		}
		else
		{
			if(localRoot.isLeaf())
			{
				return null;
			}
			else if(localRoot.left == null)
			{
				return localRoot.right;
			}
			else if(localRoot.right == null)
			{
				return localRoot.left;
			}
			else
			{
				if(localRoot.left.right == null)
				{
					return localRoot.left;
				}
				else
				{
					Node<E> rightMostNode = localRoot.left;
					Node<E> rightMostParent = localRoot;
					while(rightMostNode.right != null)
					{
						rightMostParent = rightMostNode;
						rightMostNode = rightMostNode.right;
					}
					localRoot.data = rightMostNode.data;
					rightMostParent.right = null;
				}
			}
			
			
		}
		return localRoot;
	}
}
