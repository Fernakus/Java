/*  -------------------------------------------------------
 *  FloodingAlgorithm.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Date:	 November 12th 2020
 *  Class:   COSC4436
 *  ------------------------------------------------------- */
import java.time.LocalTime;
import java.util.ArrayList;

public class FloodingAlgorithm {
    // Variables
    private int[] startingPositions;
    private ArrayList<String[][]> solvedGrids;
    private ArrayList<String[][]> unsolvedGrids;
    private final String[][] baseGrid = {{"-------", "-------", "-------", "-------", "-------", "-------", "-------"},
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
    public FloodingAlgorithm() {
        solvedGrids = new ArrayList<>();
        unsolvedGrids = new ArrayList<>();
        startingPositions = new int[2000];

        for (int i = 0; i < 1000; i++)
            unsolvedGrids.add(cloneGrid(baseGrid));
    }

    /*
     * -- Methods --
     * 1. floodGrid()
     * 2. showGrids()
     * 3. showGrid()
     * 4. run()
     * 5. printResults()
     * 6. cloneGrid()
     */

    // floodGrid()
    private void floodGrid(String[][] networkGrid, int row, int col) {
        if (networkGrid[row][col].equals("NetNode")) {
            // Base Case
            networkGrid[row][col] = "Visited";
            solvedGrids.add(networkGrid);

            // Recursive Calls To Flood
            floodGrid(networkGrid, row + 1, col);
            floodGrid(networkGrid, row - 1, col);
            floodGrid(networkGrid, row, col + 1);
            floodGrid(networkGrid, row, col - 1);
        }
    }

    // showGrids()
    private void showGrids(ArrayList<String[][]> grids) {
        for (String[][] grid : grids) {
            System.out.println();
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++)
                    System.out.print(grid[x][y] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    // showGrid()
    public void showGrid(String[][] grid) {
        System.out.println();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++)
                System.out.print(grid[x][y] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // getStartPositions()
    public int[] getStartPositions() {
        return startingPositions;
    }

    // run()
    public LocalTime[] run() {
        // Start Algorithm
        LocalTime[] times = new LocalTime[2000];
        int row, col;

        // Start Algorithm
        for (int i = 0; i < 1000; i++) {
            row = (int)(Math.random() * (12 - 1 + 1) + 1);
            col = (int)(Math.random() * (5 - 1 + 1) + 1);

            LocalTime start = LocalTime.now();
            floodGrid(unsolvedGrids.get(i), row, col);
            LocalTime end = LocalTime.now();

            times[i] = start;
            times[i+1] = end;

            startingPositions[i] = row;
            startingPositions[i+1] = col;
        }

        return times;
    }

    // printResults()
    public void printResults(LocalTime[] results, int[] startingPositions) {
        System.out.println();
        System.out.println();
        System.out.println("-- Solved Network Grids --");
        showGrids(solvedGrids);

        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------------------------------- Flooding Algorithm Test --------------------------------------------------------------");
        System.out.println(" The flooding algorithm is run on a 2D Matrix [14x7]. It floods the matrix recursively, visiting each indexed position which simulates a network node.");
        System.out.println(" Once the node is visited, it gets marked off as visited. We can see the matrix change as all the unvisited nodes become visited.");
        System.out.println(" This test is run on 5 2D Matrices[14x7], generating a random index point (row,col) to begin at an arbitrary spot in the network.");
        System.out.println(" Running 1000 test cases on 1000 2D Matrices[14x7]...");

        System.out.println();
        System.out.println("-- Starting Network Grid --");
        showGrid(baseGrid);

        int[] differences = new int[1000];
        for (int i = 0; i < results.length/2; i++) {
            System.out.println("-- Results Test #" + (i+1) + " --");
            System.out.println("Starting Coordinates: (" + startingPositions[i] + "," + startingPositions[i+1] + ")");
            System.out.println("Starting Time: " + results[i]);
            System.out.println("Ending Time: " + results[i+1]);
            differences[i] = Math.abs(results[i].getNano() - results[i + 1].getNano());


            System.out.println(String.format("Difference (Nanoseconds): %d", differences[i]));
            System.out.println();
        }

        int avgRuntime = 0;
        for (int i : differences)
            avgRuntime += i;

        System.out.println(String.format("Best Average Runtime: %d", Math.abs(avgRuntime/1000)));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // cloneGrid()
    public String[][] cloneGrid(String[][] grid) {
        String[][] newGrid = new String[14][7];

        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[x].length; y++)
                newGrid[x][y] = grid[x][y];

        return newGrid;
    }
}
