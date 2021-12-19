
import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        String s="{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int result[]=solution(s);

        for(int i: result){
            System.out.print(i+" ");
        }
    }
    public static int[]solution(String s){
        int[] answer;

        Map<String,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            String str="";
            char temp=s.charAt(i);
            if(temp=='}'||temp=='{'||temp==',') continue;
            str=String.valueOf(temp);
            if(i+1<s.length()) {
                while (s.charAt(i + 1) != '}' && s.charAt(i + 1) != ',') {
                    str += String.valueOf(s.charAt(i + 1));
                    i++;
                }
            }
            map.put(str,map.getOrDefault(str,0)+1);
        }

        List<Map.Entry<String,Integer>>list=new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
           @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer>o2){
               return o2.getValue().compareTo(o1.getValue());
           }

        });
        answer=new int[list.size()];
        int idx=0;
        for(Map.Entry<String,Integer> m : list){
            answer[idx++]=Integer.valueOf(m.getKey());
        }

        return answer;
    }
}
