public class 단어변환 {

    public static void main(String[] args) {
        String begin="hit";
        String target="cog";
        String[] words={"hot", "dot", "dog", "lot", "log", "cog"};

        int answer= solution(begin,target,words);
        System.out.println(answer);
    }
    static boolean check[];
    static int answer = 100;
    public static int solution(String begin, String target, String[] words) {

        check = new boolean[words.length];

        dfs(begin,target,words,0);

        return answer==100?0:answer;
    }

    public static void dfs(String begin,String target,String[] words,int cnt){
        if(begin.equals(target)){
            if(answer>cnt){
                answer=cnt;
            }
        }

        for(int i=0;i<words.length;i++){
            if(check[i]) continue;
            if(checkWord(begin,words[i])){
                check[i]=true;
                dfs(words[i],target,words,cnt+1);
                check[i]=false;
            }
        }
    }
    public static boolean checkWord(String s1,String s2){
        boolean result=true;
        int cnt=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                cnt++;
            }
            if(cnt>1){
                result=false;
                break;
            }
        }

        return result;
    }
}
