package chap02;

public class _006_PrimeNumber2 {

	public static void main(String[] args) {
		int counter = 0;			//나눗셈의 횟수 계산
		int ptr = 0;				//찾은 소수의 개수
		int[] prime = new int[500];	//소수를 저장하는 배열
		
		prime[ptr++] = 2;
		
		for(int i = 3; i <= 1000; i += 2) {
			int j;
			for(j = 1; j < ptr; j++) {
				counter++;
				if(i % prime[j] == 0) {
					break;
				}
			}
			if(ptr == j) {
				prime[ptr++] = i;
			}
		}

		for(int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("나눗셈을 수행한 횟수 : " + counter);	
	}

}
