package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _008_PhysExamSearch {

	static class PhyscData {
		private String name;
		private int height;
		private double vision;

		public PhyscData(String name, int height, double vision) {
			super();
			this.name = name;
			this.height = height;
			this.vision = vision;
		}

		@Override
		public String toString() {
			return name + " " + height + " " + vision;
		}

		public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

		private static class HeightOrderComparator implements Comparator<PhyscData> {
			public int compare(PhyscData d1, PhyscData d2) {
				return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = {
				new PhyscData("이나령", 162, 0.3),
				new PhyscData("기뫼인", 163, 0.7),
				new PhyscData("바지그", 165, 0.2),
				new PhyscData("저여주", 169, 0.6),
				new PhyscData("기대거", 170, 0.9),
				new PhyscData("기워주", 172, 1.1),
				new PhyscData("구항", 173, 2.0),
		};
		System.out.print("몇 cm인 사람을 찾고 있나요? : ");
		int height = stdIn.nextInt();
		int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
		
		if(idx<0) {
			System.out.println("요소가 없습니다.");
		} else {
			 System.out.println("x[" + idx + "]에 있습니다.");
			 System.out.println("찾은 데이터 : " + x[idx]);
		}
	}
}