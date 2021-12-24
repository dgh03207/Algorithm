package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//연산자 끼워넣기
public class boj14888 {
	static int N = 0;
	static boolean selected[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		selected = new boolean[N-1];
		int[] nums = new int[N];
		int[] operators = new int[4];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		int Max = nums[N-1];
		int Min = nums[N-1];
		
		//max
		int answer = operators[N-1];
	
		System.out.println(Max);
		
		
		combi(0,0);
	}
	
	private static void combi(int n,int start) {
		
		
	}
}
