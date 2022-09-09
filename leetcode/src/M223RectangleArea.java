/**
 * @Author: ouyangyameng
 * @Date: 2022/9/9 14:01
 * @Version 1.0
 */
public class M223RectangleArea {

    public static void main(String[] args) {
        System.out.println(new M223RectangleArea().computeArea(-2,-2,2,2,-2,-2,2,2));
    }



    //简单的考虑互相之间的关系进行判断
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        //完全不重叠的状态
        if (ax1 >= bx2 || bx1>=ax2 || ay1 >= by2 || by1 >= ay2) {
            return area1 + area2;
        }
        //内嵌的状态
        if (by2 <= ay2 && bx2 <= ax2 && by1 >= ay1 && bx1 >= ax1) {
            return area1;
        }
        if (by2 >= ay2 && bx2 >= ax2 && by1 <= ay1 && bx1 <= ax1) {
            return area2;
        }
        //重叠的状态
        int depArea = (Math.min(ay2,by2) - Math.max(ay1,by1)) * (Math.min(ax2,bx2) - Math.max(ax1,bx1));
        return area2 + area1 - depArea;
    }
}
