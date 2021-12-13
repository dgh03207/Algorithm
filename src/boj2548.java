import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//대표 자연수
public class boj2548 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int line[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(line);
		
		
		if(N%2==0) { //짝수일때
			System.out.println(line[N/2-1]);
		}else {
			System.out.println(line[N/2]);
		}
		
		
		
	}
}
