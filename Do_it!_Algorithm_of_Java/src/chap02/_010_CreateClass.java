package chap02;

public class _010_CreateClass {

	class YMD {
		int y;	//year
		int m;	//month
		int d;	//day
		
		YMD(int y, int m, int d){
			this.y = y;
			this.m = m;
			this.d = d;
		}
		
		void after(int n) {
			System.out.print(n + "일 뒤의 날짜는 : " + y + "년 " + m + "일 " + (d+n) + "일 입니다." );
		}

		void before(int n) {
			System.out.print(n + "일 뒤의 날짜는 : " + y + "년 " + m + "일 " + (d-n) + "일 입니다." );
		}
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
