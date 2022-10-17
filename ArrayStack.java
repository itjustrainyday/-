package test;

import java.util.*;

interface Stack<ET>{ 
	void push(ET e);
	ET pop();
	int size();
}

class ArrayStack <ET> implements Stack<ET> {
	ET elem[];
	int top;
	static final int INIT_CAPACITY = 5;
	
	public ArrayStack() 
	{
		this(INIT_CAPACITY);
	}
	public ArrayStack(int initCapacity) 
	{
		if(initCapacity < 0)
				throw new IllegalArgumentException("Initial capacity > 0");
		elem = (ET[]) new Object[initCapacity];
	}
	public void push(ET e)
	{
		if(top == elem.length -1)
			doubleCapacity();
		top++;
		elem[top] = e;
		
	}
	public void doubleCapacity() {
		Object[] tmp = elem;
		elem = (ET[]) new Object[2*tmp.length];
		
		int size = top +1;
		System.arraycopy(tmp,0,elem,0,size); //arraycopy 메소드 사용
	}
	public ET pop()
	{
		if(top == -1)	throw new EmptyStackException();
		ET e = elem[top];
		elem[top] = null;
		top--;
		return e;
	}
	public int size()
	{
		return top + 1;
	}
}


public class test2{
	public static void main(String[] args) {
		ArrayStack <Integer> al = new ArrayStack<Integer> ();
		al.push(50);
		al.push(30);
		System.out.println(al.pop());	
		}
}
