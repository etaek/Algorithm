package baekjoon.DFS;

import java.util.HashMap;

public class 숫자문자열단어 {

    public static void main(String[] args) {
        String s="123";

        int num=solution(s);
        System.out.println(num);

    }

    public static int solution(String s) {
        int answer = 0;
        String result="";
        HashMap<String,Integer> map =new HashMap<>();
        map.put("zero",0);map.put("one",1);
        map.put("two",2);map.put("three",3);
        map.put("four",4);map.put("five",5);
        map.put("six",6);map.put("seven",7);
        map.put("eight",8);map.put("nine",9);

        String str="";
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);

            if(temp>='0' && temp<='9'){
                result+=String.valueOf(temp);
            }else{
                str+=String.valueOf(temp);
            }

            if(map.containsKey(str)){
                result+=String.valueOf(map.get(str));
                str="";
            }
        }
        answer=Integer.parseInt(result);
        return answer;
    }
}
