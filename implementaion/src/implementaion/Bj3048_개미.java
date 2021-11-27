package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj3048_개미 {

	private static int N1;
	private static int N2;
	private static int T;

	private static ArrayList<Ant> ants = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N1 = Integer.parseInt(st.nextToken());
		N2 = Integer.parseInt(st.nextToken());

		String s = br.readLine();

		//전진방향이 --> 첫 번째 개미 집단 입력
		for (int i = N1 - 1; i >= 0; i--) { 
			Ant ant = new Ant(s.charAt(i), 'R');
			ants.add(ant);
		}

		s = br.readLine();

		//전진방향이 <-- 두 번째 개미 집단 입력
		for (int i = 0; i < N2; i++) { 
			Ant ant = new Ant(s.charAt(i), 'L');
			ants.add(ant);
		}

		T = Integer.parseInt(br.readLine());

		//T초 뒤 개미들의 순서
		while (T > 0) {
			jump();
			T--;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ants.size(); i++) {
			sb.append(ants.get(i).ant);
		}

		System.out.println(sb);

	}

	public static void jump() {

		Ant pre;
		Ant next;
		for (int i = 0; i < ants.size() - 1; i++) {
			pre = ants.get(i);
			next = ants.get(i + 1);
			if (pre.seq=='R' && pre.seq != next.seq) { //전진방향이 LR인 경우 (<-- -->) 자기 앞에 개미가 있는 게 아니라서 바꿀 필요 없음
				Ant temp = pre;

				ants.set(i, next);
				ants.set(i + 1, temp);

				i++; // 1초에는 한 번씩만 위치 바꿀 수 있기에(서로 점프) 현재 인덱스 + 1
			}
		}
	}

}

class Ant {
	char ant;
	char seq;

	Ant(char ant, char seq) {
		this.ant = ant;
		this.seq = seq;
	}

}
