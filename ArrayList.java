package test;

interface LinerList2<ET>{ // 2장 다 보고 인터페이스 공부하기
	void insert(ET e);
	Boolean remove(ET e);
	int search(ET e);
	ET get(int index);
	void show();
	int binarySearch(int[] arr, int x);
	//insert : 삽입
	// remove : 삭제
	// search : 값을 삽입 -> 해당 값의 배열(인덱스) 검색
	// get : 해당 배열 값 반환
}

class ArrayListSorted <ET> implements LinerList2<ET> {
	ET elem[];
	int size;
	static final int INIT_CAPACITY = 5;
	public ArrayListSorted() {
		this(INIT_CAPACITY);
	}
	public ArrayListSorted(int initCapacity)
	{
		elem = (ET[]) new Object[initCapacity];
	}
	public void insert(ET theElem) {
		if(size == elem.length)
			changeCapacity(2 * size);
		int i = 0;
		Comparable<ET> e = (Comparable<ET>) theElem;
		while( i<size &&e.compareTo(elem[i]) > 0)
			i++;
		for(int j=size; j> i; j--)
		{
			elem[j] = elem[j-1];
		}
		elem[i] = theElem;
		size++;
		
	}
	public void changeCapacity(int newCapacity) {
		ET[] tmp = (ET[]) new Object[newCapacity];
		for(int i = 0; i < size; i++)
			tmp[i] = elem[i];
		elem = tmp;
		
	}
	public Boolean remove(ET theElem)
	{
		int i;
		for(i=0; i<size; i++)
		{
			if(elem[i].equals(theElem))
				break;
		}
		if(i == size)
			return false;
		for(; i< size-1; i++)
			elem[i] = elem[i+1];
		size--;
		if(size<= elem.length/4)
			changeCapacity(elem.length/2);
		return true;
	}
	public int search(ET theElem)
	{
		int i;
		for(i = 0; i<size;i++)
		{
			if(elem[i].equals(theElem))
				return i;
		}
		return -1;
	}
	public ET get(int index) {
		if(index < 0 || index >= size)
			try { 
				throw new IndexOutOfBoundsException();
			}catch(IndexOutOfBoundsException e)
			{
				System.out.println("예외");
				return null;
				}
		return elem[index];
		}
	public void show() {
		for(int i = 0; i<size; i++) {
			System.out.print(elem[i] + " ");
		}
		System.out.println();
	}
	public int binarySearch(int[] arr, int x) //1,2,3,4,5,6,7,8,9,10 (x = 5)
	{
		int p = 0;
		int q = arr.length -1;
		while( p <= q) {
			int m = (p+q)/2;
			if(x == arr[m])
				return m;
			else if( x < arr[m])
				q = m -1;
			else p = m +1;
		}
		return -1;
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
