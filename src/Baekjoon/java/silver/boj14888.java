package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//연산자 끼워넣기
public class boj14888 {
	static int answer,N,nums[],operators[],answer2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums  = new int[N];
		operators = new int[4];
		answer = Integer.MIN_VALUE;
		answer2 = Integer.MAX_VALUE;
// 		+,-,x,/순서
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i]=(Integer.parseInt(st.nextToken()));
		}
		getResult(nums[0],1);
		sb.append(answer+"\n");
		sb.append(answer2);

		System.out.println(sb.toString());
	}

	public static void getResult(int result,int index){
		if(index==N){
			if(answer < result){
				answer = result;
			}
			if(answer2 > result){
				answer2 = result;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int next = result;
			if(operators[i]>0) {
				if (i == 0) {
					next += nums[index];
				} else if (i == 1) {
					next -= nums[index];
				} else if (i == 2) {
					next *= nums[index];
				} else if (i == 3) {
					if (next < 0) {
						next = -1 * (Math.abs(next) / nums[index]);
					} else {
						next /= nums[index];
					}
				}
				operators[i]-=1;
				getResult(next, index + 1);
				operators[i]+=1;
			}
		}
	}
	
}
