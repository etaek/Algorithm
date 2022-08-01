package 프로그래머스.카카오_level1;

import java.util.HashMap;

public class numEnglish {

    public static void main(String[] args) {
        String s="123";

        String answer="";
        String temp="";
        HashMap<String,String> map=new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                answer+=String.valueOf(s.charAt(i));
            }else{
                int idx=i+1;
                temp+=String.valueOf(s.charAt(i));
                while(idx<s.length() && (s.charAt(idx)<'0' || s.charAt(idx)>'9')){
                    temp+=    String.valueOf(s.charAt(idx));
                    idx++;
                    if(map.containsKey(temp)){
                        break;
                    }
                }

                answer+=map.get(temp);
                i=idx-1;
                temp="";
            }

        }


    }


}
