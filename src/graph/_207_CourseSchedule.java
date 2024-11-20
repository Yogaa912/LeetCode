package graph;

import java.util.*;

public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }

        // 初始化访问状态数组：0=未访问，1=正在访问，2=已完成
        int[] visited = new int[numCourses];

        // 遍历每个节点进行环检测
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false; // 存在环
            }
        }
        return true; // 无环
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) {
            return false; // 存在环
        }
        if (visited[course] == 2) {
            return true; // 已完成
        }

        // 标记为正在访问
        visited[course] = 1;

        // 递归访问邻居
        for (int neighbor : graph.get(course)) {
            if (!dfs(graph, visited, neighbor)) {
                return false; // 存在环
            }
        }

        // 标记为已完成
        visited[course] = 2;
        return true;
    }
}

