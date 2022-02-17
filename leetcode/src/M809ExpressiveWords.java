/**
 * @Author: ouyangyameng
 * @Date: 2021/5/8 1:36 下午
 * @Version 1.0
 */
public class M809ExpressiveWords {
    public static void main(String[] args) {
        M809ExpressiveWords o = new M809ExpressiveWords();
        System.out.println(o.expressiveWords("dddiiiinnssssssoooo", new String[]{"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"}));
    }
    public int expressiveWords(String S, String[] words) {
        int count=0;
        for(String word: words){
            if(isExpressive(S, word)){
                count++;
            }
        }
        return count;
    }

    private boolean isExpressive(String S, String w){
        int p1=0, p2=0;
        while(p1<S.length() && p2<w.length()){
            //if char not match then not expressive
            if(S.charAt(p1)!=w.charAt(p2)){
                return false;
            }
            int c1=0;
            int ch1 = S.charAt(p1);
            //count no of char in S
            while(p1<S.length() && S.charAt(p1)==ch1){
                c1++;
                p1++;
            }
            int c2=0;
            int ch2 = w.charAt(p2);
            //count no of char in w
            while(p2<w.length() && w.charAt(p2)==ch2){
                c2++;
                p2++;
            }

            //if S char count is lesser than w OR less than 3, then its not expressive
            if(c1<c2 || (c1>c2 && c1<3)){
                return false;
            }
        }
        if(p1!=S.length() || p2!=w.length()){
            return false;
        }
        return true;
    }
}
