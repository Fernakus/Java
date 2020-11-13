/*  -------------------------------------------------------
 *  FloodingAlgorithm.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Date:	 November 12th 2020
 *  Class:   COSC4436
 *  ------------------------------------------------------- */

public class FloodingAlgorithm {
    // Variables
    private String[][] grid = {{"-------", "-------", "-------", "-------", "-------", "-------", "-------"},
                               {"-------", "NetNode", "NetNode", "NetNode", "NetNode", "NetNode", "-------"},
                               {"-------", "-------", "NetNode", "-------", "NetNode", "-------", "-------"},
                               {"-------", "-------", "-------", "NetNode", "NetNode", "-------", "-------"},
                               {"-------", "NetNode", "NetNode", "NetNode", "-------", "-------", "-------"},
                               {"-------", "NetNode", "-------", "-------", "-------", "-------", "-------"},
                               {"-------", "NetNode", "NetNode", "NetNode", "NetNode", "NetNode", "-------"},
                               {"-------", "-------", "-------", "-------", "-------", "NetNode", "-------"},
                               {"-------", "NetNode", "NetNode", "NetNode", "NetNode", "NetNode", "-------"},
                               {"-------", "-------", "NetNode", "-------", "NetNode", "-------", "-------"},
                               {"-------", "-------", "-------", "NetNode", "NetNode", "-------", "-------"},
                               {"-------", "NetNode", "NetNode", "NetNode", "-------", "-------", "-------"},
                               {"-------", "NetNode", "-------", "-------", "-------", "-------", "-------"},
                               {"-------", "-------", "-------", "-------", "-------", "-------", "-------"}};

    // No-arg Constructor
    public FloodingAlgorithm() {}

    // floodGrid()
    private void floodGrid(String[][] networkGrid, int row, int col) {
        if (networkGrid[row][col].equals("NetNode")) {
            // Base Case
            networkGrid[row][col] = "Visited";
            showGrid(networkGrid);

            // Recursive Calls To Flood
            floodGrid(networkGrid, row + 1, col);
            floodGrid(networkGrid, row - 1, col);
            floodGrid(networkGrid, row, col + 1);
            floodGrid(networkGrid, row, col - 1);
        }
    }

    // showGrid()
    private void showGrid(String[][] grid) {
        System.out.println();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++)
                System.out.print(grid[x][y] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // run()
    public void run() {
        System.out.println("--- Flooding Algorithm Test ---");
        System.out.println("Starting Coordinates: (3,3)");
        showGrid(grid);

        // Start Algorithm
        java.time.LocalTime start = java.time.LocalTime.now();
        floodGrid(grid, 3, 3);
        java.time.LocalTime end = java.time.LocalTime.now();

        System.out.println("Starting Time: " + start);
        System.out.println("Ending Time: " + end);
        System.out.println("Difference (Nanoseconds): " + (end.getNano() - start.getNano()));
    }
}
