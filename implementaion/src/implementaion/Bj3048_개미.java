package implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj3048_���� {

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

		//���������� --> ù ��° ���� ���� �Է�
		for (int i = N1 - 1; i >= 0; i--) { 
			Ant ant = new Ant(s.charAt(i), 'R');
			ants.add(ant);
		}

		s = br.readLine();

		//���������� <-- �� ��° ���� ���� �Է�
		for (int i = 0; i < N2; i++) { 
			Ant ant = new Ant(s.charAt(i), 'L');
			ants.add(ant);
		}

		T = Integer.parseInt(br.readLine());

		//T�� �� ���̵��� ����
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
			if (pre.seq=='R' && pre.seq != next.seq) { //���������� LR�� ��� (<-- -->) �ڱ� �տ� ���̰� �ִ� �� �ƴ϶� �ٲ� �ʿ� ����
				Ant temp = pre;

				ants.set(i, next);
				ants.set(i + 1, temp);

				i++; // 1�ʿ��� �� ������ ��ġ �ٲ� �� �ֱ⿡(���� ����) ���� �ε��� + 1
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
