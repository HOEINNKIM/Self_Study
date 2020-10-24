package chap02;

import java.util.Scanner;

public class _005_CardConv {

	public static int cardConvR(int x, int r, char[] d) {
		int digits = 0; //변환 후의 자릿수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x%r);	//r로 나눈 나머지 값을 dchar에서 뽑아 저장.
			x /= r;								//x를 r로 나눈 몫으로 변경
		} while(x != 0);
		return digits;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;		//변환하려는 정수
		int cd;		//기수
		int dno;	//변환 후의 자릿수
		int retry;	//한번 더?
		char[] cno = new char[32];
		
		System.out.println("10진수를 기수 변환합니다.");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수 : ");
				no = stdIn.nextInt();
			}while(no<0);
			
			do {
				System.out.print("어떤 진수로 변환할까요? (2~36) : ");
				cd = stdIn.nextInt();
			} while(cd<2||cd>36);
			
			dno = cardConvR(no, cd, cno);
			System.out.print(cd + "진수로는 ");
			for(int i = dno - 1; i>=0; i--) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");
			
			System.out.print("한번 더 할까요? (1.예 / 2. 아니요) : ");
			retry = stdIn.nextInt();
		} while(retry == 1);
		
		System.out.println("10진수를 기수 변환하여 윗자리부터 나타냅니다.");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수 : ");
				no = stdIn.nextInt();
			}while(no<0);
			
			do {
				System.out.print("어떤 진수로 변환할까요? (2~36) : ");
				cd = stdIn.nextInt();
			} while(cd<2||cd>36);
			
			dno = cardConvR(no, cd, cno);
			System.out.print(cd + "진수로는 ");
			for(int i = 0; i<=dno-1; i++) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");
			
			System.out.print("한번 더 할까요? (1.예 / 2. 아니요) : ");
			retry = stdIn.nextInt();
		} while(retry == 1);
	}
	
	//윗자리를 앞에 넣어두는 메서드 만들어보기
	//x : 바꾸려는 정수, r : 기수, d : 위치를 윗자리부터 차곡차곡 쌓는 배열
	public static int cardConv(int x, int r, char[] d) {
		int digits = 0; //변환 후의 자릿수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {		
			d[digits++] = dchar.charAt(x%r);
			x /= r;
		}while(x!=0);
		
		//배열의 순서를 바꾸는 방법을 사용
		for(int i= 0; i < digits / 2; i++) {
			char temp = d[i];
			d[i] = d[digits-i-1];
			d[digits-i-1] = temp;
		}
		
		return digits;
	}
	
	
}