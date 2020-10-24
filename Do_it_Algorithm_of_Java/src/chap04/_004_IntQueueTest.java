package chap04;

import java.util.Scanner;

public class _004_IntQueueTest {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		_003_IntQueue s = new _003_IntQueue(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1) 인큐	(2)디큐	(3)피크	(4)덤프	(5)찾기	(0)종료 :");
			
			int menu = stdIn.nextInt();
			if(menu == 0) {
				break;
			}
			
			int x;
			switch(menu) {
			case 1:
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					s.enque(x);
				} catch(_001_IntStack.OverflowIntStackException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
				
			case 2:
				try {
				x = s.deque();
				System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch(_001_IntStack.EmptyIntStackException e) {
					System.out.println("큐가 비어있습니다..");
				}
				break;
				
			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch(_001_IntStack.EmptyIntStackException e) {
						System.out.println("큐가 비어있습니다..");
					}
					break;
			case 4:
				s.dump();
				break;
			
			case 5:
				System.out.print("찾을 데이터 : ");
				x = stdIn.nextInt();
				try {
					int loc = s.search(x);
					System.out.println(x + "데이터는 큐 안에서" + loc + "번째에 있습니다.");
				} catch(Exception e) {
					System.out.println("에러 발생");
					continue;
				}
				
			}
		}
	}

}
