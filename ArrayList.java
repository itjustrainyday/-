package test;

interface LinerList2<ET>{
	void insert(ET e);
	Boolean remove(ET e);
	int search(ET e);
	ET get(int index);
	void show();
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
}


public class test2{
	public static void main(String[] args) {
		ArrayListSorted <Integer> al = new ArrayListSorted<Integer> ();
		al.insert(30);
		al.insert(50);
		int r = al.search(50);
		System.out.println(r);
	}
}
