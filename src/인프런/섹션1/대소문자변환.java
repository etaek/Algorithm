package 인프런.섹션1;

import java.util.Locale;
import java.util.Scanner;

public class 대소문자변환 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.next();
        String answer="";
        for(char x : str.toCharArray()){
            if(x>='a'&&x<='z'){
                answer+=String.valueOf(x).toUpperCase();
            }else{
                answer+=String.valueOf(x).toLowerCase();
            }
        }
        System.out.println(answer);

    }
}
