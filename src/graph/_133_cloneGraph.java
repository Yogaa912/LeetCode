package graph;
import java.util.*;

import node.Node;
public class _133_cloneGraph {
	public Node cloneGraph(Node node) {
		if(node == null) return null;
		Map<Node, Node> visited = new HashMap<>(); // node, newNode
		return dfs(node, visited);
	}
	private Node dfs(Node node, Map<Node, Node> visited) {
		if(visited.containsKey(node)) return visited.get(node);
		Node newNode = new Node(node.val);
		visited.put(node, newNode);
		for(Node neighbor : node.neighbors) {
			newNode.neighbors.add(dfs(neighbor, visited));
		}
		return newNode;
	}
}
