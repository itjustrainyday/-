package test;

import java.util.*; //for EmptyStackException

interface Stack<ET>{ //스택 명령어들이 있는 인터페이스 생성
	void push(ET e); //push : 삽입
	ET pop(); //pop : 해당 값을 제거 후 리턴
	int size(); //해당 배열 스택의 길이를 알 수 있는 사이즈
}

class ArrayStack <ET> implements Stack<ET> {
	ET elem[];
	int top;
	static final int INIT_CAPACITY = 5; //해당 배열을 5로 설정
	
	public ArrayStack() 
	{
		this(INIT_CAPACITY);//this 함수로 5로 길이 확정
	}
	public ArrayStack(int initCapacity) 
	{
		if(initCapacity < 0)
				throw new IllegalArgumentException("Initial capacity > 0"); //예외처리
		elem = (ET[]) new Object[initCapacity]; //elem을 new Object[5]로 생성
	}
	public void push(ET e)
	{
		if(top == elem.length -1) //스택이 꽉 찼을 때 doubleCapacity 함수 생성
			doubleCapacity();
		top++; //top값 증가
		elem[top] = e; //top의 값이 삽입한 값이 된다
		
	}
	public void doubleCapacity() {
		Object[] tmp = elem; //새로운 Object[] tmp가 elem이 된다.
		elem = (ET[]) new Object[2*tmp.length]; //elem은 tmp의 길이의 2배가 된다
		
		int size = top +1; //size가 top보다 1커진다. 해당 배열이 꽉차서 2배로 만들고 해당 값을 삽입하기 때문에
		System.arraycopy(tmp,0,elem,0,size); //arraycopy 메소드 사용 arraycopy는 배열을 복사하는 메소드이다
	} //(tmp->원본 0-> 배열 복사를 시작할 위치 elem->복사를 해야 할 인덱스 0->복사를 해야 할 배열의 시작 인덱스 size->복사할 개수
	public ET pop()
	{
		if(top == -1)	throw new EmptyStackException(); //스택의 값이 없으면 예외처리를 한다
		ET e = elem[top];// ET형 변수 e 선언 e의 값은 elem의 젤 위의 값
		elem[top] = null; // elem 가장 위의 값은 널값이 된다
		top--; //top이 줄어든다. 해당 탑 값 삭제
		return e; //e를 리턴해준다
	}
	public int size()
	{
		return top + 1; //배열은 0부터 시작하기 때문에 top+1를 해서 리턴해준다
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

