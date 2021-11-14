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

public class Bj7569_�丶��2 {

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
		M = Integer.parseInt(st.nextToken()); // �丶�� â�� ����ĭ�� �� (��)
		N = Integer.parseInt(st.nextToken()); // ����ĭ�� �� (��)
		H = Integer.parseInt(st.nextToken()); // ���� 
		
		// �丶��â�� ���� �Է¹ޱ�
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

		// �丶�䰡 �ִ� ��ǥ ã��
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
						 * ó�� �丶�䰡 �ִ� �� == map�� ��ǥ 
						 * map�� ��ǥ ����,1 
						 * �� ���� ��ǥ�� ����� ���캻 �� ��¥�� +1 �����ش�.
						 */
						map[nz][nx][ny] = map[p.z][p.x][p.y] + 1;
						q.offer(new Point2(nz, nx, ny));
					}

				}

			}

		}

		// �ּ� ��¥ ���ϱ�
		int max = Integer.MIN_VALUE;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) { // �� ���� �� ������ -1
						sb.append(-1 + "\n");
						return;
					}
					max = Math.max(max, map[h][i][j]);

				}
			}
		}

		if (max == 1) { // �丶�䰡 ��� ���� ����
			sb.append(0);
		} else {
			sb.append(max - 1); // 1���� ���������Ƿ� -1����.

		}

	}

}
