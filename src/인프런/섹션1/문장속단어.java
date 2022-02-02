package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class 문장속단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        String arr[]=str.split(" ");
        int max=0;
        String result="";
        for(String s : arr){
            if(max<s.length()){
                max=s.length();
                result=s;
            }
        }


        System.out.println(result);

    }
}
