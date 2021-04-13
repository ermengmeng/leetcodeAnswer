import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/13 7:16 下午
 * @Version 1.0
 */
public class CanYouEatYourFavoriteCandyonYourFavoriteDay1744 {
    public static void main(String[] args) {
        CanYouEatYourFavoriteCandyonYourFavoriteDay1744 o = new CanYouEatYourFavoriteCandyonYourFavoriteDay1744();
        System.out.print(Arrays.toString(o.canEat(new int[]{7,4,5,3,8}, new int[][]{new int[]{0,2,2},new int[]{4,2,4},new int[]{2,13,1000000000}})));
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        long[] sum = new long[candiesCount.length];
        for (int i = 1; i< candiesCount.length; i++) {
            sum[i] = sum[i-1] + candiesCount[i-1];
        }
        for (int i = 0 ; i< queries.length; i++) {
            int[] query = queries[i];
            long need = sum[query[0]];
            res[i] = need < (query[1] +1) * 1L * query[2] && need + candiesCount[query[0]] > query[1];
        }
        return res;
    }
}
