import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//통계학
//정렬을 활용하는 문제
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

		// 1. 산술평균
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		double aver = (double) sum / array.length;
		System.out.println(Math.round(aver));

		// 2. 중앙값
		int midNum;
		midNum = array[(0 + N - 1) / 2];
		System.out.println(midNum);

		// 3. 최빈값
		int mode = 0;

		Map<Integer, Integer> mp = new HashMap<>();

		if (N == 1) { // 원소가 하나인 경우
			mode = array[0];
		}
		for (int i = 0; i < N; i++) {
			if (mp.containsKey(array[i])) {
				mp.put(array[i], mp.get(array[i]) + 1);
			} else {
				mp.put(array[i], 1);
			}
		}

		int maxValue = Collections.max(mp.values()); // 가장 큰 빈도수 구하기
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
			if (m.getValue() == maxValue) { //원소의 빈도 수가 가장큰빈도수와 같다면 해당 원소 arrayList에 추가.
				arrayList.add(m.getKey());
			}
		}

		Collections.sort(arrayList);

		// 최빈값이 여러 개일 경우 두번째로 작은 값
		if (arrayList.size() > 1)
			mode = arrayList.get(1);
		else // 최빈값이 하나일 경우
			mode = arrayList.get(0);

		System.out.println(mode);

		// 4. 범위
		int range = array[N - 1] - array[0];
		System.out.println(range);

	}

}
