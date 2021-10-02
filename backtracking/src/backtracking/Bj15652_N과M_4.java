package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M(4)
public class Bj15652_N과M_4 {

	private static int N, M;
	private static int[] arr;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1]; // 숫자 1부터 세니까
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
			for (int i = 1; i <= N; i++) { // visit 체크 안하기 (숫자 중복 허용하도록)
				if (d == 0 || arr[d - 1] <= i) {
					visit[i] = true;
					arr[d] = i;
					dfs(d + 1);
					// 백트래킹
					visit[i] = false;
				}
			}
		}

	}

}
