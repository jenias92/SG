
public class BiNumber {
	private int first;
	private int second;

	BiNumber(int first, int second) {
		this.SetFirst(first);
		this.SetSecond(second);
	}

	void SetFirst(int first) {
		this.first = first;
	}

	void SetSecond(int second) {
		this.second = second;
	}

	int GetFirst() {
		return this.first;
	}

	int GetSecond() {
		return this.second;
	}

	int add() {
		return this.first + this.second;
	}

	int multiply() {
		return this.first * this.second;
	}

	void double_() {
		this.first *= 2;
		this.second *= 2;
	}
}
