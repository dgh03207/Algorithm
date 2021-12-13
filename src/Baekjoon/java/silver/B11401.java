package Baekjoon.java.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이항 계수3
public class B11401 {
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		System.out.println(combi(N,M,1000000007));
	}
	
	static long combi(int n, int r, int p) {
		if (r==0) return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			fac[i] = fac[i-1] * i%p;
		}
		
		return(fac[n]*power(fac[r],p-2,p)%p*power(fac[n-r],p-2,p)%p)%p;
	}
	
	static long power(long x, long y, long p) {
        long res = 1L;
        
        while(y > 0) {
            if(y % 2 == 1) 
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p; 
        }
        return res;
    }
}
