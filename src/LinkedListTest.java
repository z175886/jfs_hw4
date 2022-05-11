import java.util.Iterator;

/**
 * @author Chuyang Zhong
 * For testing purpose only.
 *
 */
public class LinkedListTest {
	public static <T> void main(String[] args) {
		LinkedList MyList = new LinkedList();
		LinkedList MyList2 = new LinkedList();
		MyList.add("a");
		MyList.add("b");
		MyList.add("c");
		MyList.add("d");
		MyList.printList();
		//Test contain function
		System.out.println(MyList.contains("e"));
		//Test isEmpty function
		System.out.println(MyList.isEmpty());
		System.out.println(MyList2.isEmpty());
		System.out.println(MyList.remove("d"));
		MyList.printList();
		MyList.add("p",3);
		MyList.add("q");
		System.out.println();
		MyList.printList();
		System.out.println();
		//Test get
		System.out.println(MyList.get(1));
		//Test indexOf
		System.out.println(MyList.indexOf("b"));
		System.out.println("Test remove");
		MyList.remove(3);
		System.out.println();
		MyList.printList();
		System.out.println();
		System.out.println(MyList.getFirst());
		System.out.println(MyList.getLast());
		MyList.addFirst("z");
		System.out.println();
		MyList.printList();
		System.out.println();
		LinkedList MyList3 = new LinkedList();
		MyList3.add("a");
		MyList3.add("b");
		MyList3.add("c");
		MyList3.add("f",2);	
		//MyList3.removeFirst();
		//MyList3.removeLast();
		//MyList3.addLast("k");
		//MyList3.printList();
		MyList3.printList();
		MyList3.remove(2);
		System.out.println();
//		MyList3.removeLast();
//		MyList3.removeLast();
//		MyList3.removeLast();
//		MyList3.removeLast();
//		MyList3.removeLast();
		//MyList3.removeLast();//test nosuchelementexception
		
		//Test iterator
		System.out.println("Test iterator");
		MyList.printList();
		System.out.println();
		Iterator<T> it = MyList.iterator();
		while(it.hasNext()) {
		System.out.println(it.next());
		}
		
	}

}
