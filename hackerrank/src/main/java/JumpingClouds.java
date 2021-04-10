public class JumpingClouds {
	static int jumpingOnClouds(int[] c) {
		int numberOfSteps = -1;
		int n = c.length;
		for (int i = 0; i < n; i++, numberOfSteps++) {
			if (i < n - 2 && c[i + 2] == 0) i++;
		}
		return numberOfSteps;
	}

	public static void main(String[] args) {
		int[] c = new int[]{0, 0, 0, 1, 0, 0};
		int result = jumpingOnClouds(c);
		System.out.println(result);
	}
}