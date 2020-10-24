package chap01;

public class _005_Example02_Median {

	public static void main(String[] args) {
		System.out.println(med3(7,5,3));
	}

	public static int med3(int a, int b, int c) {
		if(a>=b) {
			if(b>=c) {
				return b;
			}else if(a<=c) {
				return a;
			}else {
				return c;
			}
		} else if(b>c) {
			return c;
		} else {
			return b;
		}
	}
}
