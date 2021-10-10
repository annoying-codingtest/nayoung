package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치 함수

public class Bj1003_피보나치함수 {

	public static int[][] memo = new int[41][2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		memo[0][0] = 1; // N=0일 때 0의 호출 횟수
		memo[0][1] = 0; // N=0일 때 1의 호출 횟수
		memo[1][0] = 0; // N=1일 때 ...
		memo[1][1] = 1;

		// fibonacci(n) = fibonacci(n-1) + fibonacci(n-2);
		// N이 i일 때 0의 호출 횟수와 1의 호출 횟수들을 미리 memo에 저장.
		for (int i = 2; i < 41; i++) {
			for (int j = 0; j < 2; j++) {
				memo[i][j] = memo[i - 1][j] + memo[i - 2][j];
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//테스트 케이스 개수 N
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			//fibonacchi(n)의 0의 호출횟수와 1의 호출 횟수
			sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
		}

		System.out.println(sb);

	}

}
