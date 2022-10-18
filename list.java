package test;

import java.util.*;

interface LinearList<ET>{ //함수들을 정의 해놓은 인터페이스 LinerList<ET>
	void insert(ET e); // 삽입 함수 insert (elem의 값)
	Boolean remove(ET e); // 제거 함수 remove (elem의 값)
	int search(ET e); // 찾는 함수 (elem의 값)
	void show(); //리스트의 원소를 나열 하는 함수 show
	ET get(int index); //해당 리스트의 번호(index)를 찾는 get함수
}

class SLinkedList <ET> implements LinearList<ET>{// implements => 인터페이스를 사용하기 위한 것 
	
	private Node<ET> first; //노드의 1번째
	private int size; //리스트의 갯수 
	public SLinkedList() {
		first = null; //첫번째는 널 값(아직 원소 삽입 안함) 생성자 생성
	}
	
	class Node<ET>{
		private ET elem; //원소 elem
		private Node next; //next
		Node(ET elem, Node next){
			this.elem = elem;//원소 값 매개변수
			this.next = next;//next값 매개변수
		}
	} 
	
	public void insert(ET theElem) {
		first = new Node<ET>(theElem, first); //this.elem 값을 가져다 쓰기 위한 new함수 사용
		size++; //값을 넣었기 때문에 size의 값을 증가해준다. // 주의 해야 할점은 선형 리스트는 첫번째 값으로만 값이 들어간다.
	}
	
	public Boolean remove(ET theElem) {	
		// pn, cn  : previous and current node.
		Node<ET> pn = null,cn; //null값인 노브 pn과 노드 cn 생성
		for(cn = first; cn != null; cn = cn.next) { //cn이 first 일 때, cn = cn.next => 넥스트가 가리키는 다음 노드로 간다
			if(cn.elem.equals(theElem)) //cn의 elem이 theelem과 같을 때
				break; //for문 빠져나옴
			pn = cn;//안빠져나올시 pn노드가 cn이 됌 cn은 그 다음 노드
		}
			
		if(cn == null)//cn이 null값일때, first값잉 없을 때
			return false;  
		
		if(cn.equals(first)) //cn이 first일 때 노드가 1개밖에 없을 때
		{
			Node<ET> mn = first.next; //mn노드를 따로 만들어서 첫번째에 노드에 가리키는 방향을 mn이 가르킴
			first = mn; //mn이 first가 됌 원래 first가 자연스럽게 사라짐
			size--; //사이즈 감소
			return true; // remove가 되었음을 의미
		}
		pn.next = cn.next; // cn.next가 가리키던 값을 pn.next가 가리킴
		size--;
		return true; //remove가 되었음을 의미
		}
	
	public int search(ET theElem) { 
		int i = 0;
		Node<ET> cn;
		   for(cn = first; cn != null; cn = cn.next) {
			   if( cn.elem.equals(theElem) ) //cn의 원소값이 찾던 theElem일 시
				   return i;//i값을 리턴해준다
			   i++;// if문이 실행이 안되면 i를 1씩 더해줌				
	   	   }
		   return -1; // 못찾으면 -1을 리턴(실패의 의미)
	}
	
	public ET get(int index) {
		if (index < 0 || index >= size) {
			try { 
				throw new IndexOutOfBoundsException();
			}catch(IndexOutOfBoundsException e)
			{
				System.out.println("예외");
				return null;
				}//예외처리 index가 0보다 작거나 index가 size보다 크거나 같을 때
			
		}
		Node<ET> cn = first; //cn이 first가 된다
		for(int i = 0; i < index; i++) { //index는 0부터 시작 (배열과 같은 취급)
			cn = cn.next; //i가 index보다 작거나 같을 때 까지 cn.next가 cn이 된다.
		}
		return cn.elem; //해당 원소값을 리턴해줌
	}
	
	public void show() {
		Node<ET> cn = first;
		for(int i=0; i<size; i++) {
			System.out.print(cn.elem + " ");
			cn = cn.next; //cn값을 하나씩 size-1이 될때까지 하나씩 출력 후 다음 노드로 감
		}
		System.out.println();
	}
}

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
