import common.GraphNode;

import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/20 17:00
 * @Version 1.0
 */
public class M133CloneGraph {
    public static void main(String[] args) {

    }
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, GraphNode> map = new HashMap<>();
        List<GraphNode> list = Arrays.asList(node);
        while (list.size() > 0) {
            List<GraphNode> next = new ArrayList<>();
            for (GraphNode cur : list) {
                if (!map.containsKey(cur.val)) {
                    map.put(cur.val, new GraphNode(cur.val));
                }
                GraphNode curClone = map.get(cur.val);
                for (GraphNode neighbor : cur.neighbors) {
                    if (!map.containsKey(neighbor.val)) {
                        map.put(neighbor.val, new GraphNode(neighbor.val));
                        next.add(neighbor);
                    }
                    curClone.neighbors.add(map.get(neighbor.val));
                }
            }
            list = next;
        }
        return map.get(1);
    }
}
