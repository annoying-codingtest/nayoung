import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1012_�������� {

	private static int M;
	private static int N;

	private static int map[][];
	private static boolean check[][];

	private static int[] dx = { 0, 0, -1, 1 }; // �ϳ��� ��ǥ���� �����¿츦 ���Ǳ� ���� x,y�迭
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			M = Integer.parseInt(st.nextToken()); // ���߹� ����
			N = Integer.parseInt(st.nextToken()); // ���߹� ����
			int K = Integer.parseInt(st.nextToken()); // ���� �ɾ��� ��ġ

			map = new int[M][N];
			check = new boolean[M][N];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;

			}

			int count = 0; //������ ���� �� ����

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && check[i][j] != true) {
						check[i][j]=true;
						dfs(i, j);
						// �ϳ��� ���������� ã�� ���� �ֹ��� ��++;
						count++;
					}
				}
			}
			sb.append(count + "\n");

		}

		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		// �����¿� Ž��
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (map[nx][ny] == 1 && check[nx][ny] != true) {
					check[nx][ny]=true;
					dfs(nx, ny);
				}
			}
		}

	}

}
