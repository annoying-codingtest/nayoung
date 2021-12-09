package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1063_킹 {

	private static int kingX;
	private static int kingY;

	private static int stoneX;
	private static int stoneY;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String kingPos = st.nextToken(); //A1 .. H8
		String stonePos = st.nextToken();

		int N = Integer.parseInt(st.nextToken());

		/*
		 좌표모양
		   0  1  2  3  4  5  6  7 
		 0 A8 B8
		 1 A7
		 2 
		 .
		 .
		 
		 */
		
		//킹과 돌의 위치를 위의 좌표에 맞게 바꿈.
		kingX = kingPos.charAt(0) - 'A';
		kingY = 8 - (kingPos.charAt(1) - '0');
		stoneX = stonePos.charAt(0) - 'A';
		stoneY = 8 - (stonePos.charAt(1) - '0');

		for (int i = 0; i < N; i++) {
			String move = br.readLine();
			switch (move) {
			case "R": // 한 칸 오른쪽
				if (kingX < 7) {
					kingX++;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX < 7) {
							stoneX++;
						} else {
							kingX--; // 다시 원래대로
						}
					}
				}
				break;

			case "L": // 한 칸 왼쪽으로
				if (kingX > 0) {
					kingX--;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX > 0) {
							stoneX--;
						} else {
							kingX++; // 원래대로
						}
					}

				}
				break;

			case "B": // 한 칸 아래로
				if (kingY < 7) {
					kingY++;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneY < 7) {
							stoneY++;
						} else {
							kingY--;
						}
					}
				}
				break;

			case "T": // 한 칸 위로
				if (kingY > 0) {
					kingY--;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneY > 0) {
							stoneY--;
						} else {
							kingY++;
						}

					}

				}
				break;

			case "RT": // 오른쪽 위 대각선
				if (kingX < 7 && kingY > 0) {
					kingX++;
					kingY--;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX < 7 && stoneY > 0) {
							stoneX++;
							stoneY--;
						} else {
							kingX--;
							kingY++;
						}
					}
				}

				break;

			case "LT": // 왼쪽 위 대각선
				if (kingX > 0 && kingY > 0) {
					kingX--;
					kingY--;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX > 0 && stoneY > 0) {
							stoneX--;
							stoneY--;
						} else {
							kingX++;
							kingY++;
						}
					}
				}

				break;

			case "RB": // 오른쪽 아래 대각선
				if (kingX < 7 && kingY < 7) {
					kingX++;
					kingY++;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX < 7 && stoneY < 7) {
							stoneX++;
							stoneY++;

						} else {
							kingX--;
							kingY--;
						}
					}
				}

				break;

			case "LB": // 왼쪽 아래 대각선
				if (kingX > 0 && kingY < 7) {
					kingX--;
					kingY++;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX > 0 && stoneY < 7) {
							stoneX--;
							stoneY++;

						} else {
							kingX++;
							kingY--;
						}
					}
				}

				break;

			default:
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		kingPos = "";
		kingPos += (char) (kingX + 65);
		kingPos += Math.abs(kingY - 8);
		
		stonePos = "";
		stonePos += (char) (stoneX + 65);
		stonePos += Math.abs(stoneY - 8);

		sb.append(kingPos+"\n"+stonePos);

		System.out.println(sb);

	}

}
