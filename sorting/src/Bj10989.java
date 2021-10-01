

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// �� �����ϱ�3
// counting sort �ð��ʰ���. Arrays.sort���� ��.
public class Bj10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ������ ���� ����
		int N = Integer.parseInt(br.readLine());

		// ������ �迭
		int[] array = new int[N];

		int maxNum = 0;

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
			if (maxNum < array[i])
				maxNum = array[i];
		}
		// counting �迭 ���� �� �ʱ�ȭ
		int[] counting = new int[maxNum + 1];
		for (int i = 0; i < counting.length; i++) {
			counting[i] = 0;
		} // Arrays.fill(counting, 0);

		// 1�ܰ� ) counting �迭�� �� ������ ���� �Է�.
		for (int i = 0; i < array.length; i++) {
			counting[array[i]] += 1;
		}

		// 2�ܰ� )counting �迭 ���������� ����
		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i - 1];
		}

		int[] result = new int[N];
		Arrays.fill(result, 0);
		for (int i = array.length - 1; i >= 0; i--) {

			// 3�ܰ� ) array�迭�� i ���� ����(value)�� �ε����� �ϴ� counting �迭�� ���� -1�� �� 
			// counting �迭�� ���� �ε����� �Ͽ� result�迭�� value�� ����.
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
