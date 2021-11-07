import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bj2667_단지번호붙이기 {

	private static int[] dx = { -1, 0, 1, 0 }; // 각 좌표마다 상하좌우를 체크하기 위한 배열
	private static int[] dy = { 0, -1, 0, 1 };
	private static int N;
	private static int[][] map;

	private static int count;
	private static List<Integer> result = new ArrayList(); // 단지내 집의 수를 저장하기 위한 배열
	private static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];

		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		grouping();

		Collections.sort(result);

		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

	// 각 좌표마다 그룹 짓기 확인
	public static void grouping() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					count = 0; // 또다른 단지를 묶기 위해 카운트 초기화
					dfs(i, j);
					result.add(count);// 단지내 집의 수 저장
				}
			}
		}
	}

	public static void dfs(int x, int y) {

		visit[x][y] = true;
		count++;

		for (int i = 0; i < 4; i++) {
			int checkingX = x + dx[i];
			int checkingY = y + dy[i];

			if (checkingX < 0 || checkingY < 0 || checkingX >= N || checkingY >= N) {
				//x,y좌표가 범위를 넘어갈 경우 넘어가도록
				continue;

			} else if (map[checkingX][checkingY] == 1 && !visit[checkingX][checkingY]) {
				dfs(checkingX, checkingY);
			}
		}

	}

}
