package chap05;

import java.util.Scanner;

import java.util.Scanner;

public class _001_Factorial {

	static int factorial(int n) {
		if(n > 0) {
			System.out.println(n + "에 대한 팩토리얼 시작");
			return n * factorial(n-1);
		} else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 ! : ");
		int x= stdIn.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
	}

}
