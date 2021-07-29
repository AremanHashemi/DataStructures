package edu.miracosta.cs113;

public interface Stack<E>
{
	boolean empty();
	E peek();
	E pop();
	E push(E obj);
}
