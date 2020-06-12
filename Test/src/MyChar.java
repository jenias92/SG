
public class MyChar {

	private char c;

	MyChar(char c) {
		this.c = c;
	}

	public boolean isVowel() {
		if (this.c == 'a' || this.c == 'e' || this.c == 'i' || this.c == 'o' || this.c == 'u') {
			return true;
		} else if (this.c == 'A' || this.c == 'E' || this.c == 'I' || this.c == 'O' || this.c == 'U') {
			return true;
		}
		return false;
	}

	public boolean isNumber() {
		if ((int) this.c >= 48 && (int) this.c <= 57) {
			return true;
		}
		return false;
	}

	public boolean isAlphabet() {
		if (((int) this.c >= 97 && (int) this.c <= 122) || ((int) this.c >= 65 && (int) this.c <= 90)) {
			return true;
		}
		return false;
	}

	public void printLowerCaseAlphabet() {
		if ((int) this.c >= 65 && (int) this.c <= 90) {
			int lower = (int) this.c + 32;
			System.out.printf("%c", (char) lower);
		}
	}

	public void printUpperCaseAlphabet() {
		if (((int) this.c >= 97 && (int) this.c <= 122)) {
			int upper = this.c - 32;
			System.out.printf("%c", (char) upper);
		}
	}
}
