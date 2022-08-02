package 프로그래머스.카카오_level1;

public class dartgame {

    public static void main(String[] args) {
        String dartResult="1D2S3T*";
        int[] list=new int[3];

        int result=0;
        int score=0;
        int idx=0;
        for(int i=0;i<dartResult.length();i++){

            if(dartResult.charAt(i)>='0' && dartResult.charAt(i)<='9'){
                if(i!=0){
                    list[idx]=(score);
                    idx++;


                }



                if(dartResult.charAt(i+1) =='0'){
                    score=10;
                    i++;
                    continue;
                }else{

                   score=Integer.parseInt(String.valueOf(dartResult.charAt(i)));
                }
            }
            if(dartResult.charAt(i)=='D'){
                score=(score*score);
            }
            if(dartResult.charAt(i)=='T'){
                score=(score*score*score);
            }
            if(dartResult.charAt(i)=='*'){
                if(idx!=0){
                    list[idx-1]=list[idx-1]*2;
                }
                score=score*2;
            }
            if(dartResult.charAt(i)=='#'){
                score=score*-1;
            }

        }
        list[idx]=score;
        for(int i=0;i<list.length;i++){
           // System.out.println(list[i]);
            result+=list[i];
        }
        System.out.println(result);
    }
}
