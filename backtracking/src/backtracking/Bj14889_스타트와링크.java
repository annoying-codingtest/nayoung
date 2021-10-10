package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14889_스타트와링크 {

	public static int N;
	public static int[][] map;
	public static boolean[] visit;

	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0,0);
		System.out.println(min);
	}

	private static void dfs(int idx, int d) {
		/*
		 * start팀과 link팀은 구분만 하면 되기 때문에 
		 * visit배열의 값이 true인 팀 / false인 팀으로 나누기
		 * 
		 */
		if (d == N / 2) {
			diff_status();
			return;
		} else {
			for (int i = idx; i < N; i++) {
				if (visit[i] == false) {
					visit[i] = true;
					dfs(i+1, d + 1);
					// 백 트래킹
					visit[i] = false;
				}
			}
		}

	}

	static void diff_status() {
		int startTeam = 0; // 스타트팀의 총 능력치
		int linkTeam = 0; // 링크팀의 총 능력치

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// i 번째 사람과 j 번째 사람이 true다 -> 스타트팀의 능력치에 더하기
				if (visit[i] == true && visit[j] == true) {
					startTeam += map[i][j];
					startTeam += map[j][i];
				}
				// i 번째 사람과 j 번째 사람이 false다 -> 링크팀의 능력치에 더하기
				else if (visit[i] == false && visit[j] == false) {
					linkTeam += map[i][j];
					linkTeam += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차
		int diff = Math.abs(startTeam - linkTeam);
		
		// 각 팀 조합의 경우마다 능력치 합의 최솟값 갱신
		min = Math.min(diff, min);

	}

}
