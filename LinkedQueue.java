package test;
import java.util.*;//NoSuchElementException
class LinkedQueue <ET> {
	private  Node<ET> rear; //가장 뒤의 노드
	private  int size;   // 큐에 있는 원소의 수(노드의 개수)
	
	public LinkedQueue() {
		rear = null;
	}

	public void add(ET elem) { //큐의 기능 삽입
		Node<ET> cn = new Node<ET>( elem ); //cn 노드 선언(원소 elem을 가진) 여기서 elem은 class node에서 가져온 매개변수
		if(rear == null) //뒷부분이 값이 없을 때(처음에), 노드가 1개일 때
			cn.next = cn; //cn.next 값이 cn의 값이 된다. 자기 자신을 혼자 도는 구조
		else { //아닐시
			cn.next = rear.next; //cn이 막 들어온 노드이기에 cn이 rear를 가리키게
			rear.next = cn;  //rear.next 가 막 들어온 노드를 가리키게(환형 구조)
		}
		rear = cn;  // 새 노드가 rear가 됨.
		
		size++; //elem이 추가 됐다. 사이즈가 증가
	}
	public ET remove() { //큐의 기능 삭제
		if(size() == 0) throw new NoSuchElementException(); //큐가 비어있으면 하는 예외처리

		Node<ET> front = rear.next; //제일 왼쪽 노드에 접근하기 위해 rear.next 필드에 접근
		if(size == 1) //사이즈가 1일 때
			rear = null; //rear는 널값 자기자신만 있기 때문
		else 	 
			rear.next = front.next; //front의 넥스트 값이 rear 넥스트가 된다.
			
		size--; //remove가 됐기 때문에 사이즈 감소
		return front.elem; //제거된 원소를 리턴한다.
	}
	public int size() { //private => 이 클래스에서만 쓸 수 있는 함수, public => 다른 클래스에서도 쓸 수 있는 함수
		return  size; //이 노드가 몇 개의 원소를 가지고 있는 지 반환
	}
	
	class Node <ET>{
		private ET  elem; //원소
		private Node<ET> next; //next 필드 뒤의 노드

		public Node( ET elem ) {
			this.elem = elem; //add값에 원소를 삽입하기 위한 this() 사용? 
		}//클래스 노드의 elem 값이 elem 매개변수 값이 된다? 
	} // class Node

}

public class test2{
	public static void main(String[] args) {
		LinkedQueue<Integer> a1 = new LinkedQueue<Integer>();
		a1.add(1); // 30이라는 값을 추가
		a1.add(3); // 40이라는 값을 추가
		a1.add(2);
		a1.add(5);
		a1.add(4);
		System.out.println(a1.remove()); //front의 값 30이 제거 되면서 return 30 출력
		System.out.println(a1.remove());
		System.out.println(a1.remove());
		System.out.println(a1.remove());
		System.out.println(a1.remove());
	}
}
