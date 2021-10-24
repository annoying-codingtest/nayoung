package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < tc; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 수
			int x = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서

			int ans = 0;
			st = new StringTokenizer(br.readLine()); // 문서의 중요도

			LinkedList<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < N; i++)
				q.add(Integer.parseInt(st.nextToken())); // 큐에 문서의 중요도 추가

			while (!q.isEmpty()) {

				boolean flag = true; // 현재 문서보다 중요도가 높은 문서가 있는지 체크
				for (int i = 1; i < q.size(); i++) {
					if (q.peek() < q.get(i)) { // 현재 문서보다 중요도가 높을경우
						flag = false;
						break;
					}
				}

				// 문서내 현재 문서보다 중요도가 높은게 없는경우
				if (flag) {
					ans++; // 현재 목록 인쇄 +1
					q.poll(); // 현재 목록 인쇄해서 제거하기
					if (x == 0) {
						sb.append(ans + "\n");
						break; // 현재 인쇄하려는 문서가 궁금한 문서인경우

					} else
						x--; // 현재 인쇄하려는 문서가 궁금한 문서가 아닌경우

				}

				// 문서내 현재 문서보다 중요도가 높은게 있는경우 -> 현재 문서 가장 뒤로 이동
				else {
					// 현재 목록 제거 후 마지막에 넣기
					int temp = q.poll();
					q.add(temp);

					/*
					 * 현재 문서가 궁금한 문서인경우 -> 가장 뒤로 이동하므로 Queue의 사이즈-1로 인덱스 지정 궁금하지 않은 문서인경우 -> 인덱스 -1
					 */
					if (x == 0)
						x = q.size() - 1;
					else
						x -= 1;

				}
			}
		}
		
		System.out.println(sb);

	}

}
