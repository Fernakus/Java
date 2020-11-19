/*  -------------------------------------------------------
 *  RandomWalkAlgorithm.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Date:	 November 12th 2020
 *  Class:   COSC4436
 *  ------------------------------------------------------- */

import java.util.Random;

public class RandomWalkAlgorithm {
    // Variables
    private Random random;
    private final int MAX_STEPS = 1000;
    private int stepsTaken, x, y;

    // No-arg Constructor
    public RandomWalkAlgorithm() {
        random = new Random();
        stepsTaken = 0;
        x = 3;
        y = 3;
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

    // run()
    public void run() {
        java.time.LocalTime start = java.time.LocalTime.now();
        while ((Math.abs(x) + Math.abs(y)) < MAX_STEPS) {
            switch (random.nextInt(4)) {
                // North
                case 0:
                    y += 1;
                    stepsTaken++;
                    System.out.println("(" + x  + ", " + y + ")");
                    break;

                // South
                case 1:
                    y -= 1;
                    stepsTaken++;
                    System.out.println("(" + x  + ", " + y + ")");
                    break;

                // West
                case 2:
                    x += 1;
                    stepsTaken++;
                    System.out.println("(" + x  + ", " + y + ")");
                    break;

                // East
                case 3:
                    x -= 1;
                    stepsTaken++;
                    System.out.println("(" + x  + ", " + y + ")");
                    break;
            }
        }
        java.time.LocalTime end = java.time.LocalTime.now();

        System.out.println();
        System.out.println("Starting Time: " + start);
        System.out.println("Ending Time: " + end);
        System.out.println("Difference (Nanoseconds): " + Math.abs(end.getNano() - start.getNano()));
        System.out.println("Steps Taken = " + stepsTaken);
    }
}
