import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1012_유기농배추 {

	private static int M;
	private static int N;

	private static int map[][];
	private static boolean check[][];

	private static int[] dx = { -1, 1, 0, 0 }; // 하나의 좌표기준 상하좌우를 살피기 위한 x,y배열
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			M = Integer.parseInt(st.nextToken()); // 배추밭 가로
			N = Integer.parseInt(st.nextToken()); // 배추밭 세로
			int K = Integer.parseInt(st.nextToken()); // 배추 심어진 위치

			map = new int[M][N];
			check = new boolean[M][N];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;

			}

			int count = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					// dfs 조건
					if (map[i][j] == 1 && check[i][j] != true) {
						dfs(i, j);
						// 하나의 집단을 찾고 나면 애벌레 수++;
						count++;
					}
				}
			}
			sb.append(count + "\n");

		}

		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		check[x][y] = true;

		// 상하좌우 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (map[nx][ny] == 1 && check[nx][ny] != true) {
					dfs(nx, ny);
				}
			}
		}

	}

}
