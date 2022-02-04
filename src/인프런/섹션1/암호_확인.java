package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호_확인 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine()) ;
        String str = br.readLine();

        str=str.replace('#','1');
        str=str.replace('*','0');
        char result[]=new char[num];
        String temp="";
        String s="";
        for(int i=0;i<num;i++){
            s=str.substring(0,7);
            int n=Integer.valueOf(s,2);
            result[i]=(char)(n);
            str = str.substring(7);
        }
        String answer=String.valueOf(result);
        System.out.println(answer);
    }
}
