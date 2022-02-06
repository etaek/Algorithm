package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 보이는학생 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int cnt=1;
        int max=Integer.parseInt(str[0]);
        for(int i=1;i<str.length;i++){
            int n=Integer.parseInt(str[i]);
            if(max<n){
                max=n;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
