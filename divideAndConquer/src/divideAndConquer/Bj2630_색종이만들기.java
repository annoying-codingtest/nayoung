package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2630_색종이만들기 {

	private static int white = 0;
	private static int blue = 0;
	private static int[][] papers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		papers = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	public static void divide(int row, int col, int size) {

		if (colorCheck(row, col, size)) { // 분할된 현재 사각형의 색깔이 모두 같을 때
			if (papers[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}

		int dividedSize = size / 2;
		divide(row, col + dividedSize, dividedSize); // 1사분면
		divide(row, col, dividedSize); // 2사분면
		divide(row + dividedSize, col, dividedSize); // 3사분면
		divide(row + dividedSize, col + dividedSize, dividedSize); // 4사분면

	}

	// 분할된 사각형의 색깔이 모두 같은지 체크.
	public static boolean colorCheck(int row, int col, int size) {

		int color = papers[row][col]; // 첫 번째 원소를 기준으로 검사

		for (int i = row; i < row + size; i++) { // 첫번쩨 원소좌표 ~ 현재 사각형의 마지막 좌표까지
			for (int j = col; j < col + size; j++) {
				// 색상이 같이 않다면 false를 리턴
				if (papers[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
