package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집은소수 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String arr[]=br.readLine().split(" ");

        for(int i=0;i<arr.length;i++){
            StringBuffer sb=new StringBuffer(arr[i]);
            int n=Integer.parseInt(sb.reverse().toString());
            if(check(n)){
                System.out.print(n+" ");
            }

        }
    }

    public static boolean check(int n){
        boolean answer=true;
        if(n==1){
            answer=false;
        }
        else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
