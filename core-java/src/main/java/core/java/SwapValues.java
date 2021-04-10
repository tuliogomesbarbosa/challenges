package core.java;

public class SwapValues {

	public static void main(String[] args) {
		int a = 90;
		int b = 110;
		a = a + b; // 200
		b = a - b; // 90
		a = a - b;

		System.out.println("New a: " + a);
		System.out.println("New b: " + b);
	}

}
