package chap07;

public class _001_IntSet {

	//int 집합
	private int max;	//집합의 최대 개수
	private int num;	//집합의 요소 개수
	private int[] set;	//집합 본체
	
	
	//생성자
	public _001_IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max];			//집합 배열 생성
		} catch(OutOfMemoryError e) {	//배열 생성 실패
			max = 0;
		}
	}
	
	//집합의 최대 개수
	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}
	
	//집합에서 n을 검색
	public int indexOf(int n) {
		for(int i = 0; i < num; i++) {
			if(set[i] == n) {
				return i;
			}
		}
		return -1;
	}
	
	//집합에 n이 있는지 없는지 확인
	public boolean contains(int n) {
		return (indexOf(n) != -1) ? true : false;
	}
	
	//집합에 n 추가
	public boolean add(int n ) {
		if(num >= max || contains(n) == true) {
			return false;
		} else {
			set[num++] = n;
			return true;
		}
	}
	
	//집합에서 n 삭제
	public boolean remove(int n) {
		int idx;									//n이 저장된 요소의 인덱스
		
		if(num <= 0 || (idx = indexOf(n)) == -1) {	//비어 있거나 n이 존재하지 않습니다.
			return false;
		} else {
			set[idx] = set[--num];					//마지막 요소를 삭제한 곳으로 옮긴다.
			return true;
		}
	}
	
	
	//집합 s에 복사
	public void copyTo(_001_IntSet s) {
		int n = (s.max < num) ? s.max : num;
		for(int i = 0; i < n; i++) {
			s.set[i] = set[i];
		}
		s.num = n;
	}
	
	//집합 s를 복사
	public void copyFrom(_001_IntSet s) {
		int n = (max < s.num) ? max : s.num;
		for(int i = 0; i < n; i++) {
			set[i] = s.set[i];
			num = n;
		}
	}
	
	public boolean equalTo(_001_IntSet s) {
		if(num != s.num) {
			return false;
		}
		
		for(int i = 0; i < num; i++) {
			int j = 0;
			for(; j < s.num; j++) {
				if(set[i] == s.set[j]) {
					break;
				}
			}
			if(j == s.num) {
				return false;
			}
		}
		return true;
	}
	
	//결과 s1과 s2의 합집합을 복사
	public void unionOf(_001_IntSet s1, _001_IntSet s2) {
		copyFrom(s1);
		for(int i = 0; i < s2.num; i++) {
			add(s2.set[i]);
		}
	}
	
	//{a,b,c}형식의 문자열로 표현을 바꾼다.
	public String toString() {
		StringBuffer temp = new StringBuffer("{"); 
		for(int i = 0; i < num; i++) {
			temp.append(set[i] + " ");
		}
		temp.append("}");
		return temp.toString();
	}
}
