package chap03;

import java.util.Scanner;

public class _005_Example03 {

	//a[n]에서 ky와 일치하는 모든 요소의 인덱스를 idx[]에 순서대로 저장
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//배열 생성
		System.out.print("요솟수를 입력하세요 : ");
		int num = input.nextInt();
		int a[] = new int[num];

		System.out.print("a[0]의 값 :");
		a[0] = input.nextInt();				

		for(int i = 1; i < a.length; i++) {
				System.out.print("a[" + i + "]의 값 :");
				a[i] = input.nextInt();	
		}
		
		System.out.print("찾는 값 : ");
		int key = input.nextInt();				
		int count = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i]==key) {
				count++;
			}
		}
		
		int[] idx = new int[count];
		
		searchIdx(a, num, key, idx);
		
	}
	

	//배열, 배열의 크기, 키값, 키값의 크기를 넣은 인덱스 배열
	static void searchIdx(int[] a, int n, int key, int[] idx) {
		
		int idxCnt = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i]==key) {
			 idx[idxCnt++] = i;
			}			
		}
		
		System.out.println(idxCnt);
	}

}
