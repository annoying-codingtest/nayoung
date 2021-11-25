package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2490_¿∑≥Ó¿Ã {

	private static int[][] check;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		check = new int[3][4];
		int checkZero = 0;
		StringTokenizer st;

		for (int i = 0; i < 3; i++) {
			checkZero = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				check[i][j] = Integer.parseInt(st.nextToken());
				if (check[i][j] == 0) {
					checkZero++;
				}
			}
			play(checkZero);
		}
		
		System.out.println(sb);

	}

	public static void play(int i) {
		switch (i) {

		case 1:
			sb.append("A" + "\n");
			break;

		case 2:
			sb.append("B" + "\n");
			break;

		case 3:
			sb.append("C" + "\n");
			break;

		case 4:
			sb.append("D" + "\n");
			break;

		case 0:
			sb.append("E" + "\n");
			break;
		}

	}

}
