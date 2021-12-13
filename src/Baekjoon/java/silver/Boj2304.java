package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

//창고다각형
public class Boj2304 {
	
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		Map<Integer,Integer>pillar = new TreeMap<>();
		
		
		int max = 0;
		int max_point = 0;
		int[] keys = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			keys[i] = L;
			int H = Integer.parseInt(st.nextToken());
			if(max<=H) {
				max = H;
				max_point = L;
			}
			pillar.put(L, H);
		}
		Arrays.sort(keys);
		
		int result = 0;
		int prev = pillar.get(keys[0]);
		int prev_key = keys[0];
		int i = 0;
		boolean flag = true;
		
		if(keys.length==1) result = max;
		else if(keys.length>1) {
			while(true) {
				int now = pillar.get(keys[i]);
				if(prev<=now) {
					result += Math.abs(keys[i]-prev_key)*prev;
					prev_key=keys[i];
					prev = now;
				}
	
				if(keys[i]==max_point) {
					if(flag==false) break;
					else {
						result+= Math.abs(keys[i]-prev_key)*prev;
						result+= max;
						
						if(i==N-1) break;
						else {
							flag = false;
							i = N-1;
							prev_key = keys[i];
							prev = pillar.get(prev_key);
						}
					}
				}
				
				if(flag) i++;
				else i--;
			}
		}
		System.out.println(result);
	}

}
