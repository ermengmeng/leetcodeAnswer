/**
 * @Author: ouyangyameng
 * @Date: 2023/1/9 13:54
 * @Version 1.0
 */
public class M240SearchA2DMatrix2 {

    /**
     * 循环从右上角开始。
     * 逻辑为
     * 如果当前元素大于target,那么当前行向前可能存在target,当前列向下不可能存在target。
     * 如果当前元素小于target,那么当前行向前不可能存在target,当前列向下可能存在target。
     * 且在上一列和下一行也不会存在搜索方向之后的target。
     *
     * 从左上或右下开始搜索无法判断向哪个方向扩展,存在大量回溯的判断。
     * 从右上或左下搜索可以根据方向确定搜索路径相当于精确剪枝。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;

        int i=0,j=col-1;
        while(i<row && j>=0){

            if(matrix[i][j]==target){
                return true;
            }

            else if(matrix[i][j]>target){

                j--;
            }
            else{
                i++;
            }
        }

        return false;
    }
}
