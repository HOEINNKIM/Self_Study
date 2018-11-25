package chap01;

import java.util.Scanner;

public class _013_Example11 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int a;
		int b;

		System.out.print("a의 값 : ");
		a = stdIn.nextInt();

		do {
			System.out.print("b의 값 : ");
			b = stdIn.nextInt();
			if(a>b) {
				System.out.println("a보다 큰 값을 입력하세요!");
			}
		} while (a > b);
			
		System.out.println("b - a는 " + (b-a) + " 입니다.");
	}

}
