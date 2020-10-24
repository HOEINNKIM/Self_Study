package chap03;

import java.util.Scanner;

public class _004_SeqSearchSenPractice {

	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		
		a[n] = key;

		//_002_의 while 구문을 for문으로 바꾼다.
		for(int j = 0;j < n; j++) {
			if(a[j] == key) {
				i = j;
				break;
			}			
		}							
		
		return i == n ? -1 : i;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1];
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
		
		int idx = seqSearch(x, num, ky);
		
		if(idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(ky+ "는 x[" + idx + "]에 있습니다.");
		}	
	}
}
