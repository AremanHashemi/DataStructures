package edu.miracosta.cs113;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class ArrayQueueTest 
{

	@Test
	public void offerPeekTest()
	{
		Queue<Integer> myQue = new ArrayQueue<Integer>();
		myQue.offer(5);
		assertEquals(5,(int)myQue.peek());
	}
	@Test
	public void removeTest()
	{
		Queue<Integer> myQue = new ArrayQueue<Integer>();
		myQue.offer(1);
		myQue.offer(2);
		assertEquals(1,(int)myQue.remove());
		assertEquals(2,(int)myQue.remove());
	}
	@Test(expected = NoSuchElementException.class)
	public void removeExceptionTest()
	{
		Queue<Integer> myQue = new ArrayQueue<Integer>();
		myQue.offer(1);
		myQue.offer(2);
		myQue.remove();
		myQue.remove();
		myQue.remove();
	}
	@Test
	public void pollTest()
	{
		Queue<Integer> myQue = new ArrayQueue<Integer>();
		myQue.offer(1);
		myQue.offer(2);
		assertEquals(1,(int)myQue.poll());
		assertEquals(2,(int)myQue.poll());
	}
	@Test
	public void pollNullTest()
	{
		Queue<Integer> myQue = new ArrayQueue<Integer>();
		myQue.offer(1);
		myQue.offer(2);
		myQue.poll();
		myQue.poll();
		assertEquals(null,myQue.poll());
	}
}
