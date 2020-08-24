package challenges;

public class TreasureIsland
{
    static int minSteps = 0;

    //you can do it in bfs approach if you just use like a queue or something..

    //dfs
    public static int treasureIsland(char[][] island) {
        if (island.length == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[island.length][island[0].length];
        treasureSearch(island, 0, 0, 0, visited);
        return minSteps;
    }

    private static void treasureSearch (char[][] island, int i, int j, int steps, boolean[][] visited)
    {
        if (i < 0 || i >= island.length || j < 0 || j >= island[0].length || island[i][j] == 'D' ||  visited[i][j]) {
            return;
        }

        if (island[i][j] == 'X') {
            minSteps = Math.min(minSteps, steps);
            return;
        }

        visited[i][j] = true;
        steps++;
        treasureSearch(island, i + 1, j, steps, visited);
        treasureSearch(island, i - 1, j, steps, visited);
        treasureSearch(island, i, j + 1, steps, visited);
        treasureSearch(island, i, j - 1, steps, visited);

        visited[i][j] = false;
    }
}
