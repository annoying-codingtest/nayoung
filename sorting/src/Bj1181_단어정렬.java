
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//�ܾ� ����
public class Bj1181_�ܾ����� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// N���� �ܾ� ����Ʈ �ޱ�
		ArrayList<String> wordList = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			wordList.add(br.readLine());
		}

		// ������ �ܾ� ����Ʈ �����
		ArrayList<String> sortingList = new ArrayList<String>();

		for (int i = 0; i < wordList.size(); i++) {
			if (!sortingList.contains(wordList.get(i))) {
				sortingList.add(wordList.get(i));
			}
		}

		// ���� ���ǿ� ���� ���Ľ�Ű��

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
