package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시험감독 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        String arr[]=br.readLine().split(" ");

        String arr2[]=br.readLine().split(" ");

        int b= Integer.parseInt(arr2[0]);
        int c=Integer.parseInt(arr2[1]);

        int num[]=new int[n];
        for(int i=0;i<arr.length;i++){
            num[i]=Integer.parseInt(arr[i]);

            num[i]=num[i]-b;
        }

        long answer=n;
        for(int i=0;i<n;i++){
            if(num[i]<=0) continue;

            if(num[i]/c ==0 ){
                answer++;
            }else{
                answer+=(num[i]/c);

                if(num[i]%c!=0) {
                    answer++;
                }
            }

        }
        System.out.println(answer);

    }
}
