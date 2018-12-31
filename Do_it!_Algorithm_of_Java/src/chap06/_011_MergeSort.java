package chap06;

import java.util.Scanner;

public class _011_MergeSort {

	static int[] buff;
	
	//a[left] ~ a[right]를 재귀적으로 병합 정렬하기
	static void __mergeSort(int[] a, int left, int right){
		if(left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;
			
			//배열 앞부분을 병합 정렬
			__mergeSort(a, left, center);
			//배열 뒷부분을 병합 정렬
			__mergeSort(a, center + 1, right);
			
			for(i = left; i <= center; i++) {
				buff[p++] = a[i];
			}
			
			while(i <= right && j < p) {
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			}
			
			while(j < p) {
				a[k++] = buff[j++];
			}			
		}
	}
	
	//병합 정렬
	static void mergeSort(int[] a, int n) {
		buff = new int[n];
		
		__mergeSort(a, 0, n - 1);
		
		buff = null;		
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("병합 정렬");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		mergeSort(x, nx);
		
		System.out.println("오름차순으로 정렬했다.");
		
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]=" + x[i]);
		}
	}
}
