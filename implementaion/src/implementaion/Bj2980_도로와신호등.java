package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Bj2980_���οͽ�ȣ�� {
	// ������ ó�� ������ �ٽ� ���ƿ����� ������ �����ð� + �ʷϺ� �����ð�

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // ��ȣ���� ����
		int L = Integer.parseInt(st.nextToken()); // ������ ����

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

			if (d[pos] != null) { // ��ȣ���� ������
				int cycle = T % (d[pos].red + d[pos].green);
				if (cycle <= d[pos].red) {
					T = T + (d[pos].red - cycle);
				}
			}

		}
		
		/*
		  int time = 0; // �̵� �ҿ� �ð�. 
		  for (int i = 0; i < L; ++i) { 
			  ++time; // ��ȣ�� ���� �� ���� �� 1�ʾ� ����
		  
		  if (d[i] != null) { 
			  // ��ȣ���� ������ 
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
