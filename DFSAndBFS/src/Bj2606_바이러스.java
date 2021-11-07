import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2606_바이러스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		boolean[] check = new boolean[N + 1];
		StringTokenizer st;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}

		// 이동할 정점이 여러 개라면 작은 정점부터 이동하도록 정렬.
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}

		System.out.println(bfs(list, check, 1));

	}

	public static int bfs(ArrayList<ArrayList<Integer>> list, boolean[] check, int v) {

		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		check[v] = true;

		int count = -1;
		while (!q.isEmpty()) {
			v = q.poll();
			count++;

			for (int i = 0; i < list.get(v).size(); i++) {
				if (!check[list.get(v).get(i)]) { // 방문하지 않은 정점.
					q.add(list.get(v).get(i));
					check[list.get(v).get(i)] = true; // 방문처리
				}
			}
		}
		return count;
	}

}
