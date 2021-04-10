package core.java;

public class TailRecursion {

	public int normalRecursion(int n) {
		if (n < 1) {
			return 0;
		}

		return n + normalRecursion(n - 1);
	}

	public int tailRecursion(int n, int acc) {
		if (n < 1) {
			return acc;
		}

		return tailRecursion(n - 1, acc + n);
	}

	public int iteration(int n) {
		int acc = 0;
		while (n > 0) {
			acc += n;
			n--;
		}
		return acc;
	}

	public static void main(String[] args) {
		TailRecursion tr = new TailRecursion();
		System.out.println(tr.iteration(5));
	}
}
