package chap01;

public class _017_Example13_MultiPlus {

	public static void main(String[] args) {
		System.out.println("-------------덧셈표--------------");

		System.out.print("   |");
		for (int i = 1; i <= 9; i++)
			System.out.printf("%3d", i);
		System.out.println("\n---+---------------------------");
		
		for (int i = 1; i <= 9; i++) {
			System.out.print(i + "  |");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i + j);
			}
			System.out.println();
		}
	}

}
