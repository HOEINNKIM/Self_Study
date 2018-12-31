package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _009_Example07 {

	public static final Comparator<Integer> VISION_SIGHT = new VisionOrderComparator();
	
	public static class VisionOrderComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return (o1 > o2) ? 1 : (o1 < o2) ? -1 : 0;
		}
	}
	
	
	//시력에 대한 신체검사 데이터
	//내림차순으로 정렬
	//특정 시력을 가진 사람을 이진 함수로 뽑기
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("몇 명의 사람을 등록할건가요 ? :");
		int people = input.nextInt();
		
		int[] arr = new int[people];
		
		
		System.out.println("안내 : 시력이 높은 순서부터 낮은 순서로 등록해주셔야 합니다.");
		
		
		System.out.print("[0]번째 시력을 등록합니다. : ");
		arr[0] = input.nextInt();
		
		for(int i = 1; i < people; i++) {
			do {
				System.out.print("[" + i + "]번째 시력을 등록합니다. : ");
				arr[i] = input.nextInt();				
			}while(arr[i-1] < arr[i]);
		}

		System.out.println("등록을 완료하였습니다.");
		System.out.print("검색할 시력을 입력하세요 : ");
		int check = input.nextInt();
		int idx = Arrays.binarySearch(arr, check);
		//, _009_Example07.VISION_SIGHT	
	}
}
