package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에라토스테네스체 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int arr[]=new int[num+1];

        for (int i=2;i<=num;i++){
            arr[i]=i;
        }

        for(int i=2;i<=num;i++){
            if(arr[i]==0) continue;

            for(int j=i*2;j<=num;j+=i){
                arr[j]=0;
            }
        }
        int cnt=0;
        for(int i=2;i<=num;i++){
            if(arr[i]!=0){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
