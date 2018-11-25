package chap01;

import java.util.Scanner;

public class _011_Example011 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int a;
		
		do {
		System.out.print("숫자를 입력하세요 :");
		a = stdIn.nextInt();
		if(a<0) {
			System.out.println("양의 정수를 입력하세요.");
		}
		} while (a<0);
		
		String k = Integer.valueOf(a).toString();
		int column = k.length();
		System.out.println("그 수는 " + column + "자리입니다.");
		
	}
}
