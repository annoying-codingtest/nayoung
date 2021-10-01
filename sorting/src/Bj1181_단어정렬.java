
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//단어 정렬
public class Bj1181_단어정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// N개의 단어 리스트 받기
		ArrayList<String> wordList = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			wordList.add(br.readLine());
		}

		// 정렬할 단어 리스트 만들기
		ArrayList<String> sortingList = new ArrayList<String>();

		for (int i = 0; i < wordList.size(); i++) {
			if (!sortingList.contains(wordList.get(i))) {
				sortingList.add(wordList.get(i));
			}
		}

		// 정렬 조건에 맞춰 정렬시키기

		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.length() > o2.length())
					return 1;
				else if (o1.length() < o2.length())
					return -1;
				else
					return o1.compareTo(o2);
			}
		};

		Collections.sort(sortingList, comp);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < sortingList.size(); i++) {
			sb.append(sortingList.get(i) + "\n");
		}

		System.out.println(sb);

	}
}
