import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
	int z;
	int x;
	int y;

	Point2(int z, int x, int y) {
		this.z = z;
		this.x = x;
		this.y = y;
	}
}

public class Bj7569_토마토2 {

	private static int M;
	private static int N;
	private static int H;

	private static int[][][] map;

	private static int[] dy = { 0, 0, -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, 0, 0, -1, 1 };
	private static int[] dz = { -1, 1, 0, 0, 0, 0 };

	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 토마토 창고 가로칸의 수 (열)
		N = Integer.parseInt(st.nextToken()); // 세로칸의 수 (행)
		H = Integer.parseInt(st.nextToken()); // 높이 
		
		// 토마토창고 정보 입력받기
		map = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		sb = new StringBuilder();

		bfs();

		System.out.println(sb);

	}

	public static void bfs() {

		Queue<Point2> q = new LinkedList<>();

		// 토마토가 있는 좌표 찾기
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 1) {
						q.offer(new Point2(h, i, j));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Point2 p = q.poll();

			for (int i = 0; i < 6; i++) {
				int nz = p.z + dz[i];
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
					if (map[nz][nx][ny] == 0) {
						/*
						 * 처음 토마토가 있는 곳 == map의 좌표 
						 * map의 좌표 값은,1 
						 * 그 다음 좌표의 사방을 살펴본 후 날짜를 +1 더해준다.
						 */
						map[nz][nx][ny] = map[p.z][p.x][p.y] + 1;
						q.offer(new Point2(nz, nx, ny));
					}

				}

			}

		}

		// 최소 날짜 구하기
		int max = Integer.MIN_VALUE;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) { // 안 익은 게 있으면 -1
						sb.append(-1 + "\n");
						return;
					}
					max = Math.max(max, map[h][i][j]);

				}
			}
		}

		if (max == 1) { // 토마토가 모두 익은 상태
			sb.append(0);
		} else {
			sb.append(max - 1); // 1부터 시작했으므로 -1해줌.

		}

	}

}
