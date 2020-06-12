
public class MyCharRunner {

	public static void main(String[] args) {
		MyChar myChar = new MyChar('c');
		System.out.println(myChar.isVowel());
		System.out.println(myChar.isNumber());
		System.out.println(myChar.isAlphabet());
		myChar.printLowerCaseAlphabet();
		myChar.printUpperCaseAlphabet();
		String str = "This is a text";
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

}
