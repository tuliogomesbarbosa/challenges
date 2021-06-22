public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
		char[] chars = s.toCharArray();
		char emptySpace = ' ';
		int counter = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == emptySpace && counter != 0) {
				break;
			}
			if (chars[i] == emptySpace) {
				counter = 0;
				continue;
			}
			if (chars[i] != emptySpace) {
				counter++;
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" ab"));
		System.out.println(lengthOfLastWord("ab "));
		System.out.println(lengthOfLastWord("  ab  "));
	}

}
