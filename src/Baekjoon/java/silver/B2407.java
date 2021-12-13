package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2407 {
	static int N,M;
	static String[][] C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = new String[N+1][M+1];
		
		System.out.println(combi(N,M));
		
	}
	
	private static String combi(int n, int m) {
		
		if(m*2 > n) m = n-m;
		if(m==0) {
			C[n][m] = "1";
		}else if(m==1) {
			C[n][m] = Integer.toString(n);
		}
		
		if(C[n][m]==null){
			BigInteger n1 = new BigInteger(combi(n-1,m));
			BigInteger n2 = new BigInteger(combi(n-1,m-1));
			BigInteger r = n1.add(n2);
			C[n][m] = r.toString();
		}
		return C[n][m];
	}
	
	
}
