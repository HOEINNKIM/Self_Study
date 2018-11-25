package chap01;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class _022_Example17 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;

		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");

		do {
			System.out.println("몇 단 삼각형입니까? : ");
			n = stdIn.nextInt();
		} while (n <= 0);

		npira(n);
	}
	static void npira(int n) {
		for (int i = 1; i <= n; i++) {

			for (int j = n; j >= i; j--) {
				System.out.print(" ");
			}

			for (int j = 1; j <= (i * 2) - 1; j++) {
				System.out.print(i%10);
			}
			System.out.println();
		}
	}

}
