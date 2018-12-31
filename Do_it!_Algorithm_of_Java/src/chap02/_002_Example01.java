package chap02;

import java.util.Scanner;

public class _002_Example01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("배열 a의 길이를 입력 : ");
		int num = input.nextInt();
		
		int a[] = new int[num];
		for(int i = 0; i < a.length; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = input.nextInt();
		}

		reverse(a);
	}

	public static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	public static void reverse(int[] a) {
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		};
		
		for(int i = 0 ; i < a.length / 2; i++) {	
			System.out.println("\na[" + i + "]과(와) a[" + (a.length-i-1) + "]를 교환합니다.");
			swap(a, i, a.length-i-1);
			
			for(int j = 0 ; j < a.length; j++) {
				System.out.print(a[j] + ", ");
			}
			
		}
		
		System.out.println("\n역순 배열 끝");
	}


}
