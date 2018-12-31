package chap04;

public class _003_IntQueue {
	private int max;	//큐의 용량
	private int front;	//첫 번째 요소 커서
	private int rear;	//마지막 요소 커서
	private int num;	//현재 데이터 수
	private int[] que;	//큐 본체
	
	//생성자
	public _003_IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];			//큐 본체용 배열 생성
		} catch (OutOfMemoryError e) {	//생성 불가
			max = 0;
		}
	}	

	//실행 시 예외 : 큐가 비어 있다.
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	
	//실행 시 예외 : 큐가 가득 참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	//큐에 데이터 인큐
	public int enque(int x) throws OverflowIntQueueException{
		if(num >= max) {
			throw new OverflowIntQueueException();
		}
		que[rear++] = x;
		num++;
		if(rear == max) {
			rear = 0;
		}
		return x;
	}
	
	//큐에서 데이터 디큐
	public int deque() throws EmptyIntQueueException{
		if(num <= 0) {
			throw new EmptyIntQueueException();
		}
		int x = que[front++];
		num--;
		if(front == max) {
			front = 0;
		}
		return x;
	}	
	
	//큐에서 데이터 피크(front 데이터를 확인)
	public int peek() throws EmptyIntQueueException{
		if(num <= 0) {
			throw new EmptyIntQueueException(); //큐가 비어있다.
		}
		return que[front];	
	}
	
	//큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
	public int indexOf(int x) {
		for(int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if(que[idx] == x) {
				return idx;	//검색 성공
			}
		}
		return -1;	//검색 실패
	}
	
	//큐를 비운다.
	public void clear() {
		num = front = rear = 0;
	}
	
	//큐의 용량
	public int capacity() {
		return max;
	}
	
	//큐에 쌓인 데이터 수 반환
	public int size() {
		return num;
	}
	
	//큐가 비었는지 확인
	public boolean isEmpty() {
		return num<=0;
	}
	
	//큐가 가득 찼는지 확인
	public boolean isFull() {
		return num >= max;
	}
	
	public void dump() {
		if(num <= 0) {
			System.out.println("큐가 비어있다.");
		} else {
			for(int i = 0; i < num; i++) {
				System.out.print(que[(i +front) % max] + " ");
			}
			System.out.println();
		}
	}
	
	public int search(int x) {
		if(num <= 0) {
			System.out.println("큐가 비어있다.");
		} else {
			for(int i = 0; i < num; i++) {	
				if (que[(i + front) % max] == x) {
					return i + 1;
				}
			}
		}
		return 0;
	}
	
}
