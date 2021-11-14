import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7562_����Ʈ���̵� {

	private static int I; // ü������ ũ��
	private static boolean[][] check; // ü���� �湮���� üũ
	private static int count[][]; // ����Ʈ�� �̵� Ƚ��

	private static int dx[] = { 1, 2, 2, 1, -1, -2, -2, -1 }; // ����Ʈ�� �̵��� �� �ִ� ü������ ����üũ
	private static int dy[] = { 2, 1, -1, -2, -2, -1, 1, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {

			I = Integer.parseInt(br.readLine()); // ü������ ũ�� ����.
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

		q.offer(points[0]); // ������ ��ǥ
		check[points[0].x][points[0].y] = true;
		count[points[0].x][points[0].y] = 0;

		while (!q.isEmpty()) {

			Point p = q.poll();

			if (p.x == points[1].x && p.y == points[1].y) { // ���� ��ǥ�� ��ǥ ������ �� ����.
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				// ������ ��� ���

				if (nx >= 0 && ny >= 0 && nx < I && ny < I) { // ü������ ������ �����鼭,
					if (!check[nx][ny]) { // �湮�� �� �� ������ ���
						check[nx][ny] = true;
						//����Ʈ �̵� Ƚ�� + 1
						//�׳� count++ �ع����� ����Ʈ�� �� ���� �̵��� �� �ִ� 8���� ������ �� ������ +1�Ǵ°���
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
