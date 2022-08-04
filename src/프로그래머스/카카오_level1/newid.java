package 프로그래머스.카카오_level1;

import java.util.Stack;

public class newid {

    public static void main(String[] args) {
        String new_id="........................";
        String answer="";


        new_id= new_id.toLowerCase();
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<new_id.length();i++){
            char temp=new_id.charAt(i);
            if(temp>='0'&&temp<='9' || temp>='a' && temp<='z' || temp=='-' || temp=='.' || temp=='_') {
                answer+=temp;
            }
        }

        String str=answer;
        answer="";
        for(int i=0;i<str.length();i++){
            char temp=str.charAt(i);
            if(temp=='.'){
                int idx=i+1;
                answer+=temp;
                while(idx<str.length() && str.charAt(idx)=='.'){
                    idx++;
                }
                i=idx-1;
            }else{
                answer+=temp;
            }

        }

            if (answer.length()!=0&&answer.charAt(0) == '.') {
                answer = answer.substring(1);
            }
            if (answer.length()!=0 && answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }


        if(answer.equals("")){
            for(int i=0;i<3;i++){
                answer+="a";
            }
        }

        if(answer.length()>=16){
            answer=answer.substring(0,15);
        }

        if(answer.charAt(answer.length()-1)=='.'){
            answer=answer.substring(0,answer.length()-1);
        }

        if(answer.length()<=2){
            char temp= answer.charAt(answer.length()-1);

            for(int i=answer.length();i<3;i++){
                answer+=temp;
            }
        }
        System.out.println(answer);




    }
}
