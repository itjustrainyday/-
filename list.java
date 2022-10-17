package test;

import java.util.Scanner;
import java.util.LinkedList;
//ET = Element Type

//LinearList 인터페이스
interface LinearList<ET>{
	void insert(ET e);
	Boolean remove(ET e);
	int search(ET e);
	void show();
	ET get(int index);
}

//class LinearList를 상속받는 SLinkedList 생성
class SLinkedList <ET> implements LinearList<ET>{
	
	//Node<ET> 자료형의 first변수 생성
	private Node<ET> first;
	//List의 정수형 size변수
	private int size;  // number of elements in the list
	//constructor
	public SLinkedList() {
		first = null;
	}
	
	//Node<ET> class
	class Node<ET>{
		//elem ET형 변수
		private ET elem;
		//Node형 next변수
		private Node next;
		//constructor
		Node(ET elem, Node next){
			this.elem = elem;
			this.next = next;
		}
	} 
	
	//LinearList 인터페이스 속에 있는 insert 함수 오버라이드
	@Override
	public void insert(ET theElem) {
		first = new Node<ET>(theElem, first);
		size++;
	}
	
	//LinearList 인터페이스 속에 있는 remove 함수 오버라이드, 부울 함수의 자바 표현 Boolean
	@Override
	public Boolean remove(ET theElem) {	
		// pn, cn  : previous and current node.
		Node<ET> pn = null,cn;
		for(cn = first; cn != null; cn = cn.next) {
			if(cn.elem.equals(theElem)) 
				break;
			pn = cn;
		}
			
		if(cn == null) 
			return false;  // not found
		
		if(cn.equals(first))
		{
			Node<ET> mn = first.next;
			first = mn;
			size--;
			return true;
		}
		pn.next = cn.next;
		size--;
		return true;
		}
	
	//LinearList 인터페이스 속에 있는 search 함수 오버라이드
	@Override
	public int search(ET theElem) {
		int i = 0;
		Node<ET> cn;
		   for(cn = first; cn != null; cn = cn.next) {
			   if( cn.elem.equals(theElem) ) 
				   return i;
			   i++;				
	   	   }
		   return -1;
	}
	
	//LinearList 인터페이스 속에 있는 get 함수 오버라이드
	@Override
	public ET get(int index) {
		if (index < 0 || index >= size) {
			try { 
				throw new IndexOutOfBoundsException();
			}catch(IndexOutOfBoundsException e)
			{
				System.out.println("예외");
				return null;
				}
			
		}
		Node<ET> cn = first;
		for(int i = 0; i < index; i++) {
			cn = cn.next;
		}
		return cn.elem;
	}
	
	//LinearList 인터페이스 속에 있는 show 함수 오버라이드
	@Override
	public void show() {
		Node<ET> cn = first;
		for(int i=0; i<size; i++) {
			System.out.print(cn.elem + " ");
			cn = cn.next;
		}
		System.out.println();
	}
}

//Main문
public class test1 {
	public static void main(String[] args) {
		SLinkedList<Integer> sl = new SLinkedList<Integer>();
		sl.insert(50);
		sl.insert(30);
		sl.insert(70);
		sl.insert(20);
		sl.insert(40);
		sl.insert(60);
		sl.show();
		System.out.println(sl.get(3));
		System.out.println(sl.get(9));
		System.out.println(sl.search(30));
		System.out.println(sl.search(90));
		sl.remove(60);
		sl.remove(70);
		sl.remove(50);
		sl.remove(90);
		sl.show();
	}
	
}
