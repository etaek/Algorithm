package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split("");
        String answer="";
        for(int i=0;i<str.length;i++){
            String s=str[i];
            int cnt=1;
            int idx=i+1;
            while(idx<str.length && str[idx].equals(s)){
                cnt++;
                idx++;
            }
            answer+=s;
            if(cnt!=1){
                answer+=String.valueOf(cnt);
            }
            i=idx-1;

        }
        System.out.println(answer);

    }
}
