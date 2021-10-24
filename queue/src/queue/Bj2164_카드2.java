package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2164_ī��2 {

	private static Queue<Integer> queue = new LinkedList<>();
	private static int lastNum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		lastNum = 0;

		for (int i = 1; i <= N; i++) {
			lastNum = i; //������ push�Ǵ� ���� ���� (rear��)
			push(i);
		}

		int frontNum = 0;
		while (true) {

			if (queue.size() == 1) { //ī�尡 �� ���� �Ǹ� ����
				break;
			}
			queue.poll();
			frontNum = queue.poll(); //ù ��° ī�� ���ְ� �� ���� ù��° ī�� ����.

			lastNum = frontNum; // rear���� �ٲ��ְ� ť�� push
			push(frontNum);
		}

		System.out.println(lastNum);

	}

	static void push(int n) {
		queue.offer(n);
	}
}
