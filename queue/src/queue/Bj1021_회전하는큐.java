package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//(2)번 연산 : 왼쪽으로 한 칸 -> 처음 원소 뒤로 보내기
//(3)번 연산 : 오른쪽으로 한 칸 -> 맨 뒤 원소 앞으로 

public class Bj1021_회전하는큐 {

	private static LinkedList<Integer> dq = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}

		int count = 0;

		for (int i = 0; i < M; i++) {

			// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기
			int target_idx = dq.indexOf(arr[i]);
			int half_idx;

			if (dq.size() % 2 == 0) {
				half_idx = dq.size() / 2 - 1;
			} else {
				half_idx = dq.size() / 2;
			}

			// 타겟 원소의 위치 <= 중간 지점
			if (target_idx <= half_idx) {
				// 타겟 원소의 위치보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
				for (int j = 0; j < target_idx; j++) {
					int temp = dq.pollFirst();
					dq.offerLast(temp);
					count++;
				}
			} else { // 타겟 원소의 위치 > 중간지점
				// 타겟 원소를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
				for (int j = 0; j < dq.size() - target_idx; j++) {
					int temp = dq.pollLast();
					dq.offerFirst(temp);
					count++;
				}

			}
			dq.pollFirst(); // 연산이 끝나면 맨 앞 원소를 뽑아내기
		}

		System.out.println(count);

	}
}
