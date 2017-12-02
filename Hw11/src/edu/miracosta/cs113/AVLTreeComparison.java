/**
 * AVLTreeComparison - testing AVLtree vs binary search tree
 * FOR(1-10)
 * 	RANDOMLY GENERATE int a
 * 	avlTree.add(a)
 * 	bstTree.add(b)
 * print avlTree
 * print bstTree
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */

package edu.miracosta.cs113;
import java.util.Random;

public class AVLTreeComparison
{
	public static void main(String [] args)
	{
		Random rand = new Random();
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();
		for(int i = 0; i < 10; i++)
		{
			int a = rand.nextInt(50)+1;
			avlTree.add(a);
			bsTree.add(a);
		}
		System.out.println("Avl Tree: \n" + avlTree);
		System.out.println("\n Binary Tree : \n" + bsTree);
	}
}
