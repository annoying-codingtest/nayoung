package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//(2)�� ���� : �������� �� ĭ -> ó�� ���� �ڷ� ������
//(3)�� ���� : ���������� �� ĭ -> �� �� ���� ������ 

public class Bj1021_ȸ���ϴ�ť {

	private static LinkedList<Integer> dq = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}

		int count = 0;

		for (int i = 0; i < M; i++) {

			// ������ �̰��� �ϴ� ������ ��ġ(index) ã��
			int target_idx = dq.indexOf(arr[i]);
			int half_idx;

			if (dq.size() % 2 == 0) {
				half_idx = dq.size() / 2 - 1;
			} else {
				half_idx = dq.size() / 2;
			}

			// Ÿ�� ������ ��ġ <= �߰� ����
			if (target_idx <= half_idx) {
				// Ÿ�� ������ ��ġ���� �տ� �ִ� ���ҵ��� ��� �ڷ� ������. (2�� ����)
				for (int j = 0; j < target_idx; j++) {
					int temp = dq.pollFirst();
					dq.offerLast(temp);
					count++;
				}
			} else { // Ÿ�� ������ ��ġ > �߰�����
				// Ÿ�� ���Ҹ� ������ �ڿ� �ִ� ���ҵ��� ��� ������ ������. (3�� ����)
				for (int j = 0; j < dq.size() - target_idx; j++) {
					int temp = dq.pollLast();
					dq.offerFirst(temp);
					count++;
				}

			}
			dq.pollFirst(); // ������ ������ �� �� ���Ҹ� �̾Ƴ���
		}

		System.out.println(count);

	}
}
