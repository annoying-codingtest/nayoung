import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1697_숨바꼭질 {

	private static int N; // 수빈
	private static int K; // 동생

	private static int check[];
	private static int[] ways; 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		check = new int[100001];
		Arrays.fill(check, -1);
		
		bfs();

		System.out.println(check[K]);

	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		q.add(N);
		check[N] = 0;

		ways = new int[3]; // 현재 좌표 기준 3가지 방법으로 이동할 수 있음.

		while (!q.isEmpty()) {
			int qn = q.poll();

			ways[0] = qn - 1;
			ways[1] = qn + 1;
			ways[2] = qn * 2;

			if (qn == K) { // 목표 지점이면 종료
				return;
			}

			for (int i = 0; i < 3; i++) { // 현재 좌표 기준 3가지의 방법 각각 확인

				if (ways[i] >= 0 && ways[i] <= 100000) { // 현재 좌표가 범위에 있는지 체크
					if (check[ways[i]] == -1) {
						check[ways[i]] = check[qn] + 1;
						q.offer(ways[i]);
					}
				}
			}
		}
		

	}

}
