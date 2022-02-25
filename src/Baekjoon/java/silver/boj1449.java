package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수리공 항승
public class boj1449 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean[] pipes = new boolean[1000+1];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pipes[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i < 1000+1; i++) {
            if(pipes[i]){
                for (int j = 0; j < L; j++) {
                    if(i+j<1001) {
                        pipes[i + j] = false;
                    }
                }
                answer +=1;
            }
        }

        System.out.println(answer);


    }

}
