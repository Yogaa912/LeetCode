package graph;

public class _200_numberOfIslands {
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int count = 0, rows = grid.length, cols = grid[0].length;
		for(int i = 0; i < rows; i ++) {
			for(int j = 0; j < cols; j ++) {
				if(grid[i][j] == '1') {
					count ++;
					DFS(grid, i, j);
				}
			}
		}
		return count;
	}
	private void DFS(char[][] grid, int row, int col) {
		int rows = grid.length;
		int cols = grid[0].length;
		if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
			return; // exceed the limit, directl
		}
		// mark the grid as isVisited
		grid[row][col] = '0';
		// visit 4 directions
		DFS(grid, row - 1, col);
		DFS(grid, row + 1, col);
		DFS(grid, row, col - 1);
		DFS(grid, row, col + 1);
	}
}
