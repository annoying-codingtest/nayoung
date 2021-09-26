

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// �� �����ϱ�2
// Arrays.sort() �����Լ� �̿��ϱ�.
public class Bj2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // ����

		int n = Integer.parseInt(br.readLine());

		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(array);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < n; i++) {
			bw.write(array[i] + "\n");
		}

		bw.flush(); 
		bw.close();
		
	}

}
