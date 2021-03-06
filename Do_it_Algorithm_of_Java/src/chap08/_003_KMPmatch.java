package chap08;

import java.util.Scanner;

public class _003_KMPmatch {

	static int kmpMatch(String txt, String pat) {
		int pt = 1; // txt 커서
		int pp = 0; // pat 커서
		int[] skip = new int[pat.length() + 1]; // 건너뛰기 표

		// 건너뛰기 표 만들기
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (pat.charAt(pt) == pat.charAt(pp)) {
				skip[++pt] = ++pp;
			} else if (pp == 0) {
				skip[++pt] = pp;
			} else {
				pp = skip[pp];
			}
		}

		// 문자열 검색
		pt = pp = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0) {
				pt++;
			} else {
				pp = skip[pp];
			}
		}

		if (pp == pat.length()) {
			return pt - pp;
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("텍스트 : ");
		String s1 = stdIn.next();

		System.out.print("패턴 : ");
		String s2 = stdIn.next();

		int idx = kmpMatch(s1, s2);
		if (idx == -1) {
			System.out.println("텍스트에 패턴이 없음");
		} else {
			// 일치하는 문자 바로 앞까지의 길이를 구한다.
			int len = 0;
			for (int i = 0; i < idx; i++) {
				len += s1.substring(i, i + 1).getBytes().length;
			}
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자부터 일치한다.");
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
		}
	}

}
