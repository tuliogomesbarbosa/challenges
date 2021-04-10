public class RepeatedStrings {

	public static void main(String[] args) {
		String s = "aba";
		var n = 10;
		var repeat = n / s.length();
		var rest = n % s.length();
		int count = 0, extra = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				++count;
			}
		}
		for (int i = 0; i < rest; i++) {
			if (s.charAt(i) == 'a') {
				++extra;
			}
		}
		System.out.println((repeat * count) + extra);
	}
}