package google;

import java.util.*;

public class LakeCounter {
    private static final String LAND = "green";
    private static final String WATER = "blue";

    // 8 directions for land (N, NE, E, SE, S, SW, W, NW)
    private static final int[][] DIR8 = {
            {-1, 0},  // top
            {-1, 1},  // top-right
            {0, 1},   // right
            {1, 1},   // bottom-right
            {1, 0},   // bottom
            {1, -1},  // bottom-left
            {0, -1},  // left
            {-1, -1}  // top-left
    };

    // 4 directions for water (N, E, S, W)
    private static final int[][] DIR4 = {
            {-1, 0}, // top
            {0, 1},  // right
            {1, 0},  // bottom
            {0, -1}  // left
    };

    private static class Coord {
        int row, col;
        Coord(int r, int c) { row = r; col = c; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coord)) return false;
            Coord coord = (Coord) o;
            return row == coord.row && col == coord.col;
        }
        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static int countLakes(String[][] image, Coord startCoord) {
        Set<Coord> visited = new HashSet<>();
        Set<Coord> borderlineWater = new HashSet<>();

        findBorderlineWater(image, startCoord, visited, borderlineWater);

        int count = 0;
        while (!borderlineWater.isEmpty()) {
            Coord waterCoord = borderlineWater.iterator().next();
            borderlineWater.remove(waterCoord);
            deleteBorderWaterline(waterCoord, borderlineWater);
            count++;
        }
        return Math.max(0, count - 1); // subtract 1 (ocean component)
    }

    private static boolean isLand(String[][] image, Coord coord) {
        int r = coord.row;
        int c = coord.col;
        return r >= 0 && r < image.length &&
                c >= 0 && c < image[r].length &&
                LAND.equals(image[r][c]);
    }

    private static void findBorderlineWater(String[][] image, Coord coord,
                                            Set<Coord> visited, Set<Coord> borderlineWater) {
        if (!isLand(image, coord)) return;
        if (visited.contains(coord)) return;

        visited.add(coord);
        for (int[] d : DIR8) {
            int r = coord.row + d[0];
            int c = coord.col + d[1];
            Coord neighbor = new Coord(r, c);
            if (isLand(image, neighbor)) {
                findBorderlineWater(image, neighbor, visited, borderlineWater);
            } else {
                borderlineWater.add(neighbor);
            }
        }
    }

    private static void deleteBorderWaterline(Coord coord, Set<Coord> borderlineWater) {
        for (int[] d : DIR4) {
            int r = coord.row + d[0];
            int c = coord.col + d[1];
            Coord neighbor = new Coord(r, c);
            if (borderlineWater.remove(neighbor)) {
                deleteBorderWaterline(neighbor, borderlineWater);
            }
        }
    }

    public static void main(String[] args) {
        // Example image setup
        String[][] image = new String[8][20];
        for (int row = 0; row < image.length; row++)
            Arrays.fill(image[row], WATER);

        // Add first island (horizontal: (2,2) to (4,2))
        image[2][2] = LAND;
        image[2][3] = LAND;
        image[2][4] = LAND;

        // Add second 3x3 island with a lake at center
        for (int r = 4; r <= 6; r++)
            for (int c = 5; c <= 7; c++)
                image[r][c] = LAND;
        image[5][6] = WATER; // central lake

        // Add third island with two lakes inside
        for (int r = 3; r <= 5; r++)
            for (int c = 11; c <= 16; c++)
                image[r][c] = LAND;
        image[4][12] = WATER;
        image[4][14] = WATER;
        image[4][15] = WATER;

        // Sample lake counts
        System.out.println(countLakes(image, new Coord(2, 2)));   // should print 0
        System.out.println(countLakes(image, new Coord(6, 6)));   // should print 1
        System.out.println(countLakes(image, new Coord(12, 5)));  // should print 2
    }
}