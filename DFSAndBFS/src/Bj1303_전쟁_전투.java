import java.util.*;
import java.io.*;

public class Bj1303_¿¸¿Ô_¿¸≈ı {

	private static int[] disX = { 0, 0, -1, 1 };
	private static int[] disY = { 1, -1, 0, 0 };
	private static int N, M, W, B;
	private static char[][] map;
	private static boolean[][] check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ss = br.readLine().split(" ");
		N = Integer.parseInt(ss[0]);
		M = Integer.parseInt(ss[1]);

		map = new char[M][N];
		check = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] == false) {
					if (map[i][j] == 'W') {
						int w = bfs(i, j);
						W += w * w;
					} else {
						int b = bfs(i, j);
						B += b * b;
					}
				}
			}
		}

		System.out.println(W + " " + B);

	}

	public static int bfs(int x, int y) {
		Queue<Point> Q = new LinkedList<>();

		check[x][y] = true;
		int count = 1;
		Q.add(new Point(x, y));

		if (map[x][y] == 'W') {

			while (!Q.isEmpty()) {

				Point np = Q.poll();

				for (int k = 0; k < disX.length; k++) {
					int nx = np.x + disX[k];
					int ny = np.y + disY[k];

					if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
						if (check[nx][ny] == false && map[nx][ny] == 'W') {
							check[nx][ny] = true;
							count++;
							Q.add(new Point(nx, ny));
						}

					}

				}

			}

		} else {

			while (!Q.isEmpty()) {

				Point np = Q.poll();

				for (int k = 0; k < disX.length; k++) {
					int nx = np.x + disX[k];
					int ny = np.y + disY[k];

					if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
						if (check[nx][ny] == false && map[nx][ny] == 'B') {
							check[nx][ny] = true;
							count++;
							Q.add(new Point(nx, ny));
						}

					}

				}

			}

		}
		return count;

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
