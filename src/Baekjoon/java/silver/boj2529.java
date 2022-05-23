package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj2529 {
    static long min,max;
    static String minString,maxString;
    static int N;
    static String[] brackets;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        brackets = new String[N];
        boolean[] checked = new boolean[10];
        min = 9999999999l;
        max = 0;
        for (int i = 0; i < N; i++) {
            brackets[i] = st.nextToken();
        }
        String[] nums = new String[N+1];
        dfs(0,checked,nums);
        StringBuilder sb = new StringBuilder();
        sb.append(maxString+"\n");
        sb.append(minString);

        System.out.println(sb.toString());
    }

    public static void dfs(int idx,boolean[] checked,String[] nums){
        if (idx==N+1){
            String numString = String.join("",nums);
            long result = Long.parseLong(numString);
            if(min>result){
                min = result;
                minString = numString;
            }
            if(max<result) {
                max = result;
                maxString = numString;
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if(checked[i]) continue;
            //가장 첫번째 요소일때는 비교할 것이 없으므로,
            if(idx==0){
                nums[idx] = Integer.toString(i);
            }else{
                int prev = Integer.parseInt(nums[idx-1]);
                //prev보다 더 값이 큰 경우만 가능
                if(brackets[idx-1].equals("<")){
                    if(prev>=i) continue;
                }else if(brackets[idx-1].equals(">")){
                    if(prev<=i) continue;
                }
                nums[idx] = Integer.toString(i);
            }

            checked[i] = true;
            dfs(idx+1,checked,nums);
            checked[i] = false;
        }
    }
}
