import java.util.*;
import java.io.*;

public class Bj1743_음식물피하기 {

	private static int N, M;
	private static int[] disX = { 0, 0, -1, 1 };
	private static int[] disY = { 1, -1, 0, 0 };

	private static boolean[][] map, check;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);

		map = new boolean[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);

			map[x][y] = true;
		}

		int max = Integer.MIN_VALUE;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (check[i][j] != true && map[i][j] == true) {
					count = 1;
					bfs(i, j);
					System.out.println(count + "d");

					max = Integer.max(max, count);

				}

			}
		}

		System.out.println(max);
	}

	public static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		check[x][y] = true;

		while (!queue.isEmpty()) {
			Point np = queue.poll();

			for (int i = 0; i < disX.length; i++) {
				int nx = np.x + disX[i];
				int ny = np.y + disY[i];

				System.out.println(nx + " " + ny);
				if (nx < 1 || nx > N || ny < 1 || ny > M)
					continue;
				else {
					if (check[nx][ny] != true && map[nx][ny] == true) {
						queue.add(new Point(nx, ny));
						check[nx][ny] = true;
						count++;
					}
				}

			}

		}

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
