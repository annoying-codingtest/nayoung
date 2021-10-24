package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2164_카드2 {

	private static Queue<Integer> queue = new LinkedList<>();
	private static int lastNum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		lastNum = 0;

		for (int i = 1; i <= N; i++) {
			lastNum = i; //마지막 push되는 값을 저장 (rear값)
			push(i);
		}

		int frontNum = 0;
		while (true) {

			if (queue.size() == 1) { //카드가 한 장이 되면 종료
				break;
			}
			queue.poll();
			frontNum = queue.poll(); //첫 번째 카드 없애고 그 다음 첫번째 카드 저장.

			lastNum = frontNum; // rear값을 바꿔주고 큐에 push
			push(frontNum);
		}

		System.out.println(lastNum);

	}

	static void push(int n) {
		queue.offer(n);
	}
}
