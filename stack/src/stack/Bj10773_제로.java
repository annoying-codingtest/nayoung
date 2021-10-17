package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj10773_���� {

	static ArrayList<Integer> s = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int money = Integer.parseInt(br.readLine());

			switch (money) {
			case 0: 
				pop();
				continue;

			default:
				push(money);

			}

		}

		System.out.println(moneySum());
	}

	static void push(int n) {
		s.add(n);

	}

	static void pop() { 
		s.remove(s.size() - 1);

	}

	static int moneySum() {
		int moneySum = 0;

		if (s.size() > 0) { //���ÿ� ���Ұ� ���� ��쿡�� �� ���ϱ�
			for (int i = 0; i < s.size(); i++) {
				moneySum += s.get(i);
			}
			return moneySum;

		} else { //���ÿ� ���� ������ 0 ���
			return 0;
		}

	}

}
