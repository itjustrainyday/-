package test;
import java.util.*;//NoSuchElementException
class LinkedQueue <ET> {
	private  Node<ET> rear; //가장 뒤의 노드
	private  int size;   // 큐에 있는 원소의 수(노드의 개수)
	
	public LinkedQueue() {
		rear = null;
	}

	public void add(ET elem) { //큐의 기능 삽입
		Node<ET> cn = new Node<ET>( elem ); //cn 노드 선언(원소 elem을 가진)
		if(rear == null) //뒷부분이 값이 없을 때
			cn.next = cn; //cn.next 값이 cn의 값이 된다.?
		else { //아닐시
			cn.next = rear.next; //cn.next는 rear.next => 환형 구조를 만들기?
			rear.next = cn; 
		}
		rear = cn;  // 새 노드가 rear가 됨.
		
		size++; //elem이 추가 됐다. 사이즈가 증가
	}
	public ET remove() { //큐의 기능 삭제
		if(size() == 0) throw new NoSuchElementException(); //큐가 비어있으면 하는 예외처리

		Node<ET> front = rear.next; //제일 왼쪽 노드에 접근하기 위해 rear.next 필드에 접근
		if(size == 1)
			rear = null;
		else 	 
			rear.next = front.next; //원소의 갯수가 1이면 rear는 값이 없고, 아닐 시 rear.next값이 front.next값이 된다.
			
		size--; //remove가 됐기 때문에 사이즈 감소
		return front.elem; //제거된 원소를 리턴
	}
	public int size() { //private => 이 클래스에서만 쓸 수 있는 함수, public => 다른 클래스에서도 쓸 수 있는 함수
		return  size; //이 노드가 몇 개의 원소를 가지고 있는 지 반환
	}
	
	class Node <ET>{
		private ET  elem; //원소
		private Node<ET> next; //next 필드 뒤의 노드

		public Node( ET elem ) {
			this.elem = elem;
		}	
	} // class Node

}

public class test2{
	public static void main(String[] args) {
		LinkedQueue<Integer> a1 = new LinkedQueue<Integer>();
		a1.add(30); // 30이라는 값을 추가
		a1.add(40); // 40이라는 값을 추가
		System.out.println(a1.size()); //2개으 원소가 추가 size의 값은 2
		System.out.println(a1.remove()); //front의 값 30이 제거 되면서 return 30 출력
	}
}
