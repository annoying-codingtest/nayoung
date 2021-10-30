package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1992_쿼드트리 {

	private static int[][] quadTree;
	private static StringBuilder sb =  new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		quadTree = new int[N][N];


		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				quadTree[i][j] = st.charAt(j) - '0';
			}
		}

		
		divide(0,0,N);
		
		System.out.println(sb);

	}

	public static void divide(int row, int col, int size) {

		if (checkNumber(row, col, size)) {
			sb.append(quadTree[row][col]); // 압축할 수 있으면 해당 사각형 첫 원소의 값으로 압축
			return;
		}

		int dividedSize = size / 2;

		sb.append('(');	// 각 레벨(depth)에서 여는괄호로 시작.
		
		// 분할순서가 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래.
		divide(row, col, dividedSize);
		divide(row, col + dividedSize, dividedSize);
		divide(row + dividedSize, col, dividedSize);
		divide(row + dividedSize, col + dividedSize, dividedSize);
		
		sb.append(')');	// 해당 레벨이 끝나면 닫는괄호.


	}

	public static boolean checkNumber(int row, int col, int size) {
		int firstNum = quadTree[row][col]; // 첫 번째 원소를 기준으로 검사

		for (int i = row; i < row + size; i++) { // 첫번쩨 원소좌표 ~ 현재 쿼드트리의 마지막 좌표까지
			for (int j = col; j < col + size; j++) {
				// 색상이 같이 않다면 false를 리턴
				if (quadTree[i][j] != firstNum) {
					return false;
				}
			}
		}
		return true;

	}

}
