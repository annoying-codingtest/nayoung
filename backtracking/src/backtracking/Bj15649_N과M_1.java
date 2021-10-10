package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj15649_N과M_1 {
	private static int N, M;
	private static int[] arr;
	private static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1]; //1부터 시작하도록
		arr = new int[M];
		dfs(0);

	}

	private static void dfs(int d) {
		
		StringBuilder sb = new StringBuilder();
		if (d == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			System.out.println(sb);
		} else {
			for (int i = 1; i <= N; i++) {
				if (visit[i] == false) {
					visit[i] = true;
					arr[d] = i;
					dfs(d + 1);
					visit[i] = false;
				}
			}
		}

	}
}
