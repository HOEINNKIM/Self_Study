package chap01;

import java.util.Scanner;

public class _009_Example07 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = stdIn.nextInt();
		int sum = 0;
		String checkSum = "1";

		for(int i = 1; i <=n; i++) {
			sum+=i;
			if(i>1) {
				checkSum += " + " + i;
			}
		}
		System.out.println(checkSum + " = " + sum);
	}

}
