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
	private static ArrayList<ArrayList<Integer>> graph;
	private static boolean[] check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int M = Integer.parseInt(st.nextToken()); // ������ ����
		int V = Integer.parseInt(st.nextToken()); // Ž�� ���� ���� ��ȣ

		graph = new ArrayList<ArrayList<Integer>>();

		// ���� �湮 ���� üũ �迭
		check = new boolean[N + 1];

		// ���� ������ŭ ArrayList �ȿ� ArrayList �����.
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			// ���� ���� ����.
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		// �̵��� ������ ���� ����� ���� �������� �̵��ϵ��� ����.
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		sb = new StringBuilder();

		dfs(V);
		Arrays.fill(check, false); // bfs�� ���� check�迭 �ʱ�ȭ
		sb.append("\n");

		bfs(V);
		System.out.println(sb);

	}

	static void dfs(int v) {
		if (check[v] == true) { // �湮�� �����̸� ����
			return;
		}

		else {
			check[v] = true; // �湮 ó��
			sb.append(v + " ");

			// �� ������ ����� ������ Ž��
			for (int i = 0; i < graph.get(v).size(); i++) {
				int nv = graph.get(v).get(i);
				if (!check[nv]) { // �� ������ ����� ����(��)�� �湮�ߴ��� ����
					dfs(nv);
				}
			}

			
		}

	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(v); // Ž�� ���� ���� ť�� ����
		check[v] = true;

		while (!q.isEmpty()) {
			v = q.poll(); // ť�� �߰��� ���� ��������.
			sb.append(v + " ");

			for (int i = 0; i < graph.get(v).size(); i++) {
				int nv = graph.get(v).get(i);
				if (!check[nv]) { // �湮���� ���� ����.
					q.offer(nv);
					check[nv] = true; // �湮ó��
				}
			}
		}

	}

}
