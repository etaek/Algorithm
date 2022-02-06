package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큰수출력하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");

        for(int i=0;i<str.length;i++){
            int n=Integer.parseInt(str[i]);
            if(i==0){
                System.out.print(n+" ");
                continue;
            }
            int n1=Integer.parseInt(str[i-1]);
            if(n>n1){
                System.out.print(n+" ");
            }
        }
    }

}
