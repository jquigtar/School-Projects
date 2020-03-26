/**
 * 
 * @author jquigtar
 *
 */
public class CallStack{

	// Called by func1()
	void func2 (){
		System.out.println("In func2 method");
		int a = 0;
		int b;
		b = 10 / a;
	}

	//Called by Main
	void func1(){
		System.out.println("In func1 method");
		this.func2 ();
		System.out.println("Back in func1 method");

	}

	public static void main (String args[]){
		try {
			CallStack myCallStack;
			myCallStack = new CallStack();
			System.out.println("In the main method");
			myCallStack.func1 ();
		}
		catch(ArithmeticException e){
			System.out.println("Math exception was thrown");
		}
	}
}

