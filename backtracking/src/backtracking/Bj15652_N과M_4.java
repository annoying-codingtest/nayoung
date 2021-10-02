package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N�� M(4)
public class Bj15652_N��M_4 {

	private static int N, M;
	private static int[] arr;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1]; // ���� 1���� ���ϱ�
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
			for (int i = 1; i <= N; i++) { // visit üũ ���ϱ� (���� �ߺ� ����ϵ���)
				if (d == 0 || arr[d - 1] <= i) {
					visit[i] = true;
					arr[d] = i;
					dfs(d + 1);
					// ��Ʈ��ŷ
					visit[i] = false;
				}
			}
		}

	}

}
