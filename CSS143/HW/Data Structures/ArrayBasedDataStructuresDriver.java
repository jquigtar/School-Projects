/**
 *  ArrayBasedDataStructuresDriver
 *  
 *  this is a class that tests the stack, queue and arrayList 
 *  classes for the homework assignment in css 143
 * @author jquigtar
 * @version 1/31/19
 * 
 */

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		stackTests();
		System.out.println();
		queueTests();
		System.out.println();
		arrayListTests();
	}

	private static void arrayListTests() {
		//todo: make more tests here
		System.out.println("Testing ArrayList Class: ");
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList();
		ArrayList c = new ArrayList();

		a.insert('B', 0);
		a.insert('a',0);
		a.insert('t',1);
		a.insert('c',0);
		a.insert('D',0);
		a.insert('E',1);

		b.insert('B', 0);
		b.insert('a',0);
		b.insert('t',1);
		b.insert('c',0);
		b.insert('D',0);
		b.insert('E',1);

		c.insert('B', 0);
		c.insert('a',1);
		c.insert('t',2);
		c.insert('c',3);
		c.insert('D',4);
		c.insert('E',0);

		System.out.println("order for list c should be EBatcD");
		System.out.println(c.toString());
		System.out.println();

		System.out.println("TESTING c.get(2) (should be a): " + c.get(2));
		System.out.println("TESTING c.indexOf(c) (should be 4): " + c.indexOf('c'));
		System.out.println();

		System.out.println("order for list a should be DEcatB");
		System.out.println(a.toString());
		System.out.println();

		System.out.println("a.equals(b) (should be true) TEST: " + a.equals(b));
		System.out.println("a.equals(c)(should be false) TEST: " + a.equals(c));
		while(a.isEmpty() == false) {
			System.out.println(a.remove(0) + " WAS REMOVED FROM LIST A");
		}
		System.out.println("a.isEmpty (should be true) TEST: " + a.isEmpty());

	}

	private static void queueTests() {
		//todo: make more tests here
		System.out.println("Testing Queue Class: ");
		Queue a = new Queue();
		Queue b = new Queue();
		Queue c = new Queue();
		Queue d = new Queue();

		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');
		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');

		b.enqueue('B');
		b.enqueue('a');
		b.enqueue('t');
		b.enqueue('B');
		b.enqueue('a');
		b.enqueue('a');

		c.enqueue('B');
		c.enqueue('a');
		c.enqueue('t');
		c.enqueue('t');
		c.enqueue('a');

		d.enqueue('B');
		d.enqueue('a');
		d.enqueue('t');
		d.enqueue('B');
		d.enqueue('a');
		d.enqueue('t');

		System.out.println("order for Queue c should be Batta");
		System.out.println(c.toString());
		System.out.println("TESTING c.size() (should be 5): " + c.size());
		System.out.println();

		System.out.println("order for Queue a should be BatBat");
		System.out.println(a.toString());
		System.out.println("TESTING a.equals(c) (should be false): " + a.equals(c));
		System.out.println("TESTING a.equals(b) (should be false): " + a.equals(b));
		System.out.println("TESTING a.equals(d) (should be true): " + a.equals(d));

		System.out.println();

		System.out.println("TESTING QUEUE A a.toString(): " + a.toString());

		while(a.isEmpty() == false) {
			System.out.println(a.dequeue() + " WAS DEQUEUED FROM FRONT OF QUEUE");
			System.out.println(a.toString());
		}
		System.out.println("a.isEmpty (should be true) TEST: " + a.isEmpty());

	}

	private static void stackTests() {
		//todo: make more tests here
		System.out.println("Testing Stack Class: ");
		Stack a = new Stack();
		Stack b = new Stack();
		Stack c = new Stack();
		Stack d = new Stack();

		a.push('B');
		a.push('a');
		a.push('t');

		b.push('B');
		b.push('a');

		c.push('B');
		c.push('a');
		c.push('k');

		d.push('B');
		d.push('a');
		d.push('t');

		System.out.println("TESTING STACK A a.toString (should be taB)");  
		System.out.println(a.toString());
		System.out.println();

		System.out.println("TESTING STACK B b.size (2): " + b.size());  
		System.out.println("TESTING a.equals(b) (should be false): " + a.equals(b));  
		System.out.println("TESTING a.equals(c) (should be false): " + a.equals(c));  
		System.out.println("TESTING a.equals(d) (should be true): " + a.equals(d));  
		System.out.println();

		System.out.println("TESTING a.pop()");
		while(a.isEmpty() == false) {
			System.out.println(a.pop() + " HAS BE POPPED FROM TOP OF STACK");
		}
		System.out.println("TESTING a.isEmpty() (should be true): " + a.isEmpty());
	}
}
