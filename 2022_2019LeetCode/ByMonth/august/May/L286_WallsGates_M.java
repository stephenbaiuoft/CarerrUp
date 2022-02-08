package ByMonth.august.May;

public class L286_WallsGates_M {
    
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }

    }
    private void dfs(int[][] rooms, int i, int j, int d) {
        // base condition to return
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d ) {
            return;
        }
        rooms[i][j] = d;
        // now explore other possibilities
        dfs(rooms, i-1, j, d+1);
        dfs(rooms, i+1, j, d+1);
        dfs(rooms, i, j-1, d+1);
        dfs(rooms, i, j+1, d+1);
    }
}
