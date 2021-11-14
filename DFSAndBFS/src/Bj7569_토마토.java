import java.io.*;
import java.util.*;

//����Ʈ�� �̵����� �̿��� point class �״�� ���.

public class Bj7569_�丶�� {

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
		M = Integer.parseInt(st.nextToken()); // �丶��� ����ĭ�� �� (��)
		N = Integer.parseInt(st.nextToken()); // ����ĭ�� �� (��)

		// �丶��� ���� �Է¹ޱ�
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

		// �丶�䰡 �ִ� ��ǥ ã��
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
						 * ó�� �丶�䰡 �ִ� �� == map�� ��ǥ map�� ��ǥ ����,1 
						 * �� ���� ��ǥ�� ����� ���캻 �� ��¥�� +1 �����ش�.
						 */
						map[nx][ny] = map[p.x][p.y] + 1;
						q.offer(new Point(nx, ny));
					}

				}

			}

		}

		// �ּ� ��¥ ���ϱ�
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // �� ���� �� ������ -1
					sb.append(-1 + "\n");
					return;
				}
				max = Math.max(max, map[i][j]);

			}
		}

		if (max == 1) { // �丶�䰡 ��� ���� ����
			sb.append(0);
		} else {
			sb.append(max - 1); // 1���� ���������Ƿ� -1����.

		}

	}
}
