package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N-Queen
//퀸의 이동위치: 상하좌우 대각선 상관없이 한 방향으로 이동 가능 
public class Bj9663_NQueen {
	
	private static int[] chess;
	public static int N;
	public static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];

		nQueen(0);
		System.out.println(count);
	}

	public static void nQueen(int d) {
		if (d == N) {
			count++;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				chess[d] = i;
				if (check(d)) { 
					nQueen(d + 1);
				}
			}
		}
	}

	public static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (chess[col] == chess[i]) // 퀸과 같은 행에 있거나
				return false;
			else if (Math.abs(col - i) == Math.abs(chess[col] - chess[i])) // 퀸과 대각선에 있으면
				//열의 차 == 행의 차
				return false;
		}
		return true; // 1열에 퀸을 놓았을때
	}

}
