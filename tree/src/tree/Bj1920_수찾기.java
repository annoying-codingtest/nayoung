package tree;
import java.util.*;
import java.io.*;
public class Bj1920_��ã�� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		
		// N���� ���� A[1], A[2], ��, A[N]
		HashMap<Integer, Integer> map = new HashMap<>();
		
		String[] numbers = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			map.put(Integer.parseInt(numbers[i]), map.getOrDefault(Integer.parseInt(numbers[i]), 0) +1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		//M���� ����,�� ������ A�ȿ� �����ϴ��� �˾Ƴ���
		String[] checkingNums = br.readLine().split(" ");

		for (int j=0; j<M; j++) {
			int cn = Integer.parseInt(checkingNums[j]);
			
			if (map.get(cn)== null) {
				System.out.println(0);
			}
			else {
				System.out.println(1);
			}
			
		}
	}

}
