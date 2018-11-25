package chap01;

public class _011_Example10_Sumof {

	public static void main(String[] args) {
		System.out.println(sumof(3,6));
		System.out.println(sumof(6,3));
	}
	
	static int sumof(int a, int b) {
		int sum = 0;
		if(a>b) {
			for(int i = b; b <= a; b++) {
				sum+=i;
				i++;
			}
			return sum;
		} else if(a<b) {
			for(int i = a; a <= b; a++) {
				sum+=i;
				i++;
			}
			return sum;
		} else {
			return a;
		}
	}
}
