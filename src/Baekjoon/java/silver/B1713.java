package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class B1713 {
	
	static class Student implements Comparable<Student>{

		int num;
		int cnt;
		int time;
	
		public Student(int num, int cnt, int time) {
			this.num = num;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Student o) {
			if(this.cnt == o.cnt) return this.time-o.time; 
			return this.cnt-o.cnt;
		}
	}
	
	static int N,M;
	static int[] students;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		students = new int[101];
		ArrayList<Student> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int st_cnt = 0;
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(students[n]>0) {
				students[n]+=1;
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).num==n) {
						list.get(j).cnt+=1;
						break;
					}
				}
			}else {
				if(list.size()>=N) {
					Collections.sort(list);
					students[list.get(0).num]=0;
					list.remove(0);
				
				}
				list.add(new Student(n,1,i));
				students[n]+=1;
			}
			
		}
		
		for (int i = 0; i < 101; i++) {
			if(students[i] !=0) System.out.print(i+" ");
		}
		
	}
	
}
