package chap05;

public class _003_RecurX2 {

	static void recur(int n) {
		IntStack s = new IntStack(n);
		
		while(true) {
			if(n > 0) {
				s.push(n);
				n = n-1;
				 continue;
			}
			if(s.isEmpty() != true) {
				n = s.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
	}
	
	public static void main(String[] args) {
	}

}
