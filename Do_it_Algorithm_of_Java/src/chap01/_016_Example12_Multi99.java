package chap01;

public class _016_Example12_Multi99 {

	public static void main(String[] args) {
		System.out.println("-------------곱셈표--------------");

		System.out.print("   |");
		for (int i = 1; i <= 9; i++)
			System.out.printf("%3d", i);
		System.out.println("\n---+---------------------------");
		
		for (int i = 1; i <= 9; i++) {
			System.out.print(i + "  |");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i * j);
			}
			System.out.println();
		}
	}

}
