import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//소트인사이드
//숫자를 정렬하는 문제
public class Bj1427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();

		int[] array = new int[N.length()];

		for (int i = 0; i < array.length; i++) {
			array[i] = N.charAt(i);
		}

		Arrays.sort(array);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = array.length - 1; i >= 0; i--) {
			bw.write(array[i]);
		}

		bw.flush();
		bw.close();
	}

}
