/*  -------------------------------------------------------
 *  Main.java
 *  -------------------------------------------------------
 *  Author:  Matthew Ferlaino
 *  Date:	 November 12th 2020
 *  Class:   COSC4436
 *  ------------------------------------------------------- */

public class Main {
    public static void main(String[] args) {
        // Adaptive Algorithms
        //new CentralizedAlgorithm().run();
        new DistributedAlgorithm().run();

        // Non-Adaptive Algorithms
        //new FloodingAlgorithm().run();
        //new RandomWalkAlgorithm().run();
    }
}
