import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1260_DFS와BFS {

	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		// 정점 방문 여부 체크 배열
		boolean[] check = new boolean[N + 1];

		// 정점 개수만큼 ArrayList 안에 ArrayList 만들기.
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			// 정점 서로 연결.
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}

		// 이동할 정점이 여러 개라면 작은 정점부터 이동하도록 정렬.
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}

		sb = new StringBuilder();

		dfs(list, check, V);
		Arrays.fill(check, false); // bfs를 위해 check배열 초기화
		sb.append("\n");
		
		bfs(list, check, V);
		System.out.println(sb);

	}

	static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] check, int v) {
		if (check[v] == true) { // 방문한 정점이면 종료
			return;
		}

		check[v] = true; // 방문 처리
		sb.append(v + " ");

		// 각 정점과 연결된 정점을 탐색
		for (int i = 0; i < list.get(v).size(); i++) {
			if (!check[list.get(v).get(i)]) { // 각 정점에 연결된 정점(들)을 방문했는지 여부
				dfs(list, check, list.get(v).get(i));
			}
		}

	}

	static void bfs(ArrayList<ArrayList<Integer>> list, boolean[] check, int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v); // 탐색 시작 정점 큐에 삽입
		check[v] = true;

		while (!q.isEmpty()) {
			v = q.poll(); // 큐에 삽입된 정점 가져오기.
			sb.append(v + " ");

			for (int i = 0; i < list.get(v).size(); i++) {
				if (!check[list.get(v).get(i)]) { // 방문하지 않은 정점.
					q.add(list.get(v).get(i));
					check[list.get(v).get(i)] = true; // 방문처리
				}
			}
		}

	}

}
