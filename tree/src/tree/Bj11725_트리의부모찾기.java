package tree;

import java.util.*;
import java.io.*;

public class Bj11725_트리의부모찾기 {

	private static int n;
	private static int[] parent;
	private static boolean[] visited;
	private static ArrayList<Integer>[] tree; //Map으로는 안되는지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		tree = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		parent = new int[n + 1];
		visited = new boolean[n + 1];
		dfs(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);

		br.close();
	}

	private static void dfs(int a) {
		for (int v : tree[a]) {
			if (visited[v]) {
				continue;
			} else {
				parent[v] = a;
				visited[v] = true;
				dfs(v);
			}

		}
	}
}
