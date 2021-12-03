package implementaion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Bj8979_�ø��� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] medals = new int[N + 1][3];


		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int country = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 3; j++) {
				medals[country][j] = 3 * Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(getPrize(medals, N, K));

	}

	public static int getPrize(int[][] medals, int N, int k) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (i == k) // �񱳰��� k�����϶��� �н�
				continue;
			else {
				if (medals[k][0] < medals[i][0]) { // k���󺸴� �ݸ޴��� ���� ���� i count
					count++;
					continue;
				} else if (medals[k][0] == medals[i][0]) { // k����� �ݸ޴��� ���� ����.
					if (medals[k][1] < medals[i][1]) { // k���󺸴� ���޴��� ���� ���� i count
						count++;
						continue;
					} else if (medals[k][1] == medals[i][1]) {// k����� ���޴��� ���� ����.
						if (medals[k][2] < medals[i][2]) {// k���󺸴� ���޴��� ���� ���� i count
							count++;
						}
					}

				}
			}

		}

		return count + 1;
	}

}
