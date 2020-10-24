package chap02;

public class _004_Example02_ArrayReverse {

	public static void copy(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
	}

	public static void rcopy(int[] a, int[] b) {
		for(int i =0 ; i < a.length; i++) {
			b[i] = a[a.length-i-1];
			System.out.println(b[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = new int[5];
		copy(a, b);
		rcopy(a, b);	
	}
}
