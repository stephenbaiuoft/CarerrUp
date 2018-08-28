package Leetcode;

public class L886_M {
    public L886_M() {
        int[][] dislikes = new int[][]{
            {1,2},
            {1,3},
                {2,4}
        };
        int N = 4;

        boolean rez = possibleBipartition(N, dislikes);
        System.out.print(rez);

    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] map = new int[N+1][N+1];
        // build the map graph
        // based on dislikes <--> s.t you can map to each other
        for(int[] dislike: dislikes) {
            map[dislike[0]][dislike[1]] = 1;
            map[dislike[1]][dislike[0]] = 1;
        }

        // Key!!! dfs! 因为 think about the sample
        // [1,3], [4,2], [2,3] 如果不是dfs来做 其实result是false
        // 但是其实是可以分开的 (1,2) (4,3) 就可以!!!

        // visited stores personValue for each person
        int[] visited = new int[N+1];

        for(int pI = 1; pI <= N; pI++ ){
            if (visited[pI] == 0 && !dfs(visited, map, pI, 1))
                return false;
        }
        return true;
    }

    // dfs that person's list, person and person's value marked
    // false if cannot separate!!!
    private boolean dfs(int[] visited, int[][] map, int person, int pVal) {
        // base case
        if (visited[person] != 0) return visited[person] == pVal;

        // set pVal
        visited[person] = pVal;
        // get the listed map person
        int[] list = map[person];
        // (1 - N-1)
        for(int i = 1; i < list.length; i++) {
            if (list[i] == 1) {
                if (!dfs(visited, map, i, -pVal)) return false;
            }
        }

        return true;
    }
}
