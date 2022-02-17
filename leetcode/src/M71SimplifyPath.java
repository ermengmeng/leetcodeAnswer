import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 7:31 下午
 * @Version 1.0
 */
public class M71SimplifyPath {
    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        LinkedList<String> pathList = new LinkedList<>();
        for (int i = 0; i < splitPath.length; i++) {
            String str = splitPath[i];
            switch (str) {
                case "":
                case ".":
                    break;
                case "..":
                    if (pathList.size() > 0) {
                        pathList.removeLast();
                    }
                    break;
                default:
                    pathList.add(str);
            }
        }
        String ans = "/";
        for (String p : pathList) {
            ans += p + "/";
        }
        return ans.length() > 0 ? ans : ans.substring(0, ans.length() - 1);
    }
}
