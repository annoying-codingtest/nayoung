import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1260_DFS��BFS {

	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int M = Integer.parseInt(st.nextToken()); // ������ ����
		int V = Integer.parseInt(st.nextToken()); // Ž�� ���� ���� ��ȣ

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		// ���� �湮 ���� üũ �迭
		boolean[] check = new boolean[N + 1];

		// ���� ������ŭ ArrayList �ȿ� ArrayList �����.
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			// ���� ���� ����.
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}

		// �̵��� ������ ���� ����� ���� �������� �̵��ϵ��� ����.
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}

		sb = new StringBuilder();

		dfs(list, check, V);
		Arrays.fill(check, false); // bfs�� ���� check�迭 �ʱ�ȭ
		sb.append("\n");
		
		bfs(list, check, V);
		System.out.println(sb);

	}

	static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] check, int v) {
		if (check[v] == true) { // �湮�� �����̸� ����
			return;
		}

		check[v] = true; // �湮 ó��
		sb.append(v + " ");

		// �� ������ ����� ������ Ž��
		for (int i = 0; i < list.get(v).size(); i++) {
			if (!check[list.get(v).get(i)]) { // �� ������ ����� ����(��)�� �湮�ߴ��� ����
				dfs(list, check, list.get(v).get(i));
			}
		}

	}

	static void bfs(ArrayList<ArrayList<Integer>> list, boolean[] check, int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v); // Ž�� ���� ���� ť�� ����
		check[v] = true;

		while (!q.isEmpty()) {
			v = q.poll(); // ť�� ���Ե� ���� ��������.
			sb.append(v + " ");

			for (int i = 0; i < list.get(v).size(); i++) {
				if (!check[list.get(v).get(i)]) { // �湮���� ���� ����.
					q.add(list.get(v).get(i));
					check[list.get(v).get(i)] = true; // �湮ó��
				}
			}
		}

	}

}
