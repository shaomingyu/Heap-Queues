package structures;

import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
	
	private StudentArrayHeap<Integer,V> heap = new StudentArrayHeap<Integer,V>(new ReverseIntegerComparator());
	
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		if(priority == null || value == null) {
			throw new NullPointerException();
		}
		heap.add(priority, value);
		return this;
	}
	
	public V dequeue() {
		if(heap.isEmpty()) {
			throw new IllegalStateException();
		}
		return heap.remove();
	}
	
	public V peek() {
		if(heap.isEmpty()) {
			throw new IllegalStateException();
		}
		return heap.peek();
	}
	
	public Iterator<Entry<Integer, V>> iterator() {
		return heap.asList().iterator();
	}
	
	public Comparator<Integer> getComparator() {
		return heap.getComparator();
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	
}

