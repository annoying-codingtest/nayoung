import java.io.*;
import java.util.*;

//나이트의 이동에서 이용한 point class 그대로 사용.

public class Bj7569_토마토 {

	private static int M;
	private static int N;
	private static int[][] map;

	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { 1, -1, 0, 0 };

	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 토마토밭 가로칸의 수 (열)
		N = Integer.parseInt(st.nextToken()); // 세로칸의 수 (행)

		// 토마토밭 정보 입력받기
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sb = new StringBuilder();

		bfs();

		System.out.println(sb);

	}

	public static void bfs() {

		Queue<Point> q = new LinkedList<>();

		// 토마토가 있는 좌표 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.offer(new Point(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 0) {
						/*
						 * 처음 토마토가 있는 곳 == map의 좌표 map의 좌표 값은,1 
						 * 그 다음 좌표의 사방을 살펴본 후 날짜를 +1 더해준다.
						 */
						map[nx][ny] = map[p.x][p.y] + 1;
						q.offer(new Point(nx, ny));
					}

				}

			}

		}

		// 최소 날짜 구하기
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 안 익은 게 있으면 -1
					sb.append(-1 + "\n");
					return;
				}
				max = Math.max(max, map[i][j]);

			}
		}

		if (max == 1) { // 토마토가 모두 익은 상태
			sb.append(0);
		} else {
			sb.append(max - 1); // 1부터 시작했으므로 -1해줌.

		}

	}
}
