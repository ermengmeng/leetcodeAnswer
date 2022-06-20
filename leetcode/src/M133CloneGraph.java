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

    /**
     * 普通的bfs
     * 遍历每一层没处理过的节点,处理单向的neighbors信息
     * 少量紧凑的整数key，用数组下标代替map的key取值效率高很多。
     * 具体看题目要求的key值域是否合适映射成紧凑的下标。
     * @param node
     * @return
     */
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        GraphNode[] visited = new GraphNode[101];
        List<GraphNode> list = Arrays.asList(node);
        while (list.size() > 0) {
            List<GraphNode> next = new ArrayList<>();
            for (GraphNode cur : list) {
                if (visited[cur.val] == null) {
                    visited[cur.val] =  new GraphNode(cur.val);
                }
                for (GraphNode neighbor : cur.neighbors) {
                    if (visited[neighbor.val] == null) {
                        visited[neighbor.val] = new GraphNode(neighbor.val);
                        next.add(neighbor);
                    }
                    visited[cur.val].neighbors.add(visited[neighbor.val]);
                }
            }
            list = next;
        }
        return visited[1];
    }
}
