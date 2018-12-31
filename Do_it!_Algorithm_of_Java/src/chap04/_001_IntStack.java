package chap04;

public class _001_IntStack {
	private int max;	//스택 용량
	private int ptr;	//스택 포인터
	private int[] stk;	//스택 본체
	
	public _001_IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];			//스택 본체 배열 생성
		} catch(OutOfMemoryError e) {	//생성 불가
			max = 0;
		}
	}
	
	//실행 예외 : 스택이 비어있다.
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	//실행 예외  : 스택이 꽉차다.
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	//스택에 x 푸시
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}
	
	//스택에서 데이터를 팝
	public int pop() throws EmptyIntStackException {
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}
	
	//스택 꼭데기 데이터 확인
	public int peek() throws EmptyIntStackException {
		if(ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr-1];
	}
	
	//스택에서 x를 찾아 인덱스(없으면 -1) 반환
	public int indexOf(int x) {
		for(int i = ptr -1; i >=0; i--) {
			if(stk[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	//스택을 비움
	public void clear() {
		ptr = 0;
	}
	
	//스택의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//스택에 쌓인 데이터 수를 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비었는지 확인
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//스택이 가득찼는지 확인
	public boolean isFull() {
		return ptr >= max;
	}
	
	//스택 안 모든 데이터를 바닥 -> 꼭대기 순으로 출력
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		} else {
			for(int i = 0; i < ptr; i++) {
				System.out.println(stk[i] + " ");
			}
			System.out.println();	
		}
	}
}
