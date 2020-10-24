package chap02;

import java.util.Scanner;

public class _008_DayOfYear {

	//각 달의 일수(평년과 윤년의 배열)
	static int[][] mdays = {
			{31,28,31,30,31,30,31,31,30,31,30,31},
			{31,29,31,30,31,30,31,31,30,31,30,31}
	};
	
	// 윤년 = 1, 평년 = 0 리턴
	static int isLeap(int year) {
		return(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0 ;
	}
	
	//y년 m월 d일의 그 해 경과일수
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		
		//m-1월까지의 일수를 계산
		for(int i = 1; i < m; i++) {
			days += mdays[isLeap(y)][i-1];
		}
		return days;
	
	}

	
	static int leftDayOfYear(int y, int m, int d) {
int days = d;
		
		//m-1월까지의 일수를 계산
		for(int i = 1; i < m; i++) {
			days += mdays[isLeap(y)][i-1];
		}
		
		//윤년일 때, 윤년 아닐때
		if(isLeap(y)==1) {
			return 366 - days;
		} else {
			return 365 - days;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		
		System.out.println("그 해 남은 일수를 구합니다.");
		
		do {
			System.out.print("년 : "); int year = stdIn.nextInt();
			System.out.print("월 : "); int month = stdIn.nextInt();
			System.out.print("일 : "); int day = stdIn.nextInt();
			
			System.out.printf("남은 날은 %d일입니다.\n", leftDayOfYear(year, month, day));
			
			System.out.print("한 번 더 할까요?(1.예 / 2. 아니요");
			retry = stdIn.nextInt();
		} while(retry == 1);		
		
		System.out.println("그 해 경과 일수를 구합니다.");
		
		do {
			System.out.print("년 : "); int year = stdIn.nextInt();
			System.out.print("월 : "); int month = stdIn.nextInt();
			System.out.print("일 : "); int day = stdIn.nextInt();
			
			System.out.printf("그 해의 %d일째입니다.\n", dayOfYear(year, month, day));
			
			System.out.print("한 번 더 할까요?(1.예 / 2. 아니요");
			retry = stdIn.nextInt();
		} while(retry == 1);		
	}
}