package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class 유요한팰린드롬_확인 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str=str.toUpperCase().replaceAll("[^A-Z]","");

        String tmp=new StringBuilder(str).reverse().toString();
        String answer="NO";
        if(str.equals(tmp)){
            answer="YES";
        }
        System.out.println(answer);
    }
}
