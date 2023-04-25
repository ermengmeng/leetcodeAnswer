/**
 * @Author: ouyangyameng
 * @Date: 2023/2/3 14:33
 * @Version 1.0
 */
public class H72EditDistance {
    public static void main(String[] args) {
        System.out.println(new H72EditDistance().minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        distance[0][0] = 0;
        for (int i = 1; i < distance.length; i++) {
            distance[i][0] = distance[i - 1][0] + 1;
        }
        for (int i = 1; i < distance[0].length; i++) {
            distance[0][i] = distance[0][i - 1] + 1;
        }
        for (int i = 1; i < distance.length; i++) {
            for (int j = 1; j < distance[0].length; j++) {
                distance[i][j] = Math.min(distance[i - 1][j - 1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1),
                        Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1));
            }
        }
        return distance[word1.length()][word2.length()];
    }
}
