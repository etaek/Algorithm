package 프로그래머스.카카오_level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id_list={"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;

        int answer[]=solution(id_list,report,k);
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        HashMap<String,Integer> report_id=new HashMap<>();
        HashMap<String, List<String>> map=new HashMap<>();

        for(String u : id_list){
            map.put(u,new ArrayList<String>());
            report_id.put(u,0);
        }

        for(int i=0;i<report.length;i++){
            String user=report[i].split(" ")[0];
            String user2=report[i].split(" ")[1];
            List<String>list=map.get(user);
            if(!list.contains(user2)){
                list.add(user2);
                map.put(user,list);
                report_id.put(user2,report_id.get(user2)+1);
            }




        }
        answer=new int[map.size()];

        for(int i=0;i< id_list.length;i++){
            int cnt=0;
            List<String>list=map.get(id_list[i]);

            for(int j=0;j<list.size();j++){
                int num= report_id.get(list.get(j));
                if(num>=k){
                    cnt++;
                }
            }
            answer[i]=cnt;
        }


        return answer;
    }
}
