package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1476_날짜계산 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e, s, m;
		e = 1;
		s = 1;
		m = 1;
		int year = 1;

		while (true) {
			e++;
			s++;
			m++;
			year++;
			
			if (E == e && S == s && M == m) {
				break;
			}

			if (e > 15) {
				e = 1;
			}
			if (s > 28) {
				s = 1;
			}
			if (m > 19) {
				m = 1;
			}

	
		}

		System.out.println(year);

	}

}
