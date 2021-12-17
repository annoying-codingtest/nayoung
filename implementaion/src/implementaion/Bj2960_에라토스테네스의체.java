package implementaion;

import java.util.*;

public class Bj2960_에라토스테네스의체 {

	private static ArrayList<Integer> numbers;
	private static int[] removedNum;

	private static int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		numbers = new ArrayList<>();// 2부터 N까지 정수 집합
		removedNum = new int[N + 1];// K번째 지우는 수를 구하기 위한 배열

		for (int i = 2; i <= N; i++) {
			numbers.add(i);
		}
		
		erase();

		System.out.println(removedNum[K]);
		
		scan.close();

	}

	public static void erase() {

		int P = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (isPrime(numbers.get(i)) == true) {
				// 소수이면서 가장 작은 수 P 구하기
				P = numbers.get(i);
				break;
			}
		}

		remove(P);

	}

	public static boolean isPrime(int x) {
		if (x == 2)
			return true;

		for (int i = 2; i < x; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	public static void remove(int P) {
		int PIndex = numbers.indexOf(P);
		// P 삭제 후 삭제된 수들의 배열에 넣어줌.
		numbers.remove(PIndex);
		removedNum[count++] = P;

		for (int i = 0; i < numbers.size(); i++) {
			int Ps = numbers.get(i);
			if (Ps % P == 0) {
				// P의 배수들을 순서대로 지우고 삭제된 수들의 배열에 넣어줌.
				int index = numbers.indexOf(Ps);
				numbers.remove(index);
				removedNum[count++] = Ps;
			} else {
				continue;
			}
		}

		if (!numbers.isEmpty()) {
			erase();
		}

	}

}
