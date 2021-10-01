

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 수 정렬하기3
// counting sort 시간초과됨. Arrays.sort쓰면 됨.
public class Bj10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정렬할 원소 개수
		int N = Integer.parseInt(br.readLine());

		// 정렬할 배열
		int[] array = new int[N];

		int maxNum = 0;

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
			if (maxNum < array[i])
				maxNum = array[i];
		}
		// counting 배열 선언 및 초기화
		int[] counting = new int[maxNum + 1];
		for (int i = 0; i < counting.length; i++) {
			counting[i] = 0;
		} // Arrays.fill(counting, 0);

		// 1단계 ) counting 배열에 각 원소의 개수 입력.
		for (int i = 0; i < array.length; i++) {
			counting[array[i]] += 1;
		}

		// 2단계 )counting 배열 누적합으로 변경
		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i - 1];
		}

		int[] result = new int[N];
		Arrays.fill(result, 0);
		for (int i = array.length - 1; i >= 0; i--) {

			// 3단계 ) array배열의 i 번쨰 원소(value)를 인덱스로 하는 counting 배열의 값을 -1한 뒤 
			// counting 배열의 값을 인덱스로 하여 result배열에 value값 저장.
			int value = array[i];
			counting[value]--;
			result[counting[value]] = value;

		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < result.length; i++) {
			bw.write(result[i] + "\n");
		}

		bw.flush();
		bw.close();

	}

}
