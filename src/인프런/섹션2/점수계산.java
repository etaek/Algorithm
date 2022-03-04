package 인프런.섹션2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 점수계산 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String str[]=br.readLine().split(" ");

        int answer=0;
        for(int i=0;i<num;i++){
            int n=Integer.parseInt(str[i]);
            int cnt=1;
            while(n==1){
                answer+=cnt;
                i=i+1;
                if(i>=num) break;

                n=Integer.parseInt(str[i]);
                cnt++;
            }
        }
        System.out.println(answer);
    }
}
