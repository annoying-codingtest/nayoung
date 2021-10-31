package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1780_종이의개수 {

	private static int[][] papers;
	private static int zero = 0;
	private static int one = 0;
	private static int minusOne = 0;

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
		
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);


	}

	public static void divide(int row, int col, int size) {

		if (checkNumber(row, col, size)) {
			if (papers[row][col] == 0) {
				zero++;
			} else if (papers[row][col] == 1) {
				one++;
			} else {
				minusOne++;
			}
			return;
		}

		int dividedSize = size / 3;

		// 1 2 3
		// 4 5 6
		// 7 8 9
		divide(row, col, dividedSize);
		divide(row, col + dividedSize, dividedSize);
		divide(row, col + 2 * dividedSize, dividedSize);

		divide(row + dividedSize, col, dividedSize);
		divide(row + dividedSize, col + dividedSize, dividedSize);
		divide(row + dividedSize, col + 2 * dividedSize, dividedSize);

		divide(row + 2 * dividedSize, col, dividedSize);
		divide(row + 2 * dividedSize, col + dividedSize, dividedSize);
		divide(row + 2 * dividedSize, col + 2 * dividedSize, dividedSize);

	}

	public static boolean checkNumber(int row, int col, int size) {

		int firstNum = papers[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (papers[i][j] != firstNum)
					return false;
			}
		}

		return true;
	}

}
