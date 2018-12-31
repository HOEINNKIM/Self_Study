package chap05;

public class _005_Example05 {

	static void recur3(int n) {
		IntStack s = new IntStack(n);
		
		if(n > 0) {
			recur3(n - 1);
			recur3(n - 2);
			System.out.println(n);
		}
		
		while(true) {
			if(n > 0) {
				
			}
			if(s.isEmpty() != true) {
				
			}
		}
		
	}
	/*while(true) {
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
*/	
	public static void main(String[] args) {
		
	}

}
