package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10798_세로읽기 {

	private static char[][] words;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		words = new char[5][15];

		int longword = 0; // 5개의 단어들 중 가장 긴 단어의 길이
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();

			for (int k = 0; k < s.length(); k++) {
				words[i][k] = s.charAt(k);
			}

			if (s.length() > longword) {
				longword = s.length();
			}

		}

		wordprint(longword);

		System.out.println(sb);

	}

	public static void wordprint(int longword) {

		char c;
		for (int i = 0; i < longword; i++) {
			for (int k = 0; k < 5; k++) {
				c = words[k][i];
				if (c != '\0') { // 해당 위치가 널이 아니면 출력
					sb.append(c);
				} else { // 널이면 통과
					continue;
				}
			}

		}

	}

}
