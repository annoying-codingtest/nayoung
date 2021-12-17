package implementaion;

import java.util.*;

public class Bj2960_�����佺�׳׽���ü {

	private static ArrayList<Integer> numbers;
	private static int[] removedNum;

	private static int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		numbers = new ArrayList<>();// 2���� N���� ���� ����
		removedNum = new int[N + 1];// K��° ����� ���� ���ϱ� ���� �迭

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
				// �Ҽ��̸鼭 ���� ���� �� P ���ϱ�
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
		// P ���� �� ������ ������ �迭�� �־���.
		numbers.remove(PIndex);
		removedNum[count++] = P;

		for (int i = 0; i < numbers.size(); i++) {
			int Ps = numbers.get(i);
			if (Ps % P == 0) {
				// P�� ������� ������� ����� ������ ������ �迭�� �־���.
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
