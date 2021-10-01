import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj10814_나이순정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 나이와 이름을 저장할 2차원 배열 생성
		String[][] users = new String[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			users[i][0] = st.nextToken();
			users[i][1] = st.nextToken();
		}

		// 정렬 조건 만들기(나이순)
		Comparator<String[]> comparator = new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
			}

		};

		// 만든 조건으로 정렬 후 출력
		Arrays.sort(users, comparator);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(users[i][0] + " " + users[i][1] + "\n");
		}

		System.out.println(sb);
	}

}
