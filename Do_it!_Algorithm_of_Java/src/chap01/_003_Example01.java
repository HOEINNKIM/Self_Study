package chap01;

public class _003_Example01 {

	public static void main(String[] args) {
	//연습문제 1 : 네 값의 최댓값을 구하는 max4 메서드 작성
	//연습문제 2 : 세 값의 최솟값을 구하는 min3 메서드 작성
	//연습문제 3 : 네 값의 최솟값을 구하는 min4 메서드 작성

		System.out.println("max4(1,2,4,3) = " + max4(1,2,4,3));
		System.out.println("min3(1,2,4) = " + min3(1,2,4));
		System.out.println("min4(1,2,4,3) = " + min4(1,2,4,3));
		
	}

	public static int max4(int a, int b, int c, int d) {
		int max = a;
		if(b>max) {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		if(d>max) {
			max = d;
		}
		return max;
	}

	public static int min3(int a, int b, int c) {
		int min = a;
		if(a<min) {
			min = a;
		}
		if(b<min) {
			min = b;
		}
		if(c<min) {
			min = c;
		}
		return min;
	}

	public static int min4(int a, int b, int c, int d) {
		int min = a;
		if(a<min) {
			min = a;
		}
		if(b<min) {
			min = b;
		}
		if(c<min) {
			min = c;
		}
		if(d<min) {
			min = d;
		}
		return min;
	}

}
