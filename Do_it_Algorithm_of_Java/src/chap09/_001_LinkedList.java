package chap09;

public class _001_LinkedList<E> {

	public _001_LinkedList() {
		head = crnt = null;
	}
	
	public void addFirst(E obj) {
		Node<E> ptr = head;
		head = crnt = new Node<E>(obj, ptr);
	}
	
	public void addLast(E obj) {
		if(head == null) {
			addFirst(obj);
		} else {
			Node<E> ptr = head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	public void removeFirst(){
		if(head != null) {
			head = crnt = head.next;
		}
	}
	
	public void removeLast() {
		if(head != null) {
			if(head.next == null) {
				removeFirst();
			}
		} else {
			Node<E> ptr = head;
			Node<E> pre = head;
			
			while(ptr.next != null) {
				pre = ptr;
				ptr = ptr.next;
			}
			pre.next = null;
			crnt = pre;
		}
	}
	
	public void remove(Node p) {
		if(head != null) {
			if(p == head) {
				removeFirst();
			} else {
				Node<E> ptr = head;
				
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) {
						return;
					}
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}
	
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	public void clear() {
		while(head != null) {
			removeFirst();
		}
		crnt = null;
	}
	
	public boolean next() {
		if(crnt == null || crnt.next == null) {
			return false;
		}
		crnt = crnt.next;
		return true;
	}
	
	public void printCurrentNode() {
		if(crnt == null) {
			System.out.println("선택한 노드가 없습니다.");
		} else {
			System.out.println(crnt.data);
		}
	}

	//모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		
		while(ptr!=null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	class Node<E> {
		private E data;			//데이터
		private Node<E> next;	//뒤 포인터(다음 노드 참조)
		
		
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> crnt;
}
