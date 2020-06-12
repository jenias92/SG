
public class BiNumberRunner {

	public static void main(String[] args) {
		BiNumber numbers = new BiNumber(2, 3);
		System.out.println(numbers.add());
		System.out.println(numbers.multiply());
		numbers.double_();
		System.out.println(numbers.GetFirst());
		System.out.println(numbers.GetSecond());
	}

}
