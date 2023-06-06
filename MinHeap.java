package data;

import java.util.*;
class MinHeap<ET extends Comparable <ET>>{//public 클래스는 하나만 존재
	private ET[] arr;
	private int size;
	private static final int ROOT = 1;
	private static final int INIT_CAP = 4;
	
	public MinHeap() {
		this(INIT_CAP);
		1
	}
	public MinHeap(int capacity) {
		arr = (ET[]) new Comparable[capacity+1];
	}
	public MinHeap( ET[ ] a, int s ) {
        arr = a;  size = s;
    }
	public void insert(ET theKey) {
		if( size == arr.length-1 ) resize( 2*size );

        size++;
        int q = size;  // q : current node
        int p; // parent of q
        while( q != ROOT ) {
            p = q/2;
            if( theKey.compareTo(arr[p]) > 0 ) break;
            arr[q] = arr[p];
            q = p;	 p = q / 2;
        }
        arr[q] = theKey;
        return;
	}
	public ET removeMin() {
		int q;  //  current node
        ET keyToReturn;

        if( size == 0 ) { return null; }  // empty heap

        keyToReturn = arr[ROOT];
        arr[ROOT] = arr[size];
        size--;  // removed
        heapify(ROOT);
        if( size <= arr.length/4 ) resize( arr.length/2 );
        return  keyToReturn;
	}
	public ET getMin() { return arr[ROOT]; }

	public int size() { return size; }
	public void buildHeap() {
		for( int i = size/2; i > 0; i-- )
			heapify(i);
	}

	protected void heapify(int q) {
		int bc, rc;  // bc: child with smaller key, rc: right child
        
        ET  tmpKey = arr[q];
        bc = 2*q;  // left child of q.
        while( bc <= size )  {
            rc = bc + 1;
            if( rc <= size && arr[bc].compareTo( arr[rc]) > 0 ) bc = rc;

            if( tmpKey.compareTo( arr[bc] ) < 0 ) break;
            arr[q] = arr[bc];
            q = bc;
            bc = 2*q;
        }
        arr[q] = tmpKey;
	}
	protected void resize(int newSize) {
		ET[ ] a = (ET[ ]) new Comparable[newSize+1];
		for( int i = 1; i <= size; i++ ) {
	            a[i] = arr[i];
	     }
		arr = a;
	}

	public void sort() {
		int  sizeSaved = size;

        buildHeap();

        while( size > ROOT ) {
            swap( ROOT, size-- );
            heapify( ROOT );
        }
        size = sizeSaved;
	}  // heap sort
	private void swap(int i, int j) { 
		ET t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
	}
}
public class test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap<Integer> a = new MinHeap();
		a.insert(70);
		a.insert(80);
		a.insert(40);
		a.insert(30);
		a.insert(50);
		a.insert(60);
		a.insert(20);
		a.insert(10);
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
		System.out.println(a.removeMin());
	}
}
