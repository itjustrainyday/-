package test;

interface LinerList2<ET>{ // 2장 다 보고 인터페이스 공부하기
	void insert(ET e);
	Boolean remove(ET e);
	int search(ET e);
	ET get(int index);
	void show();
	int binarySearch(int[] arr, int x);
	//insert : 삽입
	//remove : 삭제
	//search : 값을 삽입 -> 해당 값의 배열(인덱스) 검색
	//get : 해당 배열 값 반환
}

class ArrayListSorted <ET> implements LinerList2<ET> { //LinerList를 상속받은 ArrayListSorted 생성
	ET elem[];
	int size;
	static final int INIT_CAPACITY = 5; //5라는 사이즈 생성
	public ArrayListSorted() {
		this(INIT_CAPACITY);//ArrayListSorted에 5 추가
	}
	public ArrayListSorted(int initCapacity)//매개변수가 5
	{
		elem = (ET[]) new Object[initCapacity]; //elem[5] 생성 Object는 잘 모르겠음
	}
	public void insert(ET theElem) {
		if(size == elem.length) //만약 size가 elem의 길이 만큼이라면 size = 5?
			changeCapacity(2 * size); //changeCapacity() 함수생성 size의 2배 매개변수
		int i = 0; 
		Comparable<ET> e = (Comparable<ET>) theElem; //비교 가능한 <ET>형 변수 e는 theElem 값이다?
		while( i<size &&e.compareTo(elem[i]) > 0) //오름차순으로 구현 되기 때문에 insert 값의 위치를 찾는 과정?
			i++;
		for(int j=size; j> i; j--) //원래 있던 elem의 값을 위에서 찾은 i값보다 큰 원소들을 오른쪽으로 옮겨준다.
		{
			elem[j] = elem[j-1];
		}
		elem[i] = theElem; //삽입한 theElem의 값이 찾은 i값에 삽입한다
		size++; //삽입이 되었기 때문에 size가 하나 커졌다.
	}
	public void changeCapacity(int newCapacity) { //newCapacity = 2 * size?
		ET[] tmp = (ET[]) new Object[newCapacity]; //배열을 두배로 늘리고 값을 복사할 tmp 생성
		for(int i = 0; i < size; i++)
			tmp[i] = elem[i]; //elem의 값들 하나하나 tmp안으로 옮겨준다.
		elem = tmp; //elem이 tmp로 새롭게 된다
		
	}
	public Boolean remove(ET theElem)
	{
		int i;
		for(i=0; i<size; i++) //for문을 통해 
		{
			if(elem[i].equals(theElem)) //해당 remove 값을 찾으면 break;
				break;
		}
		if(i == size)
			return false;
		for(; i< size-1; i++) //초기값이 없으면 위에 i값이 초기값이 된다. break을 통해 나온 i값이 초기값
			elem[i] = elem[i+1]; // i값부터 맨 오른쪽 값을 다 왼쪽으로 옮김
		size--; //해당 값 제거 -1 해주기
		if(size<= elem.length/4) //만약 size가 elem.length의 4를 나눈 값보다 작으면
			changeCapacity(elem.length/2); //changeCapacity 함수 사용 elem.length / 2
		return true;
	}
	public int search(ET theElem)
	{
		int i;
		for(i = 0; i<size;i++) //해당 인덱스를 찾는 search 값은 elem의 값
		{
			if(elem[i].equals(theElem))
				return i; //i를 찾으면 i를 리턴
		}
		return -1; //못찾았을 시 실패
	}
	public ET get(int index) {
		if(index < 0 || index >= size)
			try { 
				throw new IndexOutOfBoundsException();
			}catch(IndexOutOfBoundsException e)
			{
				System.out.println("예외");
				return null;
				} //예외처리
		return elem[index]; //해당 elem[3]을 리턴 인덱스가 매개변수이니 인덱스로 호출
		}
	public void show() {
		for(int i = 0; i<size; i++) { //elem[0] 부터 elem[size-1]까지 전체 출력
			System.out.print(elem[i] + " ");
		}
		System.out.println(); //한줄로 출력후 줄바꿈
	}
	public int binarySearch(int[] arr, int x) //1,2,3,4,5,6,7,8,9,10 (x = 5)
	{
		int p = 0; //p를 맨처음으로 설정
		int q = arr.length -1; // q는 배열의 길이만큼
		while( p <= q) { //p와 q가 같아질 때까지
			int m = (p+q)/2; //m으로 나눈다.
			if(x == arr[m]) //해당 값을 찾으면 매개변수(x)
				return m; //m을 리턴
			else if( x < arr[m]) //x가 arr[m]보다 작으면
				q = m -1; // q값을 새롭게 할당 (범위) 쪼개기
			else p = m +1; // 범위 쪼개기 (큰쪽으로)
		}
		return -1; //실패했을 시
		}
	}



public class test2{
	public static void main(String[] args) {
		ArrayListSorted <Integer> al = new ArrayListSorted<Integer> ();
		int[] arr = new int[] {1,6,8,12,17};
		int x = 18;
		al.insert(30);
		al.insert(50);
		al.insert(20);
		al.insert(10);
		al.insert(40);
		System.out.println(al.binarySearch(arr, x));
		int r = al.search(20);
		System.out.println(r);
		System.out.println(al.get(3));
		al.show();
	}
}

