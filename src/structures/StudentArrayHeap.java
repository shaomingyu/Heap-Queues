package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
	
	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
	}
	
	protected int getLeftChildOf(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return 2 * index + 1;
	}
	
	protected int getRightChildOf(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return 2 * index + 2;
	}
	
	protected int getParentOf(int index) {
		if(index < 1) {
			throw new IndexOutOfBoundsException();
		}
		return (index - 1) / 2;
	}
	
	protected void bubbleUp(int index) {
		int i = index;
		while(i != 0 && comparator.compare(heap.get(i).getPriority(), heap.get(getParentOf(i)).getPriority()) > 0) {
			swap(i, getParentOf(i));
			i = getParentOf(i);
		}
	}
	
	protected void bubbleDown(int index) {
		int i = index; 
		while((getRightChildOf(i) < size() && comparator.compare(heap.get(i).getPriority(), heap.get(getRightChildOf(i)).getPriority()) < 0 ) 
				|| (getLeftChildOf(i) < size() && comparator.compare(heap.get(i).getPriority(), heap.get(getLeftChildOf(i)).getPriority()) < 0)){
			if(getRightChildOf(i) >= size() || (getRightChildOf(i) < size() && comparator.compare(heap.get(getLeftChildOf(i)).getPriority(), heap.get(getRightChildOf(i)).getPriority()) > 0)) {
				swap(i, getLeftChildOf(i)); 
				i = getLeftChildOf(i);
			}
			else {
				swap(i, getRightChildOf(i));
				i = getRightChildOf(i);
			}
		}
	}
}

