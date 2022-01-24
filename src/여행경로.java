import java.util.*;

public class 여행경로 {

    public static void main(String[] args) {
        String [][]tickets={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String []answer=solution(tickets);

        for(String s : answer){
            System.out.print(s+" ");
        }
    }

    static boolean check[];
    static ArrayList<String> list=new ArrayList<>();
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        check=new boolean[tickets.length];

        dfs(tickets,0,"ICN","ICN");
        Collections.sort(list);
        answer=list.get(0).split(",");

        return answer;
    }
    public static void dfs(String [][]tickets,int cnt,String start,String result){
        if(cnt==tickets.length){
            list.add(result);
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(check[i])continue;

            if(tickets[i][0].equals(start)){
                check[i]=true;
                dfs(tickets,cnt+1,tickets[i][1],result+","+tickets[i][1]);
                check[i]=false;
            }
        }
    }

}
