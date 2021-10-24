package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_11866_�似Ǫ������ {

	private static Queue<Integer> queue = new LinkedList<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		sb.append("<");
		permutation(M);

		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.deleteCharAt(sb.lastIndexOf(" "));

		sb.append(">");
		System.out.println(sb);

	}

	public static void permutation(int m) {
		int frontNum = 0;

		while (true) {
			if (queue.size() == 0) { // ��� ���ŵǸ� ����.
				break;
			}
			for (int i = 0; i < m - 1; i++) { // m��° ����� ���� ������ poll�� �� ť�� �ٽ� �ֱ�
				frontNum = queue.poll();
				queue.offer(frontNum);
			}
			sb.append(queue.peek() + ", ");
			queue.poll(); //m��° ��� ����.

		}
	}

}
