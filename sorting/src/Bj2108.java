import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//�����
//������ Ȱ���ϴ� ����
public class Bj2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		// 1. ������
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		double aver = (double) sum / array.length;
		System.out.println(Math.round(aver));

		// 2. �߾Ӱ�
		int midNum;
		midNum = array[(0 + N - 1) / 2];
		System.out.println(midNum);

		// 3. �ֺ�
		int mode = 0;

		Map<Integer, Integer> mp = new HashMap<>();

		if (N == 1) { // ���Ұ� �ϳ��� ���
			mode = array[0];
		}
		for (int i = 0; i < N; i++) {
			if (mp.containsKey(array[i])) {
				mp.put(array[i], mp.get(array[i]) + 1);
			} else {
				mp.put(array[i], 1);
			}
		}

		int maxValue = Collections.max(mp.values()); // ���� ū �󵵼� ���ϱ�
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
			if (m.getValue() == maxValue) { //������ �� ���� ����ū�󵵼��� ���ٸ� �ش� ���� arrayList�� �߰�.
				arrayList.add(m.getKey());
			}
		}

		Collections.sort(arrayList);

		// �ֺ��� ���� ���� ��� �ι�°�� ���� ��
		if (arrayList.size() > 1)
			mode = arrayList.get(1);
		else // �ֺ��� �ϳ��� ���
			mode = arrayList.get(0);

		System.out.println(mode);

		// 4. ����
		int range = array[N - 1] - array[0];
		System.out.println(range);

	}

}
