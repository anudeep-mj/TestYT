package challenges;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
 * Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Input:
 * image =
 * [[1,1,1],
 * [1,1,0],
 * [1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output:
 * [[2,2,2],
 * [2,2,0],
 * [2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 */
public class ImageFloodFIll {
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0) {
            return image;
        }

        boolean[][] visited = new boolean[image.length][image[0].length];
        //image[sr][sc] = newColor;

        floodFillHelper(image, sr, sc, image[sr][sc], newColor, visited);
        return image;
    }

    public void floodFillHelper(int[][] image, int r, int c,
                                int origColor, int newColor, boolean[][] visited) {
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || visited[r][c]) {
            return;
        }

        int colorAtRC = image[r][c];
        if(colorAtRC != origColor) {
            return;
        }


        //System.out.println("r:"+r + "c:" + c);

        image[r][c] = newColor;
        visited[r][c] = true;

        for(int[] direction : directions) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];
            //System.out.println("hereeee");
            floodFillHelper(image, newRow, newCol, origColor, newColor, visited);
        }
    }
}
