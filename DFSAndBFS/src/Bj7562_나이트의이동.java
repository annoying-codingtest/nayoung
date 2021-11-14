import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7562_나이트의이동 {

	private static int I; // 체스판의 크기
	private static boolean[][] check; // 체스판 방문여부 체크
	private static int count[][]; // 나이트의 이동 횟수

	private static int dx[] = { 1, 2, 2, 1, -1, -2, -2, -1 }; // 나이트가 이동할 수 있는 체스판의 범위체크
	private static int dy[] = { 2, 1, -1, -2, -2, -1, 1, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {

			I = Integer.parseInt(br.readLine()); // 체스판의 크기 지정.
			check = new boolean[I][I];
			count = new int[I][I];
			
			Point[] points = new Point[2];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			bfs(points);

			sb.append(count[points[1].x][points[1].y] + "\n");

		}
		System.out.println(sb);
	}

	public static void bfs(Point[] points) {

		Queue<Point> q = new LinkedList<>();

		q.offer(points[0]); // 시작점 좌표
		check[points[0].x][points[0].y] = true;
		count[points[0].x][points[0].y] = 0;

		while (!q.isEmpty()) {

			Point p = q.poll();

			if (p.x == points[1].x && p.y == points[1].y) { // 현재 좌표가 목표 지점일 때 종료.
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				// 범위가 벗어날 경우

				if (nx >= 0 && ny >= 0 && nx < I && ny < I) { // 체스판의 범위에 있으면서,
					if (!check[nx][ny]) { // 방문을 안 한 지점일 경우
						check[nx][ny] = true;
						//나이트 이동 횟수 + 1
						//그냥 count++ 해버리면 나이트가 한 번에 이동할 수 있는 8개의 지점을 갈 때마다 +1되는거임
						count[nx][ny] = count[p.x][p.y] + 1; 
						q.offer(new Point(nx, ny));

					}
				}

			}
		}

	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
