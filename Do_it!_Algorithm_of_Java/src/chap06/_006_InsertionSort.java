package chap06;

import java.util.Scanner;

public class _006_InsertionSort {
	
	//단순 삽입 정렬
	static void insertionSort(int[] a, int n) {
		//a배열의 인덱스 1부터 n-1까지 돈다.
		for(int i = 1; i < n; i++) {
			
			System.out.println("------i의 값 = " + i);
			int j;

			int tmp = a[i];
			System.out.println("------tmp의 값 = " + tmp);

			//j는 i와 같은데, j는 0보다 큰 상황이면서 a[i-1]이 tmp보다 큰 상황에서만 반복작업.
			for(j=i; j > 0 && a[j-1] > tmp; j--) {
				System.out.println("------a[j]의 값 : " + a[j]);
				System.out.println("------a[j-1]의 값 : " + a[j-1]);
				
				a[j] = a[j-1];
				System.out.println("------바뀐 a[j]의 값 : " + a[j]);
			}
			a[j] = tmp;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순 선택 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}

		insertionSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]=" + x[i]);
		}

	}

}
