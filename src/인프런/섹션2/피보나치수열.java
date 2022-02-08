package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수열 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int arr[]=new int[num+1];
        arr[0]=1;
        arr[1]=1;

        for(int i=2;i<=num;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }

        for(int i=0;i<num;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
