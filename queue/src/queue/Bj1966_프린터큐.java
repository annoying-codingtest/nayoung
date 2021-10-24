package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1966_������ť {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < tc; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // ������ ��
			int x = Integer.parseInt(st.nextToken()); // ���°�� �μ�Ǿ����� �ñ��� ����

			int ans = 0;
			st = new StringTokenizer(br.readLine()); // ������ �߿䵵

			LinkedList<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < N; i++)
				q.add(Integer.parseInt(st.nextToken())); // ť�� ������ �߿䵵 �߰�

			while (!q.isEmpty()) {

				boolean flag = true; // ���� �������� �߿䵵�� ���� ������ �ִ��� üũ
				for (int i = 1; i < q.size(); i++) {
					if (q.peek() < q.get(i)) { // ���� �������� �߿䵵�� �������
						flag = false;
						break;
					}
				}

				// ������ ���� �������� �߿䵵�� ������ ���°��
				if (flag) {
					ans++; // ���� ��� �μ� +1
					q.poll(); // ���� ��� �μ��ؼ� �����ϱ�
					if (x == 0) {
						sb.append(ans + "\n");
						break; // ���� �μ��Ϸ��� ������ �ñ��� �����ΰ��

					} else
						x--; // ���� �μ��Ϸ��� ������ �ñ��� ������ �ƴѰ��

				}

				// ������ ���� �������� �߿䵵�� ������ �ִ°�� -> ���� ���� ���� �ڷ� �̵�
				else {
					// ���� ��� ���� �� �������� �ֱ�
					int temp = q.poll();
					q.add(temp);

					/*
					 * ���� ������ �ñ��� �����ΰ�� -> ���� �ڷ� �̵��ϹǷ� Queue�� ������-1�� �ε��� ���� �ñ����� ���� �����ΰ�� -> �ε��� -1
					 */
					if (x == 0)
						x = q.size() - 1;
					else
						x -= 1;

				}
			}
		}
		
		System.out.println(sb);

	}

}
