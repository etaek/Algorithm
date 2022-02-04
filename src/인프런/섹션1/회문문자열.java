package 인프런.섹션1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class 회문문자열 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        str=str.toUpperCase();
        String tmp=new StringBuilder(str).reverse().toString();

        String result="NO";

        if(str.equals(tmp)){
            result="YES";
        }
//        char arr[]=str.toCharArray();
//        int lt=0;
//        int rt=arr.length-1;
//        String result="YES";
//        while(lt<rt){
//            if(arr[lt]!=arr[rt]){
//                result="NO";
//                break;
//            }
//            lt++;rt--;
//        }
        System.out.println(result);

    }
}
