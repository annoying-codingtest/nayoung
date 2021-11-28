package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Bj2980_도로와신호등 {
	// 빨간불 처음 켜지고 다시 돌아오려면 빨간불 유지시간 + 초록불 유지시간

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 신호등의 개수
		int L = Integer.parseInt(st.nextToken()); // 도로의 길이

		D[] d = new D[L + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dis = Integer.parseInt(st.nextToken());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());

			d[dis] = new D(red, green);

		}

		int T = 0;
		int pos = 0;
		while (pos < L) {
			++T;
			++pos;

			if (d[pos] != null) { // 신호등이 있으면
				int cycle = T % (d[pos].red + d[pos].green);
				if (cycle <= d[pos].red) {
					T = T + (d[pos].red - cycle);
				}
			}

		}
		
		/*
		  int time = 0; // 이동 소요 시간. 
		  for (int i = 0; i < L; ++i) { 
			  ++time; // 신호등 없는 곳 지날 때 1초씩 증가
		  
		  if (d[i] != null) { 
			  // 신호등이 있으면 
			  int cycle = time % (d[i].red + d[i].green); 
			  if
		  (cycle <= d[i].red) { time = time + (d[i].red - cycle); } }
		  
		  }
		  
		  */

	System.out.println(T);

}

}

class D {
	int red;
	int green;

	D(int red, int green) {
		this.red = red;
		this.green = green;
	}
}
