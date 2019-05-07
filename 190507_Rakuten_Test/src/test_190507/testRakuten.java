package test_190507;

public class testRakuten {

	public static String solution(int A, int B) {

		int flagA = 0;
		int flagB = 0;
		String result = "";
		int big;
		int small;
		int sum = A + B;
		if (A == 0 && B == 0) {
			return result;
		}

		if (A > B) {
			big = A;
			small = B;

			for (int i = 0; i < sum; i++) {

				if (big != 0) {

					if (flagA != 2) {
						flagA += 1;
						big -= 1;
						result += "a";
					} else {
						flagA = 0;
						small -= 1;
						result += "b";
					}

				} else {

					if (small != 0) {
						small -= 1;
						result += "b";
					}
				}
			}

		} else if (A < B) {
			big = B;
			small = A;

			for (int i = 0; i < sum; i++) {

				if (big != 0) {

					if (flagA != 2) {
						flagA += 1;
						big -= 1;
						result += "b";
					} else {
						flagA = 0;
						small -= 1;
						result += "a";
					}

				} else {

					if (small != 0) {
						small -= 1;
						result += "a";
					}
				}
			}

		} else {

			for (int i = 0; i < (A + B) / 2; i++) {
				result += "ab";
			}
		}

		return result;

	}

	public static void main(String[] args) {

		System.out.println(solution(3, 4));
	}
}
