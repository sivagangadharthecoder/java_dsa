public class ConstructorExample {

	public ConstructorExample() {
		System.out.println("this is a zero-parameter constructor");
	}
	
	private static void function() {
		System.out.println("this is dummy function");
		ConstructorExample ce1 = new ConstructorExample();
		ce1.function2();
	}
	
	private void function2() {
		System.out.println("this is dummy function 2");
	}

	public static void main(String[] args) {
		function();
		
	}
}
