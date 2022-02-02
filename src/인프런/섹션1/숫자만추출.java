package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만추출 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str=str.replaceAll("[^0-9]","");

        if(str.charAt(0)=='0'){
            str=str.substring(1);
        }
        System.out.println(Integer.parseInt(str));
    }
}
