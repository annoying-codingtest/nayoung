package implementaion;

import java.util.*;
import java.io.*;

public class Bj1748_수이어쓰기1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int count=0;
		int num=1;
		int tens = 10;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=N; i++) {
			if (i / tens != 0) {
				num++;
				tens *= 10;
			}
			count+=num;
		}
		
		System.out.println(count);
		br.close();
	}
}
