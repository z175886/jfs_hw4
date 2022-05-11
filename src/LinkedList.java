import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Chuyang Zhong
 *
 * @param <T> Generic Types
 */
public class LinkedList<T> implements List<T> {
	
	private Node head,tail;//There are always the first and last nodes
	private int size;//This is the number of items in the list
	private class Node {
		Node next , prev ;
		T data ;
		}
    
    private class ListIterator implements Iterator<T> {
        Node cursor = head;
        int counter = -1;

        /**
         * Returns true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            //cursor.next!=null;
            return cursor != null;
        }

        /**
         * Returns the next element in the iteration
         */
        @Override
        public T next() {
            T value = cursor.data;
            cursor = cursor.next;;
            counter++;
            return value;
        }

        /**
         * Removes from the underlying collection the last element returned by this iterator
         * This method can be called only once per call to next().
         */ 
        @Override
        public void remove() {
            LinkedList.this.remove(counter);//remove(int index)
            if (counter == 0) counter = -1;
        }
    }
    
	//Constructor
	public LinkedList() {
		//do nothing
	}
	
	/**
	 * 
	 * Append the specified element to the end of this list
	 * 
	 */
	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		addLast(item);// append
	}

	/**
	 * 
	 * Removes all of the element from the list.
	 * The list will be empty.
	 * 
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Node temp = new Node();
		while(this.head!=null) {
			temp=head.next;
			head=head.next;
			temp=null;
		}
	}

	/**
	 * 
	 * Return true if the list contains the (at least one)specified element.
	 *
	 */
	@Override
	public boolean contains(Object item) {
		// TODO Auto-generated method stub
		Node n = head;
		while(n != null) {
			if(n.data == item) return true;
				n = n.next;
		}
		return false;
	}

	/**
	 * 
	 * Return true if the collection contains no element.
	 *
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	/**
	 * Removes a single instance of the specified element from this collection
	 *
	 */
	@Override
	public T remove(Object item) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		return remove(indexOf(item));
		
	}

	/**
	 * Return the number of item
	 * 
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * An iterator over a collection
	 * 
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		
		//return new ListIterator();
		return new ListIterator();
	
	}

	/**
	 * Insert the specified element at the specified position in this list.
	 * Sifts the element currently at that position(if any) 
	 * and any subsequent elements to the right (adds one to their indices)
	 *
	 */
	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) return;
		
		Node newNode =new Node();
		newNode.data=item;
		// add the head
		if (index == 0) {
			addFirst(item);
		}
		// add to tail
		else if (index == size) {
			addLast(item);
		}
		//add to the mid of list
		else {
			Node n = head;
			int counter = 0;
			while(counter != index) {
				n = n.next;
				counter++;
			}
			newNode.prev = n.prev;
			newNode.next = n; 
			n.prev.next = newNode;
			n.prev = newNode;
			size++;
		}
	}

	/**
	 * 
	 * Return the element at the specified position in this list
	 *
	 */
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if(index<0 ||index>=size) throw new  IndexOutOfBoundsException ();
		if(isEmpty()) return null;
		Node n = head;
		int counter=0;
		while(counter != index) {
			n = n.next;
			counter++;
		}
		return n.data;
	}
		

	/**
	 * 
	 * Return the index of the first occurrence of the specified element in the list
	 *
	 */
	@Override
	public int indexOf(Object item) {
		// TODO Auto-generated method stub
		if(isEmpty()) return -1;
		Node n = head;
		int counter = 0;
		while(n != null) {
			if(item.equals(n.data)) {
				return counter;
			}
			n = n.next;
			counter++;
		}
		
		return -1;
	}

	/**
	 * Remove the element at the specified position in this list.
	 * Shifts any subsequent elements to the left(Subtracts one from their indices)
	 *	
	 * Return the element that was removed.
	 */
	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		if(index >= size || index < 0) return null;
		if(index==0) return removeFirst();
		else if (index==size-1)return removeLast();
		else {
			Node n = head;
			int counter = 0;
			while (counter != index) {
				n=n.next;
				counter++;
			}
			n.prev.next = n.next;
			n.next.prev = n.prev;
			n.prev = null;
			n.next = null;
			size--;
			return n.data;
		}

	
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		// TODO method stub
		if(!isEmpty()) {
		return head.data;}
		else {
		throw new NoSuchElementException();}
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		// TODO method stub
		if(!isEmpty()) {
			return tail.data;
		}else {
			throw new NoSuchElementException();}
		
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item the item to add
	 */
	public void addFirst(T item) {
		// TODO method stub		
		Node newNode =new Node();
		newNode.data=item;
		if(isEmpty()) {
			head = tail = newNode;
		}else {
			newNode.next=head;
			head.prev=newNode;
			head=newNode; //newNode become the head	
		}
		size++;
	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item the item to add
	 */
	public void addLast(T item) {
		// TODO method stub
		Node newNode =new Node();
		newNode.data=item;
		if(isEmpty()) {
			head = tail = newNode;
		}else {
			newNode.prev=tail;
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		// TODO method stub
		if(head!=null) {
			T value = head.data;
			Node temp = head;//head pointer
			head=head.next;
			if(head!=null)head.prev=null;// case list has more than one node before remove
			temp.next=null;
			size--;
			if(size==0)tail=null;//special case list has only one node before remove,need to set head to null as well
			return value;
		}
		else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		// TODO method stub
		if(tail!=null) {//not empty
			T value = tail.data;
			Node temp =tail;
			tail=tail.prev; 
			if(tail!=null)tail.next=null;// case list has more than one node before remove
			temp.prev=null;
			size--;
			if(size==0) head=null;//special case list has only one node before remove,need to set head to null as well
			return value;
		}else {
			throw new NoSuchElementException();
		}
	}
	
    /**
     * Print out the content of the linked list
     * 
     */
    public void printList()
    {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    
    
}
