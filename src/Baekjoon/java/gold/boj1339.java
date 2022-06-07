package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj1339 {
    public static void main(String[] args) {

        //testcase 및 문자열 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] arr = new String[n];
        int [] alpha = new int[26];
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }


        for(int i=0; i<n; i++){
            int temp = (int)Math.pow(10,arr[i].length()-1);
            for(int j=0; j<arr[i].length(); j++){
                alpha[(int)arr[i].charAt(j)-65]+=temp;
                temp /=10;
            }
        }

        Arrays.sort(alpha);
        int index = 9;
        int sum =0;
        for(int i=alpha.length-1; i>=0; i--){
            if(alpha[i] == 0){
                break;
            }
            sum+= alpha[i]*index;
            index--;
        }
        System.out.println(sum);
    }
//    static String[] nums;
//    static int alphabetCnt,N,answer;
//    static boolean[] checked;
//    static int[] alphabetNum;
//    static List<String> alphabet;
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        nums = new String[N];
//        answer = 0;
//        alphabet = new ArrayList<>();
//        int numLength = 0;
//        for (int i = 0; i < N; i++) {
//            nums[i] = br.readLine();
//            numLength = Math.max(numLength,nums[i].length());
//            for (char n:nums[i].toCharArray()) {
//                String nS = Character.toString(n);
//                if(!alphabet.contains(nS)){
//                    alphabet.add(nS);
//                }
//            }
//        }
//
//        alphabetCnt = alphabet.size();
//        alphabetNum = new int[alphabetCnt];
//        checked = new boolean[alphabetCnt];
//        if(numLength==1){
//            for (int i = 0; i < alphabetCnt; i++) {
//                answer+= 9-i;
//            }
//        }else {
//            dfs(0);
//        }
//        System.out.println(answer);
//    }

//    private static void dfs(int now){
//        if(now==alphabetCnt){
//            int result=0;
//            for (int i = 0; i < N; i++) {
//                String num=nums[i];
//                for (int j = 0; j < alphabetCnt; j++) {
//                    num=num.replaceAll(alphabet.get(j),Integer.toString(alphabetNum[j]));
//                }
//                result += Integer.parseInt(num);
//            }
//            if(answer<result){
//                answer = result;
//            }
//            return;
//        }
//        for (int i = 0; i < alphabetCnt; i++) {
//            if(checked[i]) continue;
//            checked[i] = true;
//            alphabetNum[now] = 9-i;
//            dfs(now+1);
//            checked[i] = false;
//        }
//    }
}
