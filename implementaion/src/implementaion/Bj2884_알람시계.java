package implementaion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Bj2884_알람시계 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		alarm(H, M);

		System.out.println(sb);

	}

	public static void alarm(int H, int M) {
		if (H > 0) {
			if (M >= 45) {
				M = M - 45;
			} else {
				H = H - 1;
				M = M + 60 - 45;
			}
		} else if (H == 0) {
			if (M >= 45) {
				M = M - 45;
			} else {
				H = 23;
				M = M + 60 - 45;
			}
		}

		sb.append(H + " " + M);
	}

}
