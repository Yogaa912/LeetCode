import java.util.*;

import node.Node;

public class _133_cloneGraph {
	// 答题代码框架
	public Node cloneGraph(Node node) {
        if (node == null) return null;

        // 用于存储原节点到克隆节点的映射
        Map<Node, Node> visited = new HashMap<>();

        // 深度优先搜索函数
        return dfs(node, visited);
    }
	
    private Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node); // 如果已克隆过，直接返回
        }

        // 克隆当前节点
        Node clone = new Node(node.val);
        visited.put(node, clone); // 加入映射

        // 克隆邻居
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }
    public Node cloneGraph_bfs(Node node) {
        if (node == null) return null;

        // 用于存储原节点到克隆节点的映射
        Map<Node, Node> visited = new HashMap<>();
        // 初始化队列
        Queue<Node> queue = new LinkedList<>(); // 如果是BFS就不需要，直接调用自己 

        // 克隆起始节点
        Node clone = new Node(node.val);
        visited.put(node, clone);
        queue.add(node); // 将原始节点加入队列

        // 广度优先搜索
        while (!queue.isEmpty()) {
            Node current = queue.poll(); // 取出队首节点

            System.out.println("正在处理节点 " + current.val);

            for (Node neighbor : current.neighbors) { // 遍历neighbor
                if (!visited.containsKey(neighbor)) { // 如果邻居未被克隆
                    System.out.println("克隆节点 " + neighbor.val);
                    Node neighborClone = new Node(neighbor.val); // 克隆邻居
                    visited.put(neighbor, neighborClone);
                    queue.add(neighbor); // 加入队列继续处理
                }
                // 将克隆的邻居加入当前克隆节点的邻居列表
                visited.get(current).neighbors.add(visited.get(neighbor));
                System.out.println("节点 " + current.val + " 的克隆节点连接到 " + neighbor.val + " 的克隆节点");
            }
        }

        return clone;
    }
	// 测试代码
    public static void main(String[] args) {
        // 创建测试图
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // 调用克隆函数
        _133_cloneGraph solution = new _133_cloneGraph();
        Node clonedGraph = solution.cloneGraph(node1);

        // 测试结果打印
        System.out.println("Original Graph:");
        printGraph(node1, new HashSet<>());

        System.out.println("\nCloned Graph:");
        printGraph(clonedGraph, new HashSet<>());
    }
    // 打印图结构
    public static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.print("Node " + node.val + " -> ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
}
