package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14888_연산자끼워넣기 {

	private static int N; //수의 개수
	private static int[] numbers; //수열 A1, A2, .. An
	private static int min = Integer.MAX_VALUE; //최솟값엔 최댓값 , 최대값엔 최솟값
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String ns = br.readLine();
		StringTokenizer st = new StringTokenizer(ns);
		
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		ns = br.readLine();
		st = new StringTokenizer(ns);
		int op[] = new int[4]; //각 연산자들 개수 넣기 + - * /
		for (int i = 0; i < op.length; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, op[0], op[1], op[2], op[3], numbers[0]);

		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int count, int p, int s, int m, int d, int sum) {

		if (count == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		if (p > 0) {
			dfs(count + 1, p - 1, s, m, d, sum + numbers[count]);
		}
		if (s > 0) {
			dfs(count + 1, p, s - 1, m, d, sum - numbers[count]);
		}
		if (m > 0) {
			dfs(count + 1, p, s, m - 1, d, sum * numbers[count]);
		}
		if (d > 0) {
			dfs(count + 1, p, s, m, d - 1, sum / numbers[count]);
		}

	}

}
