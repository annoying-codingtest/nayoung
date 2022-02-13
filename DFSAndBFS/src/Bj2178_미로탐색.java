import java.util.*;
import java.io.*;

public class Bj2178_¹Ì·ÎÅ½»ö {

	private static int[] disX = { 0, 0, -1, 1 };
	private static int[] disY = { 1, -1, 0, 0 };
	private static int N, M;
	private static int[][] map;
	private static boolean[][] check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ss = br.readLine().split(" ");
		N = Integer.parseInt(ss[0]);
		M = Integer.parseInt(ss[1]);

		map = new int[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		System.out.println(bfs(0, 0));

	}

	public static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(x, y));
		check[x][y] = true;

		while (!q.isEmpty()) {

			Point np = q.poll();

			if (np.x == N - 1 && np.y == M - 1) {
				return map[N - 1][M - 1];
			}

			for (int k = 0; k < disX.length; k++) {
				int nx = np.x + disX[k];
				int ny = np.y + disY[k];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (check[nx][ny] == false && map[nx][ny] == 1) {
						check[nx][ny] = true;
						map[nx][ny] = map[np.x][np.y] + 1;
						q.add(new Point(nx, ny));
					}

				}

			}

		}
		return map[N - 1][M - 1];

	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
